package io.code.myapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.jape.EntityFacade;
import br.com.sankhya.jape.util.FinderWrapper;
import br.com.sankhya.jape.vo.DynamicVO;
import br.com.sankhya.modelcore.util.EntityFacadeFactory;
import dominio.Monitoramento;

public class Main implements AcaoRotinaJava {
	
	@Override
	public void doAction(ContextoAcao contexto) throws Exception {	
	
		List<Monitoramento> monitoramentos = buscaParceiros();
		
		for(Monitoramento monitor : monitoramentos) {
			ServicoAPI.monitorar(monitor.getSkwuser(), monitor.getSkwpassword(), monitor.getSkwurl(), monitor.getPecurl(), monitor.getCodparc());
		}
		
	}

	private List<Monitoramento> buscaParceiros() throws Exception {
		List<Monitoramento> monitoramentos = new ArrayList<>();
		EntityFacade dwffacade = EntityFacadeFactory.getDWFFacade();
		FinderWrapper finder = new FinderWrapper("AD_DASMON", "");
		Collection<DynamicVO> listaBusca = dwffacade.findByDynamicFinderAsVO(finder);
		
		for(DynamicVO vo : listaBusca) {
			Monitoramento monitor = new Monitoramento();
			monitor.setCodparc(vo.asBigDecimal("CODPARC"));
			monitor.setSkwuser(vo.asString("SKWUSER"));
			monitor.setSkwpassword(vo.asString("SKWPASSWORD"));
			monitor.setSkwurl(vo.asString("URLSKW"));
			monitor.setPecurl(vo.asString("URLPEC"));
			monitoramentos.add(monitor);
		}
		
		return monitoramentos;
	}

}

package io.code.myapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import br.com.sankhya.jape.EntityFacade;
import br.com.sankhya.jape.core.JapeSession;
import br.com.sankhya.jape.core.JapeSession.SessionHandle;
import br.com.sankhya.jape.vo.DynamicVO;
import br.com.sankhya.jape.vo.EntityVO;
import br.com.sankhya.modelcore.util.EntityFacadeFactory;
import dominio.Historico;

public class ServicoAPI {
	
	public static HttpURLConnection montarConexao(String skw_user, String skw_password, String skw_url, BigDecimal skw_company_id) throws IOException {
		URL url = new URL(skw_url);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("SKW_USER", skw_user);
        requestBody.addProperty("SkW_PASSWORD", skw_password);
        requestBody.addProperty("SkW_COMPANY_ID", skw_company_id);

        OutputStream os = conn.getOutputStream();
        byte[] input = requestBody.toString().getBytes("utf-8");
        os.write(input, 0, input.length);
        os.flush();
        os.close();

        conn.connect();
        
        return conn;
    }
	
	public static void monitorar(String skw_user, String skw_password, String skw_url, BigDecimal codparc) throws Exception {
		
		try {
			HttpURLConnection conexao = montarConexao(skw_user, skw_password, skw_url, codparc);
			
			BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			String jsonEmString = Util.converteJsonEmString(resposta);
			
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			Historico historico = gson.fromJson(jsonEmString, Historico.class);
			
			historico.setCodparc(codparc.toString());
			///imprimir(historico);
			salvarInformacoes(historico);
			
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
		
	}
	
	public static void salvarInformacoes(Historico historico) throws Exception {
		SessionHandle hnd = null;
		
		try {
			hnd = JapeSession.open();
			EntityFacade dwfFacade = EntityFacadeFactory.getDWFFacade();

			DynamicVO vo = (DynamicVO) dwfFacade.getDefaultValueObjectInstance("AD_DASSMO");
			vo.setProperty("CODPARC", new BigDecimal(historico.getCodparc()));
			vo.setProperty("NEGOCIO", historico.getNegocio());
			vo.setProperty("VERSAOSISTEMA", historico.getVersaoSistema());
			vo.setProperty("BANCO", historico.getBanco());
			vo.setProperty("DESCRICAO", historico.getExtensao().getDescricao());
			vo.setProperty("VERSAODESCRICAO", historico.getExtensao().getVersao());
			vo.setProperty("DATAHORAINSTALACAO", historico.getExtensao().getDataHoraInstalacao());
			vo.setProperty("DATAHORABUILD", historico.getExtensao().getDataHoraBuild());
			dwfFacade.createEntity("AD_DASSMO", (EntityVO) vo);
			
		} finally {
		    JapeSession.close(hnd);
		}
		
	}
	
	/*private static void imprimir(Historico historico) {
		System.out.println("codParc: " + historico.getCodparc());
		System.out.println("negocio: " + historico.getNegocio());
		System.out.println("versaoSistema: " + historico.getVersaoSistema());
		System.out.println("banco: " + historico.getBanco());
		System.out.println("descrição: " + historico.getExtensao().getDescricao());
		System.out.println("versão descrição: " + historico.getExtensao().getVersao());
		System.out.println("data hora instalacao: " + historico.getExtensao().getDataHoraInstalacao());
		System.out.println("data hora build: " + historico.getExtensao().getDataHoraBuild())
		
	}*/
}


















































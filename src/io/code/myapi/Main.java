package io.code.myapi;

import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;

public class Main implements AcaoRotinaJava{
	public static void main(String[] args) throws Exception {
		final String SKW_USER = "PEC";
		final String SKW_PASSWORD = "Jv120910";
		final String SKW_URL = "http://45.236.220.234:8180/codepec/info";
		final String SKW_COMPANY_ID = null;
		
		ServicoAPI.monitorar(SKW_USER, SKW_PASSWORD, SKW_URL, SKW_COMPANY_ID);
		///ServicoAPI.salvarInformacao(SKW_COMPANY_ID);
	}
	@Override
	public void doAction(ContextoAcao contexto) throws Exception {
		contexto.setMensagemRetorno("deu certo");
		
	}
}

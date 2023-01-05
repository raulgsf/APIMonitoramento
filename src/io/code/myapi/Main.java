package io.code.myapi;

public class Main {
	public static void main(String[] args) throws Exception {
		final String SKW_USER = "PEC";
		final String SKW_PASSWORD = "Jv120910";
		final String SKW_URL = "http://45.236.220.234:8180/codepec/info";
		final String SKW_COMPANY_ID = null;
		
		ServicoAPI.monitorar(SKW_USER, SKW_PASSWORD, SKW_URL, SKW_COMPANY_ID);
		
	}
}

package io.code.myapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import dominio.Historico;

public class ServicoAPI {
	static String webService = " http://45.236.220.234:8180/codepec/info ";
	
	public static HttpURLConnection montarConexao(String skw_user, String skw_password, String skw_company_id) throws IOException {
		URL url = new URL(skw_company_id);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//conn = ;//requisitar metodo post 
		//conn = ;//requisitar content-type e application/json
		
		return (HttpURLConnection) url.openConnection();
	}
	
	public static void monitorar(String skw_user, String skw_password, String skw_company_id) throws Exception {
		
		try {
			HttpURLConnection conexao = montarConexao(skw_user, skw_password, skw_company_id);
			
			BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			String jsonEmString = Util.converteJsonEmString(resposta);
			
			Gson gson = new Gson();
			Historico historico = gson.fromJson(jsonEmString, Historico.class);
			
			imprimir(historico);
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
		
	}

	private static void imprimir(Historico historico) {
		System.out.println("codParc: " + historico.getCodparc());
		System.out.println("negocio: " + historico.getNegocio());
		System.out.println("versaoSistema: " + historico.getVersaosistema());
		System.out.println("banco: " + historico.getBanco());
		System.out.println("extensao: " + historico.getExtensao());
		
	}
	
}




















package io.code.myapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dominio.Historico;

public class ServicoAPI {
	
	public static HttpURLConnection montarConexao(String skw_user, String skw_password, String skw_url, String skw_company_id) throws IOException {
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
	
	public static void monitorar(String skw_user, String skw_password, String skw_url, String skw_company_id) throws Exception {
		
		try {
			HttpURLConnection conexao = montarConexao(skw_user, skw_password, skw_url, skw_company_id);
			
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
		System.out.println("descrição: " + historico.getExtensao().getDescricao());
		System.out.println("versaõ descrição: " + historico.getExtensao().getVersao());
		System.out.println("data hora instalacao: " + historico.getExtensao().getDataHoraInstalacao());
		System.out.println("data hora build: " + historico.getExtensao().getDataHoraBuild());
		
	}
	
}


















































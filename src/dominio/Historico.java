package dominio;

public class Historico {
	String codparc;
	String negocio;
	String versaosistema;
	String banco;
	Extensao extensao;
	
	public String getCodparc() {
		return codparc;
	}
	
	public String getNegocio() {
		return negocio;
	}
	
	public String getVersaosistema() {
		return versaosistema;
	}
	
	public String getBanco() {
		return banco;
	}
	
	public Extensao getExtensao() {
		return extensao;
	}
	
	public class Extensao{
		String descricao;
		String versao;
		String dataHoraInstalacao;
		String dataHoraBuild;
		
		public String getDescricao() {
			return descricao;
		}
		
		public String getVersao() {
			return versao;
		}
		
		public String getDataHoraInstalacao() {
			return dataHoraInstalacao;
		}
		
		public String getDataHoraBuild() {
			return dataHoraBuild;
		}
		
	}
	
}

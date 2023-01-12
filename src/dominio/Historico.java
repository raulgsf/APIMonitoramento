package dominio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Historico {
	String codparc;
	Integer sequencia;
	String negocio;
	String versaoSistema;
	String banco;
	Extensao extensao;
	
	public String getCodparc() {
		return codparc;
	}
	
	public Integer getSequencia() {
		return sequencia;
	}
	
	public String getNegocio() {
		return negocio;
	}
	
	public String getVersaoSistema() {
		return versaoSistema;
	}
	
	public String getBanco() {
		return banco;
	}
	
	public void setCodparc(String codparc) {
		this.codparc = codparc;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}
	
	public void setNegocio(String negocio) {
		this.negocio = negocio;
	}

	public void setVersaoSistema(String versaoSistema) {
		this.versaoSistema = versaoSistema;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public void setExtensao(Extensao extensao) {
		this.extensao = extensao;
	}
	
	public Extensao getExtensao() {
		return extensao;
	}
	
	public class Extensao{
		String descricao;
		String versao;
		Timestamp dataHoraInstalacao;
		Timestamp dataHoraBuild;
		Timestamp dataHoraMonitoramento;
		String tipo;
		
		public String getDescricao() {
			return descricao;
		}
		
		public String getVersao() {
			return versao;
		}
		
		public Timestamp getDataHoraInstalacao() {
			return dataHoraInstalacao;
		}
		
		public Timestamp getDataHoraBuild() {
			return dataHoraBuild;
		}
		
		public Timestamp getDataHoraMonitoramento() {
			return dataHoraMonitoramento;
		}
		
		public String getTipo() {
			return tipo;
		}
	}	
}

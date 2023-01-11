package dominio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Historico {
	BigDecimal codparc;
	Integer sequencia;
	String negocio;
	String versaoSistema;
	String banco;
	Extensao extensao;
	
	public BigDecimal getCodparc() {
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
	
	public void setCodparc(BigDecimal codparc) {
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
		BigDecimal versao;
		Timestamp dataHoraInstalacao;
		Timestamp dataHoraBuild;
		Timestamp dataHoraMonitoramento;
		String tipo;
		
		public String getDescricao() {
			return descricao;
		}
		
		public BigDecimal getVersao() {
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

package dominio;

import java.math.BigDecimal;

public class Monitoramento {
	String dados;
	String skwurl;
	String pecurl;
	String skwuser;
	String skwpassword;
	BigDecimal codparc;

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
	}
	
	public String getSkwurl() {
		return skwurl;
	}
	
	public void setSkwurl(String skwurl) {
		this.skwurl = skwurl;
	}
	
	public String getPecurl() {
		return pecurl;
	}

	public void setPecurl(String pecurl) {
		this.pecurl = pecurl;
	}
	
	public String getSkwuser() {
		return skwuser;
	}

	public void setSkwuser(String skwuser) {
		this.skwuser = skwuser;
	}

	public String getSkwpassword() {
		return skwpassword;
	}

	public void setSkwpassword(String skwpassword) {
		this.skwpassword = skwpassword;
	}

	public BigDecimal getCodparc() {
		return codparc;
	}

	public void setCodparc(BigDecimal bigDecimal) {
		this.codparc = bigDecimal;
	}

	@Override
	public String toString() {
		return "Dados [dados=" + skwuser + skwpassword + codparc + "]";
	}
}

package dominio;

public class Monitoramento {
	String dados;
	String skwuser;
	String skwpassword;
	String codparc;
	
	public String getSKWUSER() {
		return skwuser;
	}
	
	public String getSKWPASSWORD() {
		return skwpassword;
	}
	
	public String getCODPARC() {
		return codparc;
	}
	
	@Override
	public String toString() {
		return "Dados [dados=" + skwuser + skwpassword + codparc + "]";
	}
}

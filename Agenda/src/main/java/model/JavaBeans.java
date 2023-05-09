package model;

public class JavaBeans {
	private String idcon;
	private String nome;
	private String telefone;
	private String email;
	

	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JavaBeans(String idcon, String nome, String telefone, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}


	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

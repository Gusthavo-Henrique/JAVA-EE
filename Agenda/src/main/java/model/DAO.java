package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// **Módulo de conexão**/

	// parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/DB_AGENDA?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Kuuroneekoo1#";

	// metodos de conexao
	private Connection conectar() {
		Connection con = null;
		try { // Caso conexao de certo
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password); // obter os parametros de conexao
			return con;
		} catch (Exception e) { // caso nao de certo exception
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/
	public void inserirContato(JavaBeans contato) {
		String create = "INSERT INTO CONTATOS (nome, telefone, email) values (?,?,?)";
		try {
			// abrir conexao
			Connection con = conectar();

			// preparar a query para a execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);

			// substituir os parametros(???) pelo conteudo das variaveis javabeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getEmail());

			// Exercutar a query
			pst.executeUpdate();

			// Encerrar a conexao com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> ListarContatos() {
		// criando um objeto para acessar a classe javabens
		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String read = "SELECT * FROM CONTATOS ORDER BY idcon;";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// laço abaixo sera executado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que recebem os dados no banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String email = rs.getString(4);
				// populando o arraylist
				contatos.add(new JavaBeans(idcon, nome, telefone, email));
			}
			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	/**CRUD UPDATE**/
	//Mewtodo de selecionar contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "SELECT * FROM CONTATOS WHERE idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				//Setar as variaveis javabeans
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setTelefone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void alterarContato(JavaBeans contato) {
		String create = "UPDATE CONTATOS SET nome=?,telefone=?,email=? WHERE idcon=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void deletarContato(JavaBeans contato) {
		String del = "DELETE FROM CONTATOS WHERE idcon=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(del);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

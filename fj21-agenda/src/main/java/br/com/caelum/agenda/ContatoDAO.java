package br.com.caelum.agenda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDAO {
	private Connection connection;

	public ContatoDAO() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adiciona(Contato contato){
		try {
			String sql = "insert into contatos(nome,endereco,email,dataNascimento) values(?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEndereco());
			stmt.setString(3, contato.getEmail());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List getList(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getTime("dataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		
	}
	
	public void remove(Contato contato) {
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}

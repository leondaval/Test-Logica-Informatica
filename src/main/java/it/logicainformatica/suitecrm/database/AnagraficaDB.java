package it.logicainformatica.suitecrm.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import it.logicainformatica.suitecrm.bean.AnagraficaUtente;

public class AnagraficaDB {

	Database db = new Database();

	// INSERISCI DATI UTENTI SUL DB
	public void inserisciUtente(AnagraficaUtente a) {

		Connection dbconn = null;
		try {

			dbconn = db.getConnessione();

			PreparedStatement statement = dbconn.prepareStatement(
			"Insert into anagrafica(nome,cognome,email,telefono,cf,indirizzo,paese) values (?,?,?,?,?,?,?)");

			statement.setString(1, a.getNome());
			statement.setString(2, a.getCognome());
			statement.setString(3, a.getEmail());
			statement.setString(4, a.getTelefono());
			statement.setString(5, a.getCf());
			statement.setString(6, a.getIndirizzo());
			statement.setString(7, a.getPaese());

		    statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbconn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// METODO PER VISUALIZZARE DATI PRESENTI SUL DB
	public List<AnagraficaUtente> getAnagraficaAll() {

		Connection dbconn = null;

		List<AnagraficaUtente> lista = new ArrayList<AnagraficaUtente>();

		try {

			dbconn = db.getConnessione();

			PreparedStatement statement = dbconn.prepareStatement("SELECT * FROM anagrafica");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				AnagraficaUtente ana = new AnagraficaUtente();

				ana.setId(rs.getInt("id"));
				ana.setNome(rs.getString("nome"));
				ana.setCognome(rs.getString("cognome"));
				ana.setTelefono(rs.getString("telefono"));
				ana.setIndirizzo(rs.getString("indirizzo"));
				ana.setCf(rs.getString("cf"));
				ana.setEmail(rs.getString("email"));
				ana.setPaese(rs.getString("paese"));

				lista.add(ana);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbconn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;

	}

	// INSERISCI DATI UTENTI SU FILE TXT
	public void inserisciUtenteTXT(AnagraficaUtente a) {

	        try {
	            FileWriter writer = new FileWriter("anagrafica.txt");
	            writer.write("Nome: " + a.getNome());
	            writer.write("Cognome: " + a.getCognome());
	            writer.write("Telefono: " + a.getTelefono());
	            writer.write("Paese: " + a.getPaese());
	            writer.write("Codice fiscale: " + a.getCf());
	            writer.write("Email: " + a.getEmail());
	            writer.write("Indirizzo: " + a.getIndirizzo());
	            writer.close();
	        	}catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	// METODO PER VISUALIZZARE DATI PRESENTI SU FILE TXT
	public List<AnagraficaUtente> getAnagraficaAllTXT() {
		
		List<AnagraficaUtente> lista = new ArrayList<AnagraficaUtente>();
			
			try {
		        BufferedReader reader = new BufferedReader(new FileReader("anagrafica.txt"));
		        String line = reader.readLine();
		        while(line!=null) {
		             line = reader.readLine();
		        }
		        
		    }catch(IOException e){
		        e.printStackTrace();
		    }
			
			return lista;
	}
	
}
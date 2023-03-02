package it.logicainformatica.suitecrm.restexample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import it.logicainformatica.suitecrm.bean.AnagraficaUtente;
import it.logicainformatica.suitecrm.database.AnagraficaDB;

@RestController
@RequestMapping("/gestione-anagrafica")
public class AnagraficaController {

	AnagraficaDB anagraficaDB = new AnagraficaDB();

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void inserisciAnagrafica(@RequestBody AnagraficaUtente anag) {
		anagraficaDB.inserisciUtente(anag);
	}
	
	@PostMapping("/Inserisci-anagrafica-TXT")
	@ResponseStatus(HttpStatus.OK)
	public void inserisciAnagraficaTXT(@RequestBody AnagraficaUtente anag) {
		anagraficaDB.inserisciUtenteTXT(anag);
	}

	@GetMapping("/getListaAnagrafica")
	public List<AnagraficaUtente> getListaAnagrafica() {
		List<AnagraficaUtente> lista = anagraficaDB.getAnagraficaAll();
		return lista; //ritorna oggetto response
	}

	@GetMapping("/getListaAnagrafica-TXT")
	public ResponseEntity<String> getListaAnagraficaTXT() {
		
		try {
			
			File file = new File("crm.txt");

			BufferedReader reader = new BufferedReader(new FileReader(file));

			StringBuilder sb = new StringBuilder();
			String line;
			
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}

			reader.close();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.TEXT_PLAIN);
			return new ResponseEntity<String>(sb.toString(), headers, HttpStatus.OK);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Errore", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
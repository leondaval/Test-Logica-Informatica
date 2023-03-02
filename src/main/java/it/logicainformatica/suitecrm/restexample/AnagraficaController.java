package it.logicainformatica.suitecrm.restexample;

import java.util.List;
import org.springframework.http.HttpStatus;
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
	public List<AnagraficaUtente> getListaAnagraficaTXT() {
		List<AnagraficaUtente> lista = anagraficaDB.getAnagraficaAllTXT();
		return lista; //ritorna oggetto response
	}
}
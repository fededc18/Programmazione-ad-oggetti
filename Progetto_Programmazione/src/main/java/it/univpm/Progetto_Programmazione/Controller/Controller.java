package it.univpm.Progetto_Programmazione.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.Dati_Europa.Model.MainCat;
import it.univpm.Dati_Europa.Services.Services;
import it.univpm.Progetto_Programmazione.GestioneDati.*;
import it.univpm.Progetto_Programmazione.GestioneDati.EuropeanUn;
import it.univpm.Progetto_Programmazione.Model.MacroCat;
import it.univpm.Progetto_Programmazione.Model.SubCat;
import it.univpm.Progetto_Programmazione.Service.*;
import it.univpm.Progetto_Programmazione.Service.Service;

/*
 * Classe concepita per gestire le richieste effetuate dall'utente
 */

public class Controller {
	
	@Autowired
	private Service servizio;
	
	/*
	 * Costruttore della classe
	 * Grazie a @Autowired viene lanciato automaticamnete all'avvio i String 
	 * ed esegue il collegamento con Service
	 */
	
	public Controller(Service servizio)
	{
		this.servizio = servizio;
	}
	
	/**
	 * Metodi per la comunicazione con il client che gestiscono le richieste get e post
	*/
	/**
	 * Metodo che gestisce la richiesta GET alla rotta "/Data" con lo scopo di restituire tutto il tsv
	 * @return la lista di tutti gli elementi del tsv
	*/
	
	@GetMapping("/Data")
	public List getAllData()
	{
		return servizio.getData();
	}
	
	 /**
     * Metodo che gestisce la richiesta GET alla rotta "/Metadata", restituisce i metadata
     * @return lista dei metadata
     */
    @GetMapping("/Metadata")
    public List<Map> getMetadata() {
        return service.getMetadata();
    }
	
	

}

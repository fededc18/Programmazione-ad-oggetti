package it.univpm.Progetto_Programmazione.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lindatato.Progetto.Model.Erasmus;
import com.lindatato.Progetto.Service.Filter;
import com.lindatato.Progetto.Service.Metadata;
import com.lindatato.Progetto.Service.Stats;
import com.lindatato.Progetto.Utilities.DownloadAndParsing;

/**
 * Classe concepita per rispondere alle richieste effettuate tramite postman, utilizzando le classi precedentemente create
*/

@Service
public class Service {
	
	private String url= "https://data.europa.eu/euodp/data/api/3/action/package_show?id=vrjbNpJPeAOWLuNRhT6Tg";
    private DownloadandParsing dp;
    private Metadata Mdata;
    private Statistic stats;
    private Filter filtri;
    private List<Energy> lista;
    
    /*
     * Costruttore che, all'avvio dell'applicazione, effettua Download e Parsing dei dati del tsv
     * e vengono estratti i relativi dati
     */
	
    public Service()
    {
    	this.dp = new DownloadAndParsing();
		this.Mdata = new Metadata();
		this.stats = new Statistic();
		this.filtri = new Filter();
		
		String link="";
		
		link = dp.download(url);
		lista = dp.parsing(link);
    }
    
    
    /**
	 * Metodo che restituisce i metadati del file TSV
	 * @return la lista dei metadati
	 */
	public List<Map> getMetadata() {
		return Mdata.getMetadata();
	}
	
	/**
	 * Metodo che restituisce i dati del file
	 * @return lista dei dati
	 */
	public List<Energy> getData() {
 		return this.lista;
	}
	
	/**
	 * Metodo che restituisce le statistiche di un dato attributo
	 * @param nomeCampo contiene il valore dell'attributo del quale si vogliono calcolare le statistiche
	 * @return map delle statistiche desiderate
	 */
	
	

}

package it.univpm.Progetto_Programmazione.GestioneDati;

import java.util.List;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Classe per la restituzione dei metadata(le macrocategorie presenti)
 */

public class Metadata {
	
	private List<Map> metadata = new ArrayList<>();
	
    public Metadata() 
    {
		Field[] fields = Energy.class.getDeclaredFields();//estrae gli attributi della classe EuropeanUn
	
	    for ( Field f : fields ) 
        {
    	   Map<String, String> map = new HashMap<String,String>();
           //andiamo ad inserire le coppie chiave/valore
           map.put("alias", f.getName());
           map.put("sourceField", f.getName());//nome del campo in tsv
           map.put("type", "double");
           metadata.add(map);
        }
    }
	/**
	 * Metodo che ritorna la lista di mappe contenente i metadati
	 * @return lista dei metadati
	 */
    public List<Map> getMetadata() 
	{
		return metadata;
	}
    
}

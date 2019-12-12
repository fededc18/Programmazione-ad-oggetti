package it.univpm.Progetto_Programmazione.download;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import it.univpm.Progetto_Programmazione.GestioneDati.EuropeanUn;

/**
 * 
 * Classe che racchiude i metodi per il download del dataset e il parsing del file csv contenuto nell'url del dataset
 * 
 */

public class DownloadAndParsing {
	
	private List<EuropeanUn> EuropeanUnList;
	private String link = "";
	private String url="http://data.europa.eu/euodp/data/api/3/action/package_show?id=erasmus-mobility-statistics-2011-12";
	
	/**
	 * Metodo che effettua il download del dataset estraendo il link del tsv 
	 * 
	 * @param url stringa che contiene l'url del dataset assegnatoci
	 * @return ritorna una stringa contenuta il link url del csv
	 */
	
	public String download(String url) {
		try {
			URLConnection openConnection = new URL(url).openConnection();  //crea una connesione tra applicazioe e url
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream input = openConnection.getInputStream();  //crea il flusso di input
			
			 String data = "";
			 String line = "";
			 try {
			   InputStreamReader inputReader = new InputStreamReader(input);  //legge i byte e li decodifica in caratteri
			   BufferedReader br = new BufferedReader(inputReader);  //legge un file di testo
			   
			   while ((line = br.readLine())!=null) {  // legge affinchè il file non è vuoto
				  
				   data += line;
				   //System.out.println(line);  //stampa il dataset in una righa per il debug
			   }
			 } finally {
			   input.close();
			 }
			 
			 JSONObject objectdata = (JSONObject) JSONValue.parseWithException(data); // converte il dataset
			 JSONObject object = (JSONObject) (object.get("result"));  // assegna alla variabile objectI il json del dataset denominato result
			 JSONArray objectArray = (JSONArray) (objectI.get("resources"));  // assegna al vettore json objectArray il valore di resources che contiene l'url del tsv da estrarre
					 
			 for(Object obj : objectArray) {
				 if (object instanceof JSONObject) {
					 JSONObject obj1 = (JSONObject)obj;
					if(((String)obj1.get("format")).toLowerCase().contains("tsv") && ((String)obj1.get("url")).contains("prod"))  // estrae il tsv e verifica che ci sia la stringa prod nell'url da estrarre
						 link = (String)obj1.get("url");
				 }
			 }	
			 
		// controlli
			 
		} catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	
		
		System.out.println( "\nDownload completato." );
		return link;
	}
	
	/**
	 * Metodo che effettua il parsing del file tsv estratto precedentemente 
	 * 
	 * @param link contiene l'url del csv
	 * @return lista di oggetti Erasmus con i relativi attributi contenenti i valori del dataset
	 */
	
	public List<EuropeanUn> parsing(String link) {
		String line = "";
	    String csvSplitBy = ";";  // carattere che divide i valori del csv
	    BufferedReader br= null;
	    boolean flag1= false, flag2= false;
	    int count = 1;
	    
	    try {
	    	URL urlCSV = new URL(link);
	    	br = new BufferedReader(new InputStreamReader(urlCSV.openStream()));
	    	
	    	while (((line = br.readLine()) != null) && !flag2) {
	    		if (count==this.limit) flag2= true;  // esce dal ciclo quando la variabile count è uguale a limit
	    		if (!flag1) {flag1=true; continue;}  // permette di saltare la prima riga del csv
	    		String[] valore = line.split(csvSplitBy);  // dopo aver letto una riga del csv la divide ogni volta che trova un carattere ";"
	    		erasmusList.add(new Erasmus (valore[0],valore[1],Integer.parseInt(valore[2]),valore[3],valore[4],Integer.parseInt(valore[5]),valore[6],Integer.parseInt(valore[7]),valore[8],valore[9],valore[10],
    									valore[11],valore[12],valore[13],valore[14],Double.parseDouble(valore[15]),Double.parseDouble(valore[16]),valore[17],valore[18],valore[19],valore[20],
    									Integer.parseInt(valore[21]),Integer.parseInt(valore[22]),Integer.parseInt(valore[23]),Double.parseDouble(valore[24]),valore[25],valore[26],valore[27],
    									Double.parseDouble(valore[28]),Double.parseDouble(valore[29]),valore[30],valore[31]));
	    		count++;
	    	}
	    } catch (FileNotFoundException e) {
	   		e.printStackTrace();
	   	} catch (IOException e) {
	   		e.printStackTrace();
	   	} finally {
	    	if (br != null) {
	    		try {
	    			br.close();
	    		} catch (IOException e) {
	    			e.printStackTrace();
	   			}
	   		}
	   	}
	    System.out.println("Parsing completato.\n");
	    
	    // stampa la lista Erasmus per il debug
	    
	    /*for(Erasmus e : erasmusList)
    	System.out.println(e);*/
	    return erasmusList;
	}
	
	// Metodo che restituisce la lista Erasmus in alternativa al metodo parsing
	
	public List<EuropeanUn> getData(){
		return EuropeanUnList;
	}
}



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

public class Download {
	try {
		URLConnection openConnection = new URL(url).openConnection();  //crea una connesione tra applicazioe e url
		openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		InputStream input = openConnection.getInputStream();  //crea il flusso di input
		
		 String data = "";
		 String line = "";
		 try {
		   InputStreamReader inputReader = new InputStreamReader(input);  //legge i byte e li decodifica in caratteri
		   BufferedReader br = new BufferedReader(inputReader);  //legge un file di testo
		   
		   while ((line = br.readLine())!=null) {  // legge finchè il file è vuoto
			   data += line;
			   //System.out.println(line);  //stampa il dataset in una righa per il debug
		   }
		 } finally {
		   input.close();
		 }
		 
		 JSONObject object = (JSONObject) JSONValue.parseWithException(data); 
		 JSONObject objectI = (JSONObject) (object.get("result"));  // assegna alla variabile objectI il json del dataset denominato result
		 JSONArray objectArray = (JSONArray) (objectI.get("resources"));  // assegna al vettore json objectArray il valore di resources che contiene l'url del csv da estrarre
				 
		 for(Object obj : objectArray) {
			 if (obj instanceof JSONObject) {
				 JSONObject obj1 = (JSONObject)obj;
				if(((String)obj1.get("format")).toLowerCase().contains("tsv") && ((String)obj1.get("url")).contains("student"))  // estrae il tsv desiderato verificando la presenza della stringa student nell'url che si vuole estrarre
					 link = (String)obj1.get("url");
			 }
		 }			
	} 
	
	// controllano eventuali errori
	
	catch (IOException | ParseException e)
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

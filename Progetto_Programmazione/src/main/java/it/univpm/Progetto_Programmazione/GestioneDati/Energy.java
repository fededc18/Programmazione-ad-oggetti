package it.univpm.Progetto_Programmazione.GestioneDati;

import java.io.Serializable;

public class Energy implements Serializable 
{

  private String Nrg_bal, Siec, Unit, Geo_time;
  private int [] Valori = new int [12];
	  
  /**
   * Costruttore della classe
   * @param nrg_bal
   * @param siec
   * @param unit
   * @param geo_time
   * @param valori
   */
	  
	  
 public Energy (String  nrg_bal, String siec, String unit, String geo_time, int valori[] )
   {
	  this.Nrg_bal= nrg_bal;
	  this.Siec= siec;
	  this.Unit= unit;
	  this.Geo_time= geo_time;
	  this.Valori= valori;
   }
	  
//Implementazione Getters and Setters
  public String getNrg_bal() {
	return Nrg_bal;
  }

  public void setNrg_bal(String nrg_bal) {
	Nrg_bal = nrg_bal;
  }

  public String getSiec() {
 	return Siec;
  }

  public void setSiec(String siec) {
	Siec = siec; 
  }

  public String getUnit() {
 	return Unit;
  }

  public void setUnit(String unit) {
	Unit = unit;
  }

  public String getGeo_time() {
	return Geo_time;
  }

  public void setGeo_time(String geo_time) {
 	Geo_time = geo_time;
  }

  public int[] getValori() {
 	return Valori;
  }

  public void setValori(int[] valori) {
	Valori = valori;
  }


   /*utilizzo il metodo toString per la stampa dell'oggetto
   * 
   * @return restituisce una stringa con tutti i valori che descrivono l'oggetto
   */
  @Override
 public String toString() 
  {
     return "Energy[Nrg_bal=" + Nrg_bal + ",Siec=" + Siec + ",Unit=" 
		    + Unit + ",Geo_time= " + Geo_time ",Valori=" + Valori + " ]";
  }
  
}

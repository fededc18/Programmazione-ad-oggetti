package it.univpm.Progetto_Programmazione.GestioneDati;

import java.io.Serializable;

public class Energy implements Serializable 
{

  private String Nrg_bal,Siec,Unit,Geo\time;
  private int [] Valori = new int [12];
}
  
  /**
   * Costruttore della classe
   * @param nrg_bal
   * @param siec
   * @param unit
   * @param geo\time
   * @param valori
   */
  
  
  public Energy (String  nrg_bal, String siec, String unit, String geo\time, int valori[] )
  {
	  this.Nrg_bal= nrg_bal;
	  this.Siec= siec;
	  this.Unit= unit;
	  this.Geo\time= geo\time;
	  this.Valori= valori;
	 
  }
  
//Implementazione Getters and Setters
  



  /*utilizzo il metodo toString per la stampa dell'oggetto
   * 
   * @return restituisce una stringa con tutti i valori che descrivono l'oggetto
   */
  @Override
  public String toString() {
	  return "Energy[Members_UE=" + Members_UE + "Period=" + Period + ",Fc_en="
				+ Fc_en + ",Fc_ind_en=" + Fc_ind_en + "Fc_oth_en" + Fc_oth_en + ",unit_measure=" 
			    + Unit_measure + ",value=" + Value + " ]";
	
  }
}

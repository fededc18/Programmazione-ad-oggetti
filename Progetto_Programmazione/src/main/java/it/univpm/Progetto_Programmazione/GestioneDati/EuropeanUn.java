package it.univpm.Progetto_Programmazione.GestioneDati;

import java.io.Serializable;

public class EuropeanUn implements Serializable 
{
  
  private int Time_period;
  private String Fc_en, Fc_ind_en, Fc_oth_en, Members_UE, Unit_measure;
  private double Value;
  
  /**
	 * Costruttore della classe
	 * 
	 * @param time_period
	 * @param fc_en
	 * @param fc_ind_en
	 * @param fc_oth_en
	 * @param members_UE
	 * @param unit_measure
	 * @param value
	 */
  
  public EuropeanUn (int time_period,String fc_en,String fc_ind_en,String fc_oth_en,String members_UE,String unit_measure, double value)
  {
	  this.Fc_en= fc_en;
	  this.Fc_ind_en= fc_ind_en;
	  this.Fc_oth_en= fc_oth_en;
	  this.Members_UE= members_UE;
	  this.Time_period= time_period;
	  this.Unit_measure= unit_measure;
	  this.Value= value;
  }
  
//Implementazione Getters and Setters

  public int getTime_period() {
	return Time_period;
  }

  public void setTime_period(int time_period) {
	Time_period = time_period;
  }

  public String getFc_en() {
	return Fc_en;
  }

  public void setFc_en(String fc_en) {
	Fc_en = fc_en;
  }

  public String getFc_ind_en() {
	return Fc_ind_en;
  }

  public void setFc_ind_en(String fc_ind_en) {
	Fc_ind_en = fc_ind_en;
  }

  public String getFc_oth_en() {
	return Fc_oth_en;
  }

  public void setFc_oth_en(String fc_oth_en) {
	Fc_oth_en = fc_oth_en;
  }

  public String getMembres_UE() {
	return Membres_UE;
  }

  public void setMembres_UE(String membres_UE) {
	Membres_UE = membres_UE;
  }

  public String getUnit_measure() {
	return Unit_measure;
  }

  public void setUnit_measure(String unit_measure) {
	Unit_measure = unit_measure;
  }

  public double getValue() {
	return Value;
  }

  public void setValue(double value) {
	Value = value;
  }

  /*utilizzo il metodo toString per la stampa dell'oggetto
   * 
   * @return restituisce una stringa con tutti i valori che descrivono l'oggetto
   */
  @Override
  public String toString() {
	  return "EuropeanUE [Members_UE=" + Members_UE + "time_period=" + Time_period + ",Fc_en="
				+ Fc_en + ",Fc_ind_en=" + Fc_ind_en + "Fc_oth_en" + Fc_oth_en + ",unit_measure=" 
			    + Unit_measure + ",value=" + Value + " ]";
  }
}
package org.example;

public interface IHinnoittelija {
	public abstract float getAlennusProsentti(Asiakas asiakas, Tuote tuote);
	public void aloita();
	public void setAlennusProsentti(Asiakas asiakas, float prosentti);
	public void lopeta();
}

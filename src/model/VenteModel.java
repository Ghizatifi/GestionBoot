package model;

import metier.Vente;

public class VenteModel {
	private Vente prd;
	private boolean res;
	public Vente getPrd() {
		return prd;
	}
	public void setPrd(Vente prd) {
		this.prd = prd;
	}
	public boolean isRes() {
		return res;
	}
	public void setRes(boolean res) {
		this.res = res;
	}
	public VenteModel(Vente prd, boolean res) {
		super();
		this.prd = prd;
		this.res = res;
	}
	
	
}

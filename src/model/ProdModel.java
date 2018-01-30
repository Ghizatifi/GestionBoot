package model;

import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProdModel {
	private Produit prd;
	private boolean res;
	public Produit getPrd() {
		return prd;
	}
	public void setPrd(Produit prd) {
		this.prd = prd;
	}
	public boolean isRes() {
		return res;
	}
	public void setRes(boolean res) {
		this.res = res;
	}
	public ProdModel(Produit prd, boolean res) {
		super();
		this.prd = prd;
		this.res = res;
	}
	
}

package model;

import java.util.ArrayList;
import java.util.List;

import metier.Vendeur;

public class VendModel {
	private Vendeur vd;
	private boolean res;
	private List<Vendeur> list=new ArrayList<Vendeur>();
	public Vendeur getVd() {
		return vd;
	}
	public void setVd(Vendeur vd) {
		this.vd = vd;
	}
	
	public List<Vendeur> getList() {
		return list;
	}
	public void setList(List<Vendeur> list) {
		this.list = list;
	}
	public boolean isRes() {
		return res;
	}
	public void setRes(boolean res) {
		this.res = res;
	}
	public VendModel(Vendeur vd, boolean res) {
		super();
		this.vd = vd;
		this.res = res;
	}
	public VendModel() {
		
	}
	
	
}

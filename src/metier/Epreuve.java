package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Epreuve {
	private int id,duree,effectif;
	private String niveau,date,jour,epreuve,plageHoraire,salle;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getEffectif() {
		return effectif;
	}
	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getEpreuve() {
		return epreuve;
	}
	public void setEpreuve(String epreuve) {
		this.epreuve = epreuve;
	}
	public String getPlageHoraire() {
		return plageHoraire;
	}
	public void setPlageHoraire(String plageHoraire) {
		this.plageHoraire = plageHoraire;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}

	public static List<Epreuve> Programme(String nv) {
		List<Epreuve> Programme= new ArrayList<Epreuve>();
		Connection cnx=Singleton.getConnection();
		try {
			PreparedStatement st=cnx.prepareStatement("select * from epreuve where niveau Like ? ");
			st.setString(1, nv);
		
			ResultSet res=st.executeQuery();
		  while(res.next()){
			Epreuve p = new Epreuve();
			p.setNiveau(res.getString("niveau"));
//			    p.setId(res.getInt("id"));
	//			p.setDate(res.getString("date"));
		p.setJour(res.getString("jour"));
				p.setEpreuve(res.getString("epreuve"));
		     	p.setPlageHoraire(res.getString("plagehoraire"));
		 //    	p.setDuree(res.getInt("dure"));
		  //   	p.setSalle(res.getString("salle"));
		 //    	p.setEffectif(res.getInt("effectif"));

			Programme.add(p);
			}
		  st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return Programme;
	}
	
	
}

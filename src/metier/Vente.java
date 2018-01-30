package metier;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Vente {
	
	private Long id;
	private String marque;
	private int qte;
	private String dt;
	private int idV;
	public int getIdV() {
		return idV;
	}
	public void setIdV(int idV) {
		this.idV = idV;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public Vente(Long id, String marque, int qte, String dt,int idV) {
		super();
		this.id = id;
		this.marque = marque;
		this.qte = qte;
		this.dt = dt;
		this.idV=idV;
	}
	
	public Vente(Long id, String marque, int qte, String dt) {
		super();
		this.id = id;
		this.marque = marque;
		this.qte = qte;
		this.dt = dt;
		
	}
	public Vente(Long id, String marque, int qte) {
		super();
		this.id = id;
		this.marque = marque;
		this.qte = qte;
	}
	
	public boolean declarer() {
		Connection cnx=Singleton.getConnection();
		boolean res=false;
		try {
			String req="insert into vente values(null, '"+this.marque+"' ,'"+this.qte+"','"+this.dt+"','"+this.idV+"')";
			PreparedStatement st=cnx.prepareStatement(req);

		  st.executeUpdate();
		  res=true;
		  System.out.println(" declaration avec sucee avec succes");
		} catch (SQLException e) {
			System.out.println("prob declaration");
		}
		return res;
			
		}
	
	public static ArrayList<Vente> getAllVente(){
		ArrayList<Vente> listVente= new ArrayList<>();
		Connection conn = Singleton.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from vente" );
			ResultSet rs;
			rs = ps.executeQuery();
			Vente v = null; 
			while(rs.next()){
				Long id = rs.getLong("id");
				String marque = (String)rs.getString("marque") ;
				int qte = rs.getInt("qte") ;
				String dt = (String)rs.getString("dt") ;
				v= new Vente(id, marque, qte,dt);
				listVente.add(v);
			}
		} catch (SQLException e) {
			System.out.println("prooooob");
			e.printStackTrace();
		}
		
		
		return listVente;
	}
	
	public static ArrayList<Vente> getAllVenteParV(int idV){
		ArrayList<Vente> listVente= new ArrayList<>();
		Connection conn = Singleton.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from vente where idV=?" );
			ps.setLong(1,idV);
			ResultSet rs;
			rs = ps.executeQuery();
			Vente v = null; 
			while(rs.next()){
				Long id = rs.getLong("id");
				String marque = (String)rs.getString("marque") ;
				int qte = rs.getInt("qte") ;
				String dt = (String)rs.getString("dt") ;
				v= new Vente(id, marque, qte,dt,idV);
				listVente.add(v);
			}
		} catch (SQLException e) {
			System.out.println("prooooob");
			e.printStackTrace();
		}
		
		
		return listVente;
	}
}

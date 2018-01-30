package metier;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Produit {
	//*******************************//
	private Long id;
	private String marque;
	private String designation;
	private double prix;
	private int qte;
	private String image;
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	//********************************//
	public Produit() {
		super();
	}
	
	public Produit(Long id, String marque, double prix, int qte) {
		super();
		this.id = id;
		this.marque = marque;
		this.prix = prix;
		this.qte = qte;
	}
	public Produit(Long id, int qte) {
		super();
		this.id = id;
		this.qte = qte;
	}
	public Produit(Long id,String marque, double prix, int qte,String image) {
		super();
		this.id = id;
		this.marque = marque;
		
		this.prix = prix;
		this.qte = qte;
		this.image = image;
	}

	public Produit(String marque, String designation, double prix, int qte, String image) {
		super();
		this.marque = marque;
		this.designation = designation;
		this.prix = prix;
		this.qte = qte;
		this.image = image;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	//**********************************//
	public boolean addPrd() {
	Connection cnx=Singleton.getConnection();
	boolean res=false;
	try {
		String req="insert into produit values(null,'"+this.marque+"' ,'" +this.prix+"','" +this.qte+"','" +this.image+"')";
		PreparedStatement st=cnx.prepareStatement(req);

	  st.executeUpdate();
	  res=true;
	  System.out.println(" ajouté avec succes");
	} catch (SQLException e) {
		System.out.println("prob d'ajpuut");
	}
	return res;
		
	}

	public static List<Produit> ListPrd() {
		List<Produit> prd= new ArrayList<Produit>();
		Connection cnx=Singleton.getConnection();
		try {
			PreparedStatement st=cnx.prepareStatement("select * from produit");
		  ResultSet res=st.executeQuery();
		  while(res.next()){
			Produit p = new Produit();
			p.setId(res.getLong("id"));
			p.setMarque(res.getString("marque"));
			p.setPrix(res.getDouble("prix"));
			p.setQte(res.getInt("qte"));
			p.setImage(res.getString("image"));
			prd.add(p);
			}
		  st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return prd;
	}
//
	public static List<Produit> Prod() {
		List<Produit> prd= new ArrayList<Produit>();
		Connection cnx=Singleton.getConnection();
		try {
			PreparedStatement st=cnx.prepareStatement("select marque from produit");
			ResultSet res=st.executeQuery();
		  while(res.next()){
			Produit p = new Produit();
			p.setMarque(res.getString("marque"));
			prd.add(p);
			}
		  st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return prd;
	}
	public static Produit getPrd(int id) throws SQLException{
		Produit p=new Produit();
		Connection conn = Singleton.getConnection();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from produit where id=" +id );
		ResultSet rs = ps.executeQuery();

		if(rs.next()){
			Long idp = rs.getLong("id");
			String marque = (String)rs.getString("marque") ;
			double prix = (double)rs.getDouble("prix") ;
			int qte = (Integer)rs.getInt("qte") ;
			String image= (String)rs.getString("image") ;
			
			p.setId(idp);
			p.setMarque(marque);
			p.setPrix(prix);
			p.setQte(qte);	
			p.setImage(image);
		}	
		return p;
	}
	public boolean UpdateP(){
		boolean resultat = false; 
		Connection conn = Singleton.getConnection();
		String req = "update produit SET marque = ? ,prix=?, qte = ?,image=? where id = ?";		
		try{
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(req);
			ps.setString(1,this.getMarque());
			ps.setDouble(2,this.getPrix());
			ps.setInt(3,this.getQte());
			ps.setString(4,this.getImage());
			ps.setLong(5,this.getId());
			ps.executeUpdate();
			resultat = true;
			System.out.println(" produit modifié avec succes ");
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println(" prob de modification du produit");
		}
		return resultat;
		
	}
	public void deletePrd(Long id) {
		Connection cnx=Singleton.getConnection();
		try {
		  PreparedStatement st=cnx.prepareStatement("delete from produit where id=?");
		  st.setLong(1, id);
		  st.executeUpdate();
		  st.close();
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	public void updateQte(String mrq,int qte) {
		Connection cnx=Singleton.getConnection();
		try {
			PreparedStatement st=cnx.prepareStatement("update produit set qte=? where marque=?");

		  st.setInt(1, qte);
		  st.setString(2, mrq);
		  st.executeUpdate();
		  st.close();
		  
		} catch (SQLException e) {
			System.out.println("errrror");
			e.printStackTrace();
		}		
	}
	public int Qte(String mrq){
		Connection cnx=Singleton.getConnection();
		int x=0;
		Produit p= new Produit();
		try {
			PreparedStatement st=cnx.prepareStatement("select qte from produit where marque= ?");  
			st.setString(1, mrq);
			ResultSet rs=st.executeQuery();
			 if(rs.next()){
					
				 p.setQte(rs.getInt("qte"));
					 
			 } 
		} catch (SQLException e) {
			System.out.println("errrror");
			e.printStackTrace();
		}
		x=p.getQte();
		return x;
	}
	
	public void updateReapro() {
		Connection cnx=Singleton.getConnection();
		try {
			PreparedStatement st=cnx.prepareStatement("update produit set qte=? where id=?");

		  st.setInt(1, this.qte);
		  st.setLong(2, this.id);
		  st.executeUpdate();
		  st.close();
		  
		} catch (SQLException e) {
			System.out.println("errrror");
			e.printStackTrace();
		}		
	}
	
	
	public static List<Produit> Programme() {
		List<Produit> Programme= new ArrayList<Produit>();
		Connection cnx=Singleton.getConnection();
		try {
			PreparedStatement st=cnx.prepareStatement("select * from epreuve");
		  ResultSet res=st.executeQuery();
		  while(res.next()){
			Produit p = new Produit();
			p.setId(res.getLong("id"));
			p.setMarque(res.getString("marque"));
			p.setPrix(res.getDouble("prix"));
			p.setQte(res.getInt("qte"));
			p.setImage(res.getString("image"));
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

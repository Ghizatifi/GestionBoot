package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class Vendeur {
private int id;
private String nom;
private String prenom;
private String tel;
private String email;
private String image;
private String type;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Vendeur(int id, String nom, String prenom, String tel, String email, String image,String type) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.tel = tel;
	this.email = email;
	this.image = image;
	this.type = type;
}
public Vendeur() {
	super();
	// TODO Auto-generated constructor stub
}

public Vendeur(String nom, String prenom, String tel, String email, String image) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.tel = tel;
	this.email = email;
	this.image = image;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

public boolean addVd(){
	boolean res=false;
	
	Connection conn=Singleton.getConnection();
	//preparaion de la req
	String req="insert into vendeur values(null,?,?,?,?,?,'v')";
	
	try{
		PreparedStatement ps =(PreparedStatement)conn.prepareStatement(req);
		ps.setString(1, this.nom);
		ps.setString(2, this.prenom);
		ps.setString(3, this.tel);
		ps.setString(4, this.email);
		ps.setString(5, this.image);
		ps.executeUpdate();
		res=true;
		System.out.println("vendeur ajouté avec succes");
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println("prob d'ajout du vendeur");
	}
	return res;
}
//affichaage
public static ArrayList<Vendeur> getAllV(){
	ArrayList<Vendeur> listVendeur =new ArrayList<Vendeur>();
	try {
		Connection conn=Singleton.getConnection();
		PreparedStatement pr = (PreparedStatement) conn.prepareStatement("SELECT * FROM vendeur");
		ResultSet rs=pr.executeQuery();
		while(rs.next()){
			Vendeur v= new Vendeur();
			v.setId(rs.getInt("id"));
			v.setNom(rs.getString("nom"));
			v.setPrenom(rs.getString("prenom"));
			v.setTel(rs.getString("tel"));
			v.setEmail(rs.getString("email"));
			v.setImage(rs.getString("image"));
			listVendeur.add(v);
		}
		
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	return listVendeur;
}
//suppression

public static  boolean supprimer(int id){
	boolean res=false;
	Vendeur v =new Vendeur();
	Connection conn=Singleton.getConnection();
	try{
		PreparedStatement ps =(PreparedStatement)conn.prepareStatement("delete from vendeur where id=?");
		ps.setInt(1,id);
		ps.executeUpdate();
		res=true;
		System.out.println("Vendeur supprimé avec succes");
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println("prob de suppression du Vendeur");
	}
	return res;
}

public static Vendeur modifier(int id){
	Vendeur v=new Vendeur();
	Connection conn=Singleton.getConnection();
	try{
		PreparedStatement ps =(PreparedStatement)conn.prepareStatement("select * from vendeur where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			v.setId(rs.getInt("id"));
			v.setNom(rs.getString("nom"));
			v.setPrenom(rs.getString("prenom"));
			v.setTel(rs.getString("tel"));
			v.setEmail(rs.getString("email"));
			v.setImage(rs.getString("image"));
		}
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println("prob de chargement  du Vendeur");
	}
	
	return v;
}

public static void update(Vendeur v){
	
	Connection conn=Singleton.getConnection();
	try{
		PreparedStatement ps =(PreparedStatement)conn.prepareStatement("update vendeur set nom=?,prenom=?,tel=?,email=?,image=?" + "where id=?");
		ps.setString(1, v.getNom());
		ps.setString(2, v.getPrenom());
		ps.setString(3, v.getTel());
		ps.setString(4, v.getEmail());
		ps.setString(5, v.getImage());
		ps.setInt(6, v.getId());
		ps.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println("prob de modification  du Vendeur");
	}
	
}

public static	Vendeur auth(String login, String pass){
	int b=0;
	Vendeur a=new Vendeur();
	 try {
    Connection cn=Singleton.getConnection();
	PreparedStatement pr = (PreparedStatement) cn.prepareStatement("select * from vendeur where email=? and nom=?");
	pr.setString(1,login);
	pr.setString(2,pass);
	ResultSet rs=pr.executeQuery();
	 if(rs.next()){
		
		 //a.setIdA();
		// a.setLogin(rs.getString("login"));
		 //a.setPass(rs.getString("pass"));
		
		 a.setId(rs.getInt("id"));
		 a.setNom(rs.getString("nom"));
		 a.setPrenom(rs.getString("prenom"));
		 a.setTel(rs.getString("tel"));
		 a.setEmail(rs.getString("email"));
		 a.setImage(rs.getString("image"));
		 a.setType(rs.getString("type"));
		
		 
	 } 
	 } catch (Exception e1) {
			
			e1.printStackTrace();
		}
	
	
	 return a;

}




}

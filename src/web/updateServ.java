package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import metier.Vendeur;

/**
 * Servlet implementation class updateServ
 */
@WebServlet("/updateServ")
@MultipartConfig
(maxFileSize=1024*1024*10)     // 10MB
public class updateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String path = "C:/Users/soumia/Desktop/jee/Workspace/GestionVentes/WebContent/upload/";
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vendeur v=new Vendeur();
		v.setId(Integer.parseInt(request.getParameter("id")));
		v.setNom(request.getParameter("nom"));
		v.setPrenom(request.getParameter("prenom"));
		v.setTel(request.getParameter("tel"));
		v.setEmail(request.getParameter("email"));
		
        Part part1 = request.getPart("image");
		

		String filetypeCover = part1.getContentType();
		
		String extcover = GetExtension(filetypeCover);
		
		
		//date
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
		//System.out.println(formater.format(new Date()));
		String filenameCover = "img_"+formater.format(new Date())+"."+extcover;
		
		String coverpath = path+filenameCover;
		
		part1.write(coverpath);
		
		

		v.setImage(filenameCover);
		
		Vendeur.update(v);
		request.getRequestDispatcher("./AfficherVendeur").forward(request, response);
		
	}
	
	public static String GetExtension(String s){
		String[] parts = s.split("/");
		String part2 = parts[1];
		return part2;
	}
		
	
	

}

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
 * Servlet implementation class AjoutServ
 */
@WebServlet("/AjoutServ")
@MultipartConfig
(maxFileSize=1024*1024*10)     // 10MB

public class AjoutServ extends HttpServlet {
	public static String path = "D:/JeeClasse/GestionVentes/WebContent/upload/";

	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		Part part1 = request.getPart("image");
		

		String filetypeCover = part1.getContentType();
		
		String extcover = GetExtension(filetypeCover);
		
		
		//date
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
		//System.out.println(formater.format(new Date()));
		String filenameCover = "img_"+formater.format(new Date())+"."+extcover;
		
		String coverpath = path+filenameCover;
		
		part1.write(coverpath);
		
		

	
		Vendeur l = new Vendeur(nom,prenom,tel,email,filenameCover);
		boolean resultat = l.addVd();

		if(!resultat){
			request.getRequestDispatcher("failed.jsp").forward(request, response);
		}
		else request.getRequestDispatcher("./AfficherVendeur").forward(request, response);


		
	}
	
	public static String GetExtension(String s){
		String[] parts = s.split("/");
		String part2 = parts[1];
		return part2;
	}

	}



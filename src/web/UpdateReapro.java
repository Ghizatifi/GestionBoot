package web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import metier.Produit;
import model.ProdModel;

/**
 * Servlet implementation class UpdatePrd
 */
@WebServlet("/UpdateReapro")
@MultipartConfig
(maxFileSize=1024*1024*10)     // 10MB
public class UpdateReapro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String path = "C:/Users/soumia/Desktop/jee/Workspace/GestionVentes/WebContent/upload/";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReapro() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String desg,marque;
		int qte;
		long id;
		double prix;
		id=Long.parseLong(request.getParameter("id"));
		
		qte=Integer.parseInt(request.getParameter("qte"));
		
		
		
			
		Produit p=new Produit(id,qte);
		p.updateReapro();
		
		//ProdModel m=new ProdModel(p,res);
		
		//request.setAttribute("modelPrd", m);

		request.getRequestDispatcher("./ListPrd").forward(request, response);
	}
	public static String GetExtension(String s){
		String[] parts = s.split("/");
		String part2 = parts[1];
		return part2;
	}
	}



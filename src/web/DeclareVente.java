package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Produit;
import metier.Vente;
import model.ProdModel;
import model.VenteModel;

/**
 * Servlet implementation class DeclareVente
 */
@WebServlet("/DeclareVente")
public class DeclareVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeclareVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Produit> list= new ArrayList<>();
		list = (ArrayList<Produit>) Produit.ListPrd();
		
		request.setAttribute("listPrd", list);
		System.out.println(list);
		request.getRequestDispatcher("Declare.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String marque;
		int qte;
		Produit p = new Produit();
//		String now = new SimpleDateFormat("MM/dd/yy/hh-mm-ss" ).format(new java.util.Date());
//	System.out.println("<p>The time is: " + now + "</p>" );
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy/hh-mm-ss");
//        String laDateDuJour = sdf.format(new java.util.Date());
           Date date = new Date();
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy/hh-mm-ss");
           String laDateDuJour = sdf.format(date);
          
	       
		marque=request.getParameter("marque");
		qte=Integer.parseInt(request.getParameter("qte"));
		 int idV=Integer.parseInt(request.getParameter("idV"));
		int qt=p.Qte(marque);
		if (qte>qt){
			System.out.println("Stock est insuffisant");
			request.getRequestDispatcher("Declare.jsp").forward(request, response);
		}
		else{
		Vente v=new Vente(1l,marque,qte,laDateDuJour,idV);
		boolean res=v.declarer();		
		VenteModel m=new VenteModel(v,res);		
		request.setAttribute("modelPrd", m);
		int nqte=p.Qte(marque)-qte;
		p.updateQte(marque, nqte);
		request.setAttribute("id", idV);
		request.getRequestDispatcher("./ListDeclaration").forward(request, response);
		}
		
		}

}

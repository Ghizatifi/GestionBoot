package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Vendeur;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int b=0;
		Vendeur a=new Vendeur();
		
		//Récup info
		
				String login=(String)req.getParameter("login");
				String pass=(String)req.getParameter("pass");
				
				 a=Vendeur.auth(login, pass);
					if(a.getId()==0){
						req.getRequestDispatcher("login.html").forward(req, resp);
						
					}
					else{
						// création de la session
						HttpSession session =req.getSession();
						//Ajouter un attribut dans l'objet session
						session.setAttribute("login", login);
						session.setAttribute("pass", pass);
						session.setAttribute("type", a.getType());
						session.setAttribute("image", a.getImage());
						session.setAttribute("id", a.getId());
						if(a.getType().equals("a")){
						req.getRequestDispatcher("./ListPrd").forward(req, resp);
						}
						
							req.setAttribute("id", a.getId());
							req.getRequestDispatcher("./ListDeclaration").forward(req, resp);
						
						
						
					}
					
				
	}

}

package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimeiraServlet
 */
@WebServlet("/PrimeiraServlet")
public class PrimeiraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimeiraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			 HttpServletResponse response) 	
					 throws ServletException, 
					 IOException {

response.getWriter().append("Served at: ").append(request.getContextPath());
response.getWriter().append("<form action=\"PrimeiraServlet\" method=\"post\">\r\n"
		+ "\r\n"
		+ "<fieldset>\r\n"
		+ "	<legend>Validação</legend>\r\n"
		+ "	<label>Login</label>  \r\n"
		+ "    <input type=\"text\" name=\"login\">\r\n"
		+ "	<hr />\r\n"
		+ "	<label>Senha</label> \r\n"
		+ "    <input type=\"text\" name=\"senha\">\r\n"
		+ "</fieldset>\r\n"
		+ "	<input type=\"submit\" value=\"Enviar\">\r\n"
		+ "</form>");
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String login = request.getParameter("login");
String senha = request.getParameter("senha");

if(login.equals("Grupo") && senha.equals("12345")){
response.sendRedirect("sucesso.html");
}else{
response.sendRedirect("acesso_negado.html");
}

}
}


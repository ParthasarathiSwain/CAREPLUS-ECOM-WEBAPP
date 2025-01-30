package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Company;
import dao.CompanyDao;

@WebServlet("/CompanyServlet")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String secret=request.getParameter("secret");
		if(secret.equals("SaveServlet")) {
			String  comName= request.getParameter("comName");
			String  comEmail= request.getParameter("comEmail");
			String  comPass= request.getParameter("comPass");
			String  comPhone= request.getParameter("comPhone");
			String  comAdd= request.getParameter("comAdd");
			
			Company c=new Company();
			c.setComAdd(comAdd);
			c.setComEmail(comEmail);
			c.setComName(comName);
			c.setComPass(comPass);
			c.setComPhone(comPhone);
			
			
			CompanyDao cd=new CompanyDao();
			int status=cd.saveCompany(c);
			if (status>0) {
				out.print("done");
			} else {
				out.print("fail");
			}
		}
	}

}

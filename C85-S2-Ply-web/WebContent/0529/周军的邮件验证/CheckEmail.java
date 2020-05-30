package d0528;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckEmail.do")
public class CheckEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String vcode1=request.getParameter("vcode1");
	   int vcode=Integer.parseInt(vcode1);
	   
	   Integer svcode=(Integer) request.getSession().getAttribute("vcode");
	   int svcode1=svcode; 
	   
	     if(vcode1!=null &&vcode1.trim().isEmpty()==false ) {
	    	 if(vcode==svcode1) {
	    		 response.getWriter().append("验证码正确");
	    	 }else {
	    		 response.getWriter().append("验证码不正确");
	    	 }
	     }else {
	    	 response.getWriter().append("请输入验证码");
	     }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

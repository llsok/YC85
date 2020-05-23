package d0521;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;


@WebServlet("/area.do")
public class AreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		request.setCharacterEncoding("UTF-8");
		//设置响应对象字符集
        response.setCharacterEncoding("UTF-8");
		//设置网页字符集
        response.setContentType("text/html;utf-8");
        String level=request.getParameter("level");
        
        if("0".equals(level)) {
        	String s1=Arrays.toString(AreaConstants.PROVINCES);
        	String s2=s1.substring(1, s1.length()-1);
        	response.getWriter().append(s2);
        }else if("1".equals(level)) {
        	String shengIndex=request.getParameter("shengIndex");
        	int index1=Integer.parseInt(shengIndex);
        	
        	String s1=Arrays.toString(AreaConstants.CITYS[index1]);
        	String s2=s1.substring(1, s1.length()-1);
        	
        	response.getWriter().append(s2);
        }else {
        	String shengIndex=request.getParameter("shengIndex");
        	int index1=Integer.parseInt(shengIndex);
        	String shiIndex=request.getParameter("shiIndex");
        	int index2=Integer.parseInt(shiIndex);
        	
        	String s1=Arrays.toString(AreaConstants.COUNTYS[index1][index2]);
        	String s2=s1.substring(1, s1.length()-1);
        	
        	response.getWriter().append(s2);
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

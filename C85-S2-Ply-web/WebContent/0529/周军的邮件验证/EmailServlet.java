package d0528;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

@WebServlet("/EmailServlet.do")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random random = new Random();
		int vcode = 1000 + random.nextInt(9999);
		//将验证码保存在会话中
		HttpSession session=request.getSession();
		session.setAttribute("vcode", vcode);
		
		HtmlEmail email = new HtmlEmail();//创建对象
		email.setHostName("smtp.qq.com");//在QQ邮箱设置==>账户==>打开smtp服务
		email.setCharset("utf-8");//设置字符集
		try {
			email.addTo("1529072552@qq.com");//收件地址
			email.setFrom("1529072552@qq.com", "周军发送的邮件");//此处填邮箱地址和用户名,用户名可以任意填写
			email.setAuthentication("1529072552@qq.com", "客户端授权码");
			//填写发件人邮箱地址和客户端授权码    打开smtp服务可得到客户端授权码
		
			email.setSubject("验证码获取");//此处填写邮件名，邮件名可任意填写
			email.setMsg("尊敬的用户您好,您本次注册的验证码是:" + vcode+"请及时填写哦");//此处填写邮件内容
			email.send();
			response.getWriter().append("验证码已发送");
		} catch (EmailException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

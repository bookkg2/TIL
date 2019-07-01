package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.User;

import web.dispatcher.UI;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/user" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Biz<String,User> biz;
   
    public UserServlet() {
      biz = new UserBiz();
      
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String view = request.getParameter("view");
		String cmd = request.getParameter("cmd");
		String next = "index.jsp";
		if(view != null) {
			UI.build(request, view);
		}else if(cmd != null) {//null 체크
			if(cmd.equals("userlist")) {
				ArrayList<User> list = null;
				try {
					list = biz.get();
					request.setAttribute("ulist", list);
					UI.build(request, cmd);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(cmd.equals("useradd")) {
				
				 String id = request.getParameter("id");
				    String pwd= request.getParameter("pwd");
				    String name = request.getParameter("name");
				    try {
						biz.register(new User(id,pwd,name));
						request.setAttribute("rid", id);//�븘�씠�뵒瑜� �떞�븘�꽌 蹂대궦�떎.(rid濡�)
						
					} catch (Exception e) {
						
					}
				
			}else if(cmd.equals("detail")) {
				String id = request.getParameter("id");
				User user = new User();
				
				try {
					user = biz.get(id);
					request.setAttribute("ud", user);
					UI.build(request, cmd);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}else if(cmd.equals("delete")) {
				String id = request.getParameter("id");
				try {
					biz.remove(id);
					response.sendRedirect("user.do?cmd=userlist");
					return;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		RequestDispatcher rd = 
		request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}

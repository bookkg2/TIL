package web.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/DispatcherServlet", "/dispatcher" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		path = path.substring(1, path.lastIndexOf("."));
		
		String next = "index.jsp";
		if(path.equals("index")){
			String view = request.getParameter("view");
			if(view != null){
				UI.build(request, view);// UI classÀÇ ¿äÃ»°ú ºä¸¦ °¡Á®¿È 
			}
			next = "index.jsp";
		}else{
			
			next = path;
		}
		RequestDispatcher rd = 
		request.getRequestDispatcher(next);
		rd.forward(request, response);
	}
	
	
	

	
	

}





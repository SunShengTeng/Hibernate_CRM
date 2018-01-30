package cn.sst.hibernate.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.sst.hibernate.Service.LinkManService;
import cn.sst.hibernate.Service.Impl.LinkManServiceImpl;
import cn.sst.hibernate.entity.LinkMan;

/**
 * Servlet implementation class AddLinkManServlet
 */
public class AddLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinkManService linkManService =  new LinkManServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLinkManServlet() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
				LinkMan linkMan = new LinkMan();
				BeanUtils.populate(linkMan, request.getParameterMap());
				
				linkManService.insertData(linkMan);
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				request.getRequestDispatcher(request.getContextPath()+"/ListLinkManServlet").forward(request, response);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

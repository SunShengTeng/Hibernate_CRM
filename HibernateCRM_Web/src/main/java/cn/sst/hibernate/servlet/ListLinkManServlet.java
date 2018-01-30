package cn.sst.hibernate.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sst.hibernate.Service.LinkManService;
import cn.sst.hibernate.Service.Impl.LinkManServiceImpl;
import cn.sst.hibernate.entity.LinkMan;
import freemarker.template.utility.NormalizeNewlines;

/**
 * Servlet implementation class ListLinkManServlet
 */
public class ListLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LinkManService linkManService = new LinkManServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLinkManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LinkMan> list = linkManService.findAllLinkMan();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

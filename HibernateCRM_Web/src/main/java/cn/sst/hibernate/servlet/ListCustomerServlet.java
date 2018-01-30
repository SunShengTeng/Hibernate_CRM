package cn.sst.hibernate.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.sst.hibernate.Service.CustomerService;
import cn.sst.hibernate.Service.Impl.CustomerServiceImpl;
import cn.sst.hibernate.entity.Customer;
import cn.sst.hibernate.utils.HibernateUtils;

/**
 * Servlet implementation class ListCustomerServlet
 */
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService  = new CustomerServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustomerServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Customer> list = null;
		//        查询条件
		String cust_name = request.getParameter("cust_name");
		String cust_level= request.getParameter("cust_level");
		String cust_source = request.getParameter("cust_source");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);

		if (cust_name!=null && !"".equals(cust_name)) {
			detachedCriteria.add(Restrictions.like("cust_name", "%"+cust_name+"%"));	
		}
		if (cust_level!=null && !"".equals(cust_level)) {
			detachedCriteria.add(Restrictions.like("cust_level", "%"+cust_level+"%"));	
		}
		if (cust_source!=null && !"".equals(cust_source)) {
			detachedCriteria.add(Restrictions.like("cust_source", "%"+cust_source+"%"));	
		}
		list =  customerService.getAllCustomer(detachedCriteria);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);

	}
	@Test
    public void testDemo(){
    	DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
//		detachedCriteria.add(Restrictions.like("cust_name", "%"+null+"%"));	
        List<Customer> list = customerService.getAllCustomer(detachedCriteria);
        System.out.println(list);
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

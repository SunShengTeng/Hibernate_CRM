package cn.sst.hibernate.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import cn.sst.hibernate.Service.CustomerService;
import cn.sst.hibernate.Service.Impl.CustomerServiceImpl;
import cn.sst.hibernate.entity.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private CustomerService customerService = new CustomerServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer customer = new Customer();
		
		try {
			BeanUtils.populate(customer, request.getParameterMap());
			
		} catch (Exception e) {
			
		}
		customerService.insertCustomer(customer);
		
		response.sendRedirect(request.getContextPath()+"/ListCustomerServlet");
		
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

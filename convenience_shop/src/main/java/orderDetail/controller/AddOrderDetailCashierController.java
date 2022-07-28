package orderDetail.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.model.OrderDetail;
import orderDetail.dao.OrderDetailDAO;

@WebServlet("/AddOrderDetailCashierController")
public class AddOrderDetailCashierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDetailDAO dao;
       
    public AddOrderDetailCashierController() {
        super();
        dao = new OrderDetailDAO();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDetail od = new OrderDetail();
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		od.setOrderID(orderid);
		od.setProductID(Integer.parseInt(request.getParameter("productID")));
		od.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		dao.addOrderDetail(od); //invoke method addOrder() in OrderDAO
		
		request.setAttribute("orderid", orderid);
		RequestDispatcher view = request.getRequestDispatcher("addOrderCashier.jsp");
		view.forward(request, response);
	}

}

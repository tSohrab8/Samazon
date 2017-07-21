

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbCart;
import model.Shoppingcart;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		Integer productid = Integer.parseInt(request.getParameter("product"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));

		Shoppingcart shop = new Shoppingcart();
		shop.setProductid(productid);
		shop.setQuantity(quantity);
		shop.setUserid(3);
		
		DbCart.insert(shop);
		
		List<Shoppingcart> list = DbCart.listOfProducts();
		
		session.setAttribute("list", list);
		
		//response.getWriter().append(cart.printProducts());
		response.sendRedirect(request.getContextPath() + "/cart.jsp");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.Cart;
import bean.Order;
import bean.Payment;
import bean.Product;
import dao.CartDao;
import dao.OrderDao;
import dao.PaymentDao;
import dao.ProductDao;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String secret=request.getParameter("secret");
		if(secret.equals("PlaceOrder")) {
			String cardNum=request.getParameter("cardNum");
			String expDate=request.getParameter("expDate");
			String cvv=request.getParameter("cvv");
			String state=request.getParameter("state");
			String pincode=request.getParameter("pincode");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			
			HttpSession session=request.getSession(false);  
			int uId=(int)session.getAttribute("uId");
			
			Payment payment=new Payment();
			payment.setCardNum(cardNum);
			payment.setCvv(cvv);
			payment.setExpDate(expDate);
			payment.setUId(uId);
			
			PaymentDao pd=new PaymentDao();
			int payId=pd.savePaymentdetailsAndGetPayId(payment);
			int msg=0;
			if (payId>-1) {
				CartDao cd=new CartDao();
				List<Cart> listProducts =cd.getAllCartByUid(uId);
				for (Cart cart : listProducts) {
					Order o=new Order();
					o.setState(state);
					o.setPincode(pincode);
					o.setEmail(email);
					o.setPhone(phone);
					o.setQty(cart.getQty());
					o.setBasePrice(cart.getBasePrice());
					o.setTotalAmount(cart.getTotalPrice());
					o.setPayId(payId);
					o.setUId(uId);
					o.setPid(cart.getPid());
					
					OrderDao od=new OrderDao();
					msg=od.saveOrder(o);
					if(msg>0) {
						ProductDao prodao=new ProductDao();
						prodao.updateStock(o.getQty(),o.getPid());
						CartDao c=new CartDao();
						c.removeCartByUID(uId);
						int cartCount=cd.getCartCount(uId);
						session.setAttribute("cartCount", cartCount);
						msg=1;
					}
				}
				if(msg==1) {
					out.print("OrderPlaced");
				}
				
			} else {
				out.print("paymentFailed");
			}
			
		}else if(secret.equals("viewOrders")) {
			OrderDao od=new OrderDao();
			List<Order> list=od.getAllOrders();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(list);			    
			out.print(JSONObject);	
		}
	}

}

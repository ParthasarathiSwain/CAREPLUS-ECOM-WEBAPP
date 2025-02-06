package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.Product;
import dao.ProductDao;
import utility.DbConnection;


@WebServlet("/ProductServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String secret=request.getParameter("secret");
		
		if(secret.equals("SaveServlet")) {
			String  pname=request.getParameter("pName");
			String  pdesc=request.getParameter("pDesc");
			int  availability=Integer.parseInt(request.getParameter("qty"));
			Double  price=Double.parseDouble(request.getParameter("price"));
			String  manufDate=request.getParameter("manfDate");
			String  expDate=request.getParameter("expDate");
			int  catId=Integer.parseInt(request.getParameter("catId"));
			int  comId=Integer.parseInt(request.getParameter("comId"));
			
			//image start
			Part p=request.getPart("pImg");
			String path=DbConnection.Path();
			String appPath =path+"/productImg";
			String imagePath = appPath + "";
			File fileDir = new File(imagePath);
		        if (!fileDir.exists()) 
		                 fileDir.mkdirs();
		    String orifileName = p.getSubmittedFileName();
		    String fileExt1 = orifileName.substring(orifileName.length()-3);
		    String imgname1=new Date().getTime() +"1"+"."+fileExt1;
		    String finalImgPath="productImg" + "/"+ imgname1;
		    if (validateImage1(orifileName)) {
		    	 try{
		                p.write(imagePath + "/" + imgname1);
		            }catch (Exception ex) { 
		            	ex.printStackTrace();
		            }
			}
		    
			//image end
		    Product product=new Product();
		    product.setAvailability(availability) ;
		    product.setCatId(catId) ;
		    product.setComId(comId) ;
		    product.setExpDate(expDate) ;
		    product.setImgName(imgname1) ;
		    product.setManufDate(manufDate) ;
		    product.setPname(pname) ;
		    product.setPrice(price) ;
		    product.setPdesc(pdesc) ;
		    
		    ProductDao pd=new ProductDao();
		    int msg=pd.saveProduct(product);
		    if (msg>0) {
				out.print("done");
			} else {
				out.print("fail");
			}
		  
		}else if(secret.equals("viewAllProducts")) {
			ProductDao pd=new ProductDao();
			List<Product> list=pd.getAllProduct();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(list);			    
			out.print(JSONObject);	
		}else if(secret.equals("inactiveProduct")) {
			int pid=Integer.parseInt(request.getParameter("pid"));
			ProductDao pd=new ProductDao();
			int msg=pd.inactiveStatusById(pid);
			if (msg>0) {
				out.print("done");
			} else {
				out.print("fail");
			}
		}else if(secret.equals("getProductById")) {
			int pid=Integer.parseInt(request.getParameter("pid"));
			ProductDao pd=new ProductDao();
			Product product =pd.getProductById(pid);
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(product);			    
			out.print(JSONObject);	
		}else if(secret.equals("updateServlet")) {
			String  pname=request.getParameter("pName");
			String  pdesc=request.getParameter("pDesc");
			int  availability=Integer.parseInt(request.getParameter("qty"));
			Double  price=Double.parseDouble(request.getParameter("price"));
			String  manufDate=request.getParameter("manfDate");
			String  expDate=request.getParameter("expDate");
			int  catId=Integer.parseInt(request.getParameter("catId"));
			int  comId=Integer.parseInt(request.getParameter("comId"));
			String  status=request.getParameter("status");
			int  pid=Integer.parseInt(request.getParameter("pid"));
			
			//image start
			Part p=request.getPart("pImg");
			String path=DbConnection.Path();
			String appPath =path+"/productImg";
			String imagePath = appPath + "";
			File fileDir = new File(imagePath);
		        if (!fileDir.exists()) 
		                 fileDir.mkdirs();
		    String orifileName = p.getSubmittedFileName();
		    String fileExt1 = orifileName.substring(orifileName.length()-3);
		    String imgname1=new Date().getTime() +"1"+"."+fileExt1;
		    String finalImgPath="productImg" + "/"+ imgname1;
		    if (validateImage1(orifileName)) {
		    	 try{
		                p.write(imagePath + "/" + imgname1);
		            }catch (Exception ex) { 
		            	ex.printStackTrace();
		            }
			}
		    
			//image end
		    Product product=new Product();
		    product.setAvailability(availability) ;
		    product.setCatId(catId) ;
		    product.setComId(comId) ;
		    product.setExpDate(expDate) ;
		    product.setImgName(imgname1) ;
		    product.setManufDate(manufDate) ;
		    product.setPname(pname) ;
		    product.setPrice(price) ;
		    product.setPdesc(pdesc) ;
		    product.setStatus(status);
		    product.setPid(pid);
		    ProductDao pd=new ProductDao();
		    int msg=pd.updateProduct(product);
		    if (msg>0) {
				out.print("done");
			} else {
				out.print("fail");
			}
		  
		}
		
		
		
	}
	private boolean validateImage1(String orifileName){
	      String fileExt1 = orifileName.substring(orifileName.length()-3);
	      if("jpg".equals(fileExt1) || "png".equals(fileExt1) || "gif".equals(fileExt1))
	      { 
	    	  return true;
	      }
	      return false;
	    }
}

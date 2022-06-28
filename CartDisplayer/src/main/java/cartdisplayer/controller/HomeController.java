package cartdisplayer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import cartdisplayer.dao.ProductDao;
import cartdisplayer.model.Product;

@Controller
public class HomeController {

	@Autowired
   private ProductDao productDao;
	
	@RequestMapping(value={"/home","/"} ,method=RequestMethod.GET)
	public String home(Model m)
	{
		
		List<Product>products= productDao.getallProducts();
		m.addAttribute("products",products);
		m.addAttribute("title","This is dynamic from controller");
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addproduct(Model m)
	{
		m.addAttribute("title"," Dynamic Add Product");
		return "add-product-form";
	}
	
	
	@RequestMapping(value="/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product p , HttpServletRequest request)
	{
		System.out.println(p);
		
		
		this.productDao.createProduct(p);
		RedirectView redirectView= new RedirectView();
	     redirectView.setUrl(request.getContextPath() +"/");
				
		return redirectView;
		
	}
	@RequestMapping("/delete/{ipd}")
	public RedirectView deleteProduct(@PathVariable("ipd") int pid,HttpServletRequest request) 
	{
		RedirectView redirectView= new  RedirectView();
		productDao.deleteProduct(pid);
		redirectView.setUrl(request.getContextPath() +"/");
		return redirectView;
		
	}
	
	
}

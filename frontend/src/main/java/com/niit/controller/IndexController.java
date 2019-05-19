package com.niit.controller;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.OrderDetailsDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.dao.UserDao;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;





@Controller
public class IndexController {
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	OrderDetailsDao orderDetailsDao;

	
	@RequestMapping(value="index") 
	public String index(Model model) { 
		model.addAttribute("category", new Category()); 
		model.addAttribute("supplier", new Supplier()); 
		model.addAttribute("product", new Product()); 
		
		model.addAttribute("supplist", supplierDao.retrieve());
		model.addAttribute("catlist", categoryDao.retrieve());
		model.addAttribute("prodList", productDao.retrieve());
		return "index"; 
	}
	
	/*@RequestMapping(value="check") 
	public String displayLogin(Model model) { 
		model.addAttribute("category", new Category()); 
		model.addAttribute("supplier", new Supplier()); 
		model.addAttribute("product", new Product()); 
		
		model.addAttribute("supplist", supplierDao.retrieve());
		model.addAttribute("catlist", categoryDao.retrieve());
		model.addAttribute("prodList", productDao.retrieve());
		return "check"; 
	}*/
	@RequestMapping(value="/") 
	public String home(Model model) { 
		model.addAttribute("category", new Category()); 
		model.addAttribute("supplier", new Supplier()); 
		model.addAttribute("product", new Product()); 
		
		model.addAttribute("supplist", supplierDao.retrieve());
		model.addAttribute("catlist", categoryDao.retrieve());
		model.addAttribute("prodList", productDao.retrieve());
		return "index"; 
	}
	
	
	
	
	@RequestMapping(value="/goToRegister", method=RequestMethod.GET)
	public ModelAndView showRegister()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("supplist", supplierDao.retrieve());
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("prodList", productDao.retrieve());
		mv.setViewName("register");
		return mv; 
	}
	
	@RequestMapping("/goToLogin")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("supplist", supplierDao.retrieve());
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("prodList", productDao.retrieve());
		mv.setViewName("login");
		return mv; 
	}

	@RequestMapping("/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("supplist", supplierDao.retrieve());
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("prodList", productDao.retrieve());
		mv.setViewName("About");
		return mv; 
	}
	@RequestMapping("/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("supplist", supplierDao.retrieve());
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("prodList", productDao.retrieve());
		mv.setViewName("contactUs");
		return mv; 
	}
	
	@RequestMapping("login")
	public ModelAndView login(@RequestParam(value="id",required=false) String id)
	{	ModelAndView m=new ModelAndView("login");
		System.out.println(id);
		if(id!=null){
		if(id.equals("1"))
			m.addObject("msg","Invalid Username or Password");
		else if(id.equals("2"))
			m.addObject("msg","You've been logged out");
		else if(id.equals("3"))
			m.addObject("msg","Your Account has been Deactivated");		
		}
		m.addObject("supplist", supplierDao.retrieve());
		m.addObject("catlist", categoryDao.retrieve());
		m.addObject("prodList", productDao.retrieve());
		return m;	
	}
	
	@RequestMapping(value="/login_success",method=RequestMethod.POST)
	public String loginsuccess(@RequestParam Map<String,String> user,HttpSession session)
	{ 
		String username= SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(username);
		String name = userDao.getUserName(username);
		String address = userDao.getUserAddress(username);
		String phone = userDao.getUserPhone(username);
		System.out.println(address);
		System.out.println(phone);
		User userDetails=userDao.getUser(user.get("username"));
		userDetails.setEnabled(true);
		userDao.insertOrUpdateUser(userDetails);
		session.setAttribute("username",username);
		session.setAttribute("name", name);
		session.setAttribute("usertitle",name.charAt(0));
		session.setAttribute("loggedIn",true);
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority role:authorities)
		{
			System.out.println("Role:"+role.getAuthority()+"username"+username);
			if(role.getAuthority().equals("ROLE_ADMIN"))
				session.setAttribute("user",null);
			else
				session.setAttribute("user","user");
			}
		return "redirect:index";
	}

	
	
	@RequestMapping(value="/addUserDetails",method=RequestMethod.POST)
	public ModelAndView addProduct(@RequestParam Map<String,String> user,@RequestParam("phone") String mobile)
	{	ModelAndView m=new ModelAndView();
		User userDetails=userDao.getUser(user.get("name"));
		if(userDetails!=null&&userDetails.isEnabled()==true){
		m.addObject("userExist","Username Already Exist");
		m.setViewName("register");
		}
		else{
		userDetails =new User();
		userDetails.setAddress(user.get("address"));
		userDetails.setEmail(user.get("email"));
		userDetails.setName(user.get("name"));
		userDetails.setPassword(user.get("password"));
		userDetails.setPhone(mobile);
		userDetails.setEnabled(true);
		userDetails.setRole("ROLE_USER");
		userDao.insertOrUpdateUser(userDetails);
		m.addObject("userCreate","Account Created");
		m.setViewName("login");
		}
		return m;
	}
	
	
	
	
	@RequestMapping("/userLogged")
	public String userLogged()
	{
		return "redirect:/index";
	}
	
	@RequestMapping("/error")
	public String userError()
	{
		return "/error";
	}
	
	@RequestMapping("/reLogin")
	public String reLogin()
	{
		return "redirect:/goToLogin";
	}
	
	
	
	@RequestMapping("viewProducts")
	public ModelAndView showProducts(@RequestParam("cat_id") int cid)
	{
		System.out.println("Shop By Category");
		ModelAndView mv = new ModelAndView();
		mv.addObject("prodList", productDao.getProductByCatID(cid));
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("catId", categoryDao.getCategory(cid));
		mv.setViewName("proCategory");
		return mv; 
	}
	
	@RequestMapping("productDetails")
	public ModelAndView showProductDetails(@RequestParam("pro_id") int pid)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("prod", productDao.getProduct(pid));
		mv.addObject("catlist", categoryDao.retrieve());
		
		int cid = categoryDao.getCategoryByPid(pid);
		
		mv.addObject("prodList", productDao.getProductByCatID(cid));
		System.out.println("Hello");
		mv.addObject("prod", productDao.findByPID(pid));
		System.out.println("ProductDetails");
		mv.setViewName("prodDetails");
		return mv; 
	}
	
	
	@RequestMapping("allProducts")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("supplist", supplierDao.retrieve());
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("prodList", productDao.retrieve());
		mv.setViewName("allProducts");
		return mv; 
	}
	
	

	@RequestMapping("myAccount")
	public ModelAndView showAccount(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		String phone=(String)session.getAttribute("phone");
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		mv.addObject("supplist", supplierDao.retrieve());
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("prodList", productDao.retrieve());
		mv.addObject("user", userDao.getUser(email));
		mv.addObject("phone" ,phone);
		mv.setViewName("myAccount");
		return mv; 
	}
	
	
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public ModelAndView updateUser(@RequestParam Map<String,String> user,HttpSession session)
	{	ModelAndView m=new ModelAndView("redirect:myAccount");
		String username=(String)session.getAttribute("username");
		User userDetails=userDao.getUser(username);
		if(user.get("name")!=null)
		userDetails.setName(user.get("name"));
		if(user.get("address")!=null)
		userDetails.setAddress(user.get("address"));	
		if(user.get("phone")!=null)
		userDetails.setPhone(user.get("phone"));	
		userDao.insertOrUpdateUser(userDetails);
		
		
		String name = userDao.getUserName(username);
		session.setAttribute("name", name);
		session.setAttribute("usertitle",name.charAt(0));
		
		return m;
	}
	
	
	
	@RequestMapping(value="/changePass")
	public ModelAndView changePass(@RequestParam("currentPass") String cPass,@RequestParam("newPass") String nPass,HttpSession session)
	{	ModelAndView m=new ModelAndView("myAccount");
		String user=(String)session.getAttribute("username");
		User userDetails=userDao.getUser(user);	
		if(cPass.equals(userDetails.getPassword())){
			userDetails.setPassword(nPass);
			userDao.insertOrUpdateUser(userDetails);
			m.addObject("info","password changed successfully");
		}
		else{
			m.addObject("info","Error while changing password");	
		}
		m.addObject("user",userDetails);
		return m;
	}
	
	
	
	
	@RequestMapping(value="/deactivateAccount")
	public String deactivateAccount(HttpSession session)
	{	String user=(String)session.getAttribute("username");
		User userDetails=userDao.getUser(user);	
		userDetails.setEnabled(false);
		userDao.insertOrUpdateUser(userDetails);
		List<Cart> cartList=cartDao.findByCartId(user);
		if(!cartList.isEmpty())
			for(Cart cart:cartList)
				cartDao.deleteCart(cart.getCartId());
		cartList=cartDao.getPurchasedProducts(user);
		if(!cartList.isEmpty())
			for(Cart cart:cartList)
				cartDao.deleteCart(cart.getCartId());
		System.out.println("CartDeleted");
		orderDetailsDao.deleteOrderDetails(user);
		session.invalidate();
		return "redirect:login?id=3";
	}
	
	
	
	
}

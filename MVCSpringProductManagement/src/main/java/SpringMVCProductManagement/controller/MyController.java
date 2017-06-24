package SpringMVCProductManagement.controller;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import SpringMVCProductManagement.dao.ProductsDAO;
import SpringMVCProductManagement.entity.User;
import SpringMVCProductManagement.model.ManagerInfo;
import SpringMVCProductManagement.dao.ManagerDAO;
import SpringMVCProductManagement.model.ProductsInfo;
import SpringMVCProductManagement.model.StaffInfo;
import SpringMVCProductManagement.dao.StaffDAO;
import SpringMVCProductManagement.validator.ProductsValidator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
//Cần thiết cho Hibernate Transaction.
@Transactional
//Cần thiết để sử dụng RedirectAttributes
@EnableWebMvc
public class MyController {
	private static final int STAFF = 1;
	private static final int MANAGER = 2;
	private String username;
 	private int role = 0;

	 @Autowired
	   private ProductsDAO productsDAO;
	 	
	 @Autowired
	   private StaffDAO staffDAO;
	 
	 @Autowired
	   private ManagerDAO managerDAO;
	 
	   @Autowired
	   private ProductsValidator productValidator;
	 
	   @RequestMapping("/")
	   public ModelAndView homePage(Model model) {
	 
		   return new ModelAndView("user", "command", new User());
	   }
	   
	   @RequestMapping(value = "/user", method = RequestMethod.GET)
	   public ModelAndView user() {
	      return new ModelAndView("user", "command", new User());
	   }

	   @RequestMapping(value = "/processUser", method = RequestMethod.POST)
	   public String processUser(@ModelAttribute("SpringWeb")User user, 
	      ModelMap model, final RedirectAttributes redirectAttributes) {
	      //model.addAttribute("username", user.getUsername());
	      //model.addAttribute("password", user.getPassword());
	      
	      System.out.println("User: "+ user.getUsername());
	      this.username = user.getUsername();
	      System.out.println("Password: "+ user.getPassword());
	      
	      // Kiểm tra user có tồn tại ko
	      StaffInfo staffInfo = null;
	      staffInfo = this.staffDAO.findStaffInfo(username);
	       if (staffInfo != null) {	
	           if(user.getPassword().equals(staffInfo.getPassword()) && user.getPassword().equals(username)) {
	        	   role = STAFF;
	        	   return "redirect:/changePassword";
	           }
	           else {
	        	   if(staffInfo.getPassword().equals(String.valueOf(user.getPassword().hashCode()))) {
	        		   role = STAFF;
		        	   return "redirect:/staffProductsList";
	        	   }
	           }
	       }
    	   ManagerInfo managerInfo = null;
 	       managerInfo = this.managerDAO.findManagerInfo(username);
	 	   if (managerInfo != null) {	
		 		  if(user.getPassword().equals(managerInfo.getPassword()) && user.getPassword().equals(username)) {
		        	   role = MANAGER;
		        	   return "redirect:/productsList";
		           }
		           else {
		        	   if(managerInfo.getPassword().equals(String.valueOf(user.getPassword().hashCode()))) {
		        		   role = MANAGER;
			        	   return "redirect:/productsList";
		        	   }
		           }
		   }
		 	    
	       
	        redirectAttributes.addFlashAttribute("message", "Please input valid User ID and password!");
       		return "redirect:/user";
	   }
	   
	   @RequestMapping("/403Page")
	   public String accessDenied(Model model) {
	           model.addAttribute("message", "Hi " 
	                   + "<br> You do not have permission to access this page!");
	       return "403Page";
	   }
	   
//////////////////////////////	   
	   @RequestMapping("/productsList")
	   public String productsList(Model model) {
		   if(role != MANAGER) {
			   return "redirect:/403Page";
		   }
	       List<ProductsInfo> list = productsDAO.listProductsInfos();
	       model.addAttribute("productsInfos", list);
	       return "productsList";
	   }
	   
	   private String formProducts(Model model, ProductsInfo productsInfo) {
		   if(role != MANAGER) {
			   return "redirect:/403Page";
		   }
	       model.addAttribute("productsForm", productsInfo);
	       return "formProducts";
	   }
	   
	   @RequestMapping("/createProducts")
	   public String createProducts(Model model) {
		   ProductsInfo productsInfo = new ProductsInfo();
	       return this.formProducts(model, productsInfo);
	   }
	   
	   
	   private String formProductsEdit(Model model, ProductsInfo productsInfo) {
		   if(role != MANAGER) {
			   return "redirect:/403Page";
		   }
	       model.addAttribute("productsEditForm", productsInfo);
	       return "editProductsForm";
	   }
	   
	   @RequestMapping("/editProducts")
	   public String editProducts(Model model, @RequestParam("id") int id) {
		   ProductsInfo productsInfo = null;
	       if (id != 0) {
	    	   productsInfo = this.productsDAO.findProductsInfo(id);
	       }
	       if (productsInfo == null) {
	           return "redirect:/productsList";
	       }
	 
	       return this.formProductsEdit(model, productsInfo);
	   }
	   
	   @RequestMapping("/deleteProducts")
	   public String deleteProducts(Model model, @RequestParam("id") int id) {
	       if (id != 0) {
	           this.productsDAO.deleteProducts(id);
	       }
	       return "redirect:/productsList";
	   }
	   
	   @RequestMapping(value = "/saveProducts", method = RequestMethod.POST)
	   public String saveProducts(Model model, //
	           @ModelAttribute("productsForm") @Validated ProductsInfo productsInfo, //
	           BindingResult result, //
	           final RedirectAttributes redirectAttributes) {
		   if(role != MANAGER) {
			   return "redirect:/403Page";
		   }
	       // Nếu validate có lỗi.
	       if (result.hasErrors()) {
	           return this.formProducts(model, productsInfo);
	       }
	 
	       this.productsDAO.saveProducts(productsInfo);
	 
	       // Important!!: Need @EnableWebMvc
	       // Add message to flash scope
	       redirectAttributes.addFlashAttribute("message", "Save Products Successful");
	 
	       return "redirect:/productsList";
	 
	   }
	   @RequestMapping(value="/listProductDelete", method=RequestMethod.POST)
	   public String listProductDelete(@RequestParam("list") String listproduct) {
	       //do smthin
		   //String[] parts = listproduct.split("-");
		   int count = StringUtils.countMatches(listproduct, ",");
		   System.out.println(listproduct);
		   System.out.println(count);
		   String[] parts = listproduct.split(",");
		   int id, i;
		   for(i = 0; i < count; i++) {
			   System.out.println(parts[i]);
			   id = Integer.parseInt(parts[i]);
			   this.productsDAO.deleteProducts(id);
		   }
		   id = Integer.parseInt(parts[i]);
		   this.productsDAO.deleteProducts(id);
		   return "redirect:/productsList";
	   }
	// Set a form validator
	   @InitBinder
	   protected void initBinder(WebDataBinder dataBinder) {
	   
	       // Form mục tiêu
	       Object target = dataBinder.getTarget();
	       if (target == null) {
	           return;
	       }
	       System.out.println("Target=" + target);
	 
	       if (target.getClass() == ProductsInfo.class) {
	           dataBinder.setValidator(productValidator);
	       }
	   }
	   //////////////////////////////////
	   @RequestMapping("/staffProductsList")
	   public String staffProductsList(Model model) {
		   if(role != STAFF) {
			   return "redirect:/403Page";
		   }
	       List<ProductsInfo> list = productsDAO.listProductsInfos();
	       model.addAttribute("productsInfos", list);
	       return "staffProductsList";
	   }
	   
	   @RequestMapping("/changePassword")
	   public String changePassword(Model model) {
		   if(role != STAFF) {
			   return "redirect:/403Page";
		   }
		   System.out.println("change password");
	       return "changePassword";
	   }
	   
	   @RequestMapping(value = "/confirmChangePassword", method = RequestMethod.POST)
	   public String confirmChangePassword(@RequestParam("current") String current,
			   @RequestParam("new") String newpass,
			   @RequestParam("retypenew") String retypenew,
	      ModelMap model, final RedirectAttributes redirectAttributes) {
		   System.out.println(current);
		   System.out.println(newpass);
		   System.out.println(retypenew);
		   StaffInfo staffInfo = null;
	       if (username != null) {
	    	   staffInfo = this.staffDAO.findStaffInfo(username);
	       }
	       if (staffInfo == null) {	
	           return "redirect:/user";
	       }
		   if(staffInfo.getPassword().equals(current.hashCode())) {
			   if(newpass.equals(retypenew)) {
				   staffInfo.setPassword(String.valueOf(newpass.hashCode()));
				   this.staffDAO.saveStaff(staffInfo);
				   redirectAttributes.addFlashAttribute("message", "Your password has been changed successfully!");
				   return "redirect:/staffProductsList";
			   }
			   else {
				   redirectAttributes.addFlashAttribute("message", "Retype password incorrect!");
		      		return "redirect:/changePassword";
			   }
		   }
		   else {
			   if(staffInfo.getPassword().equals(current) && current.equals(username)) {
				   if(newpass.equals(retypenew)) {
					   staffInfo.setPassword(String.valueOf(newpass.hashCode()));
					   this.staffDAO.saveStaff(staffInfo);
					   redirectAttributes.addFlashAttribute("message", "Your password has been changed successfully!");
					   return "redirect:/staffProductsList";
				   }
				   else {
					   redirectAttributes.addFlashAttribute("message", "Retype password incorrect!");
			      		return "redirect:/changePassword";
				   }
			   }
			   else {
				   redirectAttributes.addFlashAttribute("message", "Please input valid current password!");
				   return "redirect:/changePassword";
			   }  
		   }
	   }
	   
	   private String formStaff(Model model, StaffInfo staffInfo) {
	       model.addAttribute("id", staffInfo.getId());
	        model.addAttribute("name", staffInfo.getName());
	       return "formStaff";
	   }
	   
	   @RequestMapping("/infoStaff")
	   public String infoStaff(Model model) {
		   if(role != STAFF) {
			   return "redirect:/403Page";
		   }
		   StaffInfo staffInfo = null;
	       if (username != null) {
	    	   staffInfo = this.staffDAO.findStaffInfo(username);
	       }
	       if (staffInfo == null) {	
	           return "redirect:/user";
	       }
	       
	       return this.formStaff(model, staffInfo);
	   }
	   
	  
	   
}



package com.exam.login;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.CurrentAddress;
import com.exam.OrdersRecord;
import com.exam.Product;
import com.exam.User_info;
import com.exam.Data.CurrentAdderssData;
import com.exam.Data.OrdersRecordData;
import com.exam.Data.SearchData;
import com.exam.Data.User_infoData;


@Controller
public class LoginController {
	String email;
	String name;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDateTime localDate = LocalDateTime.now();
	String date = dtf.format(localDate);

	// Login page
	@RequestMapping("/")
	public String home12(Model model) {
		return "loginPage";
	}
	
	// Log out page
	@RequestMapping("/logout")
	public String f(Model model) {

		SearchData sd = new SearchData();
		model.addAttribute("user", sd.findByEmailFromUser_info(email));
		return "loginPage";
	}

	// Login to home page
	@RequestMapping("/openHome")
	public String d(Model md, User_info ui) {
		String log = "";
		LoginData da = new LoginData();
		SearchData sd = new SearchData();

		try {
			String st = sd.LoginEmailPasswordMatch(ui.getEmail(), ui.getPassword());
			if ("Success".equals(st)) {
				md.addAttribute("product", da.productShow());
				md.addAttribute("user", sd.findByEmailFromUser_info(ui.getEmail()));
				email = ui.getEmail();
				name = ui.getName();
				log = "home";
			} else {
				md.addAttribute("msg", "email or password is wrong");
				log = "loginPage";
			}
		} catch (Exception e) {

			System.out.println(e);
		}
		return log;
	}

	// Insert into orders record from home page
	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public String addtocart(@ModelAttribute() OrdersRecord or, Model model, RedirectAttributes ra) {
		SearchData sd = new SearchData();
		OrdersRecordData od = new OrdersRecordData();
		od.doInsert(or);

		List<OrdersRecord> list = sd.searchByEmail_date(email, date);

		ra.addFlashAttribute("cartsucced", "Successfully add to Mycart");
		model.addAttribute("user", sd.findByEmailFromUser_info(email));
		ra.addFlashAttribute("size", list.size());
		return "redirect:/home";

	}

	// Search from order record by email and current date
	@RequestMapping("/mycart")
	public String d(Model model) {
		double total = 0.0;
		SearchData sd = new SearchData();
	

		List<OrdersRecord> list = sd.searchByEmail_date(email, date);
		model.addAttribute("mycart", list);
	
		for (OrdersRecord or : list) {
			total = total + or.getQuantity() * or.getPrice();
		}
		model.addAttribute("total", total);
		return "myCart";
	}
	
	// delete from orders record
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute() OrdersRecord or, Model model) {
		OrdersRecordData od = new OrdersRecordData();
		SearchData sd = new SearchData();
		od.doDelete(or);
		List<OrdersRecord> list = sd.searchByEmail_date(email, date);
		model.addAttribute("user", sd.findByEmailFromUser_info(email));
		model.addAttribute("mycart", list);
		
		double total = 0.0;
		for (OrdersRecord o : list) {
			total = total + o.getQuantity() * o.getPrice();
		}
		model.addAttribute("total", total);
		return "myCart";

	}
	
	// Update to orders record
	@RequestMapping(value = "/quantityUpdate", method = RequestMethod.POST)
	public String quantityUpdate(@ModelAttribute() OrdersRecord or, Model model, RedirectAttributes ra) {
		OrdersRecordData od = new OrdersRecordData();
		SearchData sd = new SearchData();
		od.doUpdate(or);
		
		List<OrdersRecord> list = sd.searchByEmail_date(email, date);
		model.addAttribute("user", sd.findByEmailFromUser_info(email));
		model.addAttribute("mycart", list);
		
		double total = 0.0;
		for (OrdersRecord o : list) {
			total = total + o.getQuantity() * o.getPrice();
		}
		model.addAttribute("total", total);
		return "myCart";

	}


	// Prepare bill
	@RequestMapping("/prepareBill")
	public String prepareBill(Model model) {
		SearchData sd = new SearchData();
	
		List<OrdersRecord> list = sd.searchByEmail_date(email, date);
		model.addAttribute("user", sd.findByEmailFromUser_info(email));
		model.addAttribute("mycart", list);

		
		double total = 0.0;
		for (OrdersRecord o : list) {
			total = total + o.getQuantity() * o.getPrice();
		}
		model.addAttribute("total", total);

		return "prepareBill";
	}
	
	// Create a invoice
	@RequestMapping(value = "/invoice", method = RequestMethod.POST)
	public String delete(@ModelAttribute() CurrentAddress ca, Model model, @RequestParam String name, String address,
			String phone, String paymentMethod) {
		SearchData sd = new SearchData();
		CurrentAdderssData cd = new CurrentAdderssData();
		cd.doInsert(ca);
		
		
		List<OrdersRecord> list = sd.searchByEmail_date(email, date);
		model.addAttribute("user", sd.findByEmailFromUser_info(email));
		model.addAttribute("mycart", list);
	
		// print current date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime localDate = LocalDateTime.now();
		LocalDateTime localDate_1day = localDate.plusDays(1);
		String date1 = dtf.format(localDate);
		String date_1day = dtf.format(localDate_1day);
		model.addAttribute("returnDate", date1);
		model.addAttribute("onedayIncriase", date_1day);
		// Calculation price
		double total = 0.0;
		double vat = 0.0;
		double delibery = 25.00;
		double discount = 0.0;
		double payment = 0.0;

		for (OrdersRecord o : list) {
			total = total + o.getQuantity() * o.getPrice();
		}

		vat = (total * 2) / 100;

		if (total >= 2000.00) {
			discount = (total * 3) / 100;
		} else {
			discount = 0.0;
		}
		payment=(total+vat+delibery)-discount;
		model.addAttribute("total", total);
		model.addAttribute("vat", vat);
		model.addAttribute("delibery", delibery);
		model.addAttribute("discount", discount);
		model.addAttribute("payment", payment);

		// cd.insertBill(ba);
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		model.addAttribute("phone", phone);
		model.addAttribute("paymentMethod", payment);
	//	model.addAttribute("mycart", md.myCartShow());

		return "invoice";

	}


	// search method
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(Model md, @ModelAttribute Product p, @RequestParam String pid) {

		try {

			SearchData sd = new SearchData();
			md.addAttribute("product", sd.getByAnyFromProduct(pid));
			md.addAttribute("user", sd.findByEmailFromUser_info(email));

		} catch (Exception e) {

			System.out.println(e);
		}
		return "home";
	}

	@RequestMapping("/messageUs")
	public String messageUs(Model md) {
		SearchData sd = new SearchData();
		md.addAttribute("user", sd.findByEmailFromUser_info(email));

		return "messageUs";
	}





// home page
	@RequestMapping("/home")
	public String home(Model md) {

		LoginData da = new LoginData();
		SearchData sd = new SearchData();
		md.addAttribute("product", da.productShow());
		md.addAttribute("user", sd.findByEmailFromUser_info(email));
		return "home";
	}

	// insert for SignUp
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String save(@ModelAttribute() User_info ui, Model model, RedirectAttributes ra) {
		User_infoData uid = new User_infoData();
		uid.doInsert(ui);
		ra.addFlashAttribute("msg", "Welcome to " + ui.getName() + " you can login now");

		return "loginPage";

	}

	@RequestMapping(value = "prepare", method = RequestMethod.POST)
	public String login(Model md, @ModelAttribute() User_info ui) {

		LoginData da = new LoginData();

		md.addAttribute("product", da.productShow());

		return "prepareBill";
	}

// Reset password
	@RequestMapping("/resetPassword")
	public String f1() {
		return "resetPassword";
	}

	@RequestMapping(value = "reset", method = RequestMethod.POST)
	public String reset(Model md, @ModelAttribute() User_info user, RedirectAttributes ra) {
		String log = "";
		User_infoData uid = new User_infoData();
		SearchData sd = new SearchData();
		try {
			String st = sd.findByEmailFormUser_info(user.getEmail());
			if ("Success".equals(st)) {

				uid.updatePassword(user);

				ra.addFlashAttribute("resetSuccess", "Successfully reset your password");

				log = "index";

			} else {
				ra.addFlashAttribute("alert", "email or password is rong");
				log = "redirect:/resetPassword";
			}
		} catch (Exception e) {

			System.out.println(e);
		}
		return log;
	}

}

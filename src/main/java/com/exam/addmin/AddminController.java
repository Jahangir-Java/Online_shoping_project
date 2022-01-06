package com.exam.addmin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.Message;
import com.exam.Order;
import com.exam.OrdersRecord;
import com.exam.Product;
import com.exam.Data.MessageData;
import com.exam.Data.ProductData;
import com.exam.Data.SearchData;
import com.exam.Data.OrderData;
import com.exam.Data.OrdersRecordData;

@Controller
public class AddminController {
	List<Product> list = new ArrayList<>();

	// Login to addmin page
	@RequestMapping("/LoginToAddminPage")
	public String f(Model md, @ModelAttribute Product p, @RequestParam String password, RedirectAttributes ra) {
		if (password.equals("122292")) {
			ProductData pd = new ProductData();
			md.addAttribute("product", pd.doShow(p));
			list = pd.doShow(p);
			md.addAttribute("size", list.size());
			return "/addmin/addminPage";

		} else {
			md.addAttribute("msg", "password is wrong");
			return "addmin/addminLogin";
		}

	}

	// product show
	@RequestMapping("/productShow")
	public String f9(Model md, @ModelAttribute Product p) {

		ProductData pd = new ProductData();
		md.addAttribute("product", pd.doShow(p));
		list = pd.doShow(p);
		md.addAttribute("size", list.size());
		return "/addmin/addminPage";

	}

	// customer orders
	@RequestMapping("/customerOrder")
	public String f10(Model md) {

		OrdersRecordData ord = new OrdersRecordData();

		md.addAttribute("customer", ord.doShow());

		return "/addmin/customerOrder";

	}

	// remove from customer orders
	@RequestMapping(value="/deleteFromOrders", method = RequestMethod.POST)
	public String f13(Model md, @ModelAttribute() OrdersRecord or) {

		OrdersRecordData ord = new OrdersRecordData();
		ord.doDelete(or);

		md.addAttribute("customer", ord.doShow());

		return "/addmin/customerOrder";

	}

	// orders records
	@RequestMapping("/ordersRecord")
	public String f11(Model md) {
		List<Order> list = new ArrayList<>();

		OrderData td = new OrderData();
		list = td.doShow();
		md.addAttribute("orders", td.doShow());
		md.addAttribute("size", list.size());
		return "/addmin/ordersRecord";

	}

	// addmin page return from message page
	@RequestMapping("/returnAddminPage")
	public String f8(Model md, @ModelAttribute Product p) {
		ProductData pd = new ProductData();
		md.addAttribute("product", pd.doShow(p));
		list = pd.doShow(p);
		md.addAttribute("size", list.size());
		return "addmin/addminPage";
	}

	// addmin logout
	@RequestMapping("/addminLogout")
	public String f7() {
		return "/loginPage";
	}

	@RequestMapping(value = "/updateByPrice", method = RequestMethod.POST)
	public String f1(Model md, @ModelAttribute() Product p) {
		ProductData pd = new ProductData();
		pd.doUpdate(p);
		md.addAttribute("product", pd.doShow(p));
		list = pd.doShow(p);
		md.addAttribute("size", list.size());
		return "/addmin/addminPage";
	}

	@RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
	public String f2(Model md, @ModelAttribute() Product p) {
		ProductData pd = new ProductData();
		pd.doDelete(p);
		md.addAttribute("product", pd.doShow(p));
		list = pd.doShow(p);
		md.addAttribute("size", list.size());
		return "/addmin/addminPage";
	}

	@RequestMapping(value = "/searchFromProduct", method = RequestMethod.POST)
	public String search(Model md, @RequestParam String id) {

		try {
			SearchData sd = new SearchData();
			List<Product> list = new ArrayList<>();
			md.addAttribute("product", sd.getByAnyFromProduct(id));
			list = sd.getByAnyFromProduct(id);
			md.addAttribute("size", list.size());

		} catch (Exception e) {

			System.out.println(e);
		}
		return "/addmin/addminPage";
	}

	// end addmin page

	@RequestMapping("/addminLogin")
	public String f2() {
		return "/addmin/addminLogin";
	}

	@RequestMapping("/addProduct")
	public String f10() {

		return "/addmin/addProduct";
	}

	@RequestMapping(value = "/updatePrice", method = RequestMethod.POST)
	public String f3(Model model, RedirectAttributes ra, Product p) {
		ProductData da = new ProductData();
		da.doUpdate(p);
		model.addAttribute("product", da.doShow(p));

		return "/addmin/productShow";

	}

	@RequestMapping(value = "/deleteFromShowProduct", method = RequestMethod.POST)
	public String f5(Model model, RedirectAttributes ra, Product p) {
		ProductData da = new ProductData();
		da.doDelete(p);
		model.addAttribute("product", da.doShow(p));

		return "/addmin/productShow";

	}

	@RequestMapping("messageShow")
	public String f6(Model model, RedirectAttributes ra, Message m) {
		MessageData md = new MessageData();

		model.addAttribute("message", md.doShow());

		return "/addmin/messageShow";

	}

}

package presentation.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import business.exceptions.BackendException;
import presentation.data.OrderPres;
import presentation.data.ViewOrdersData;

@Controller
public class OrderHistoryUIControl {

	@RequestMapping("/orderhistory")
	public String viewOrderHistoryHandler(ModelMap modelMap) {
		System.out.println("in order history");
		List<OrderPres> orders = null;
		try {
			orders = ViewOrdersData.INSTANCE.getOrderList();
		} catch (BackendException e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("orders", orders);
		return "orderhistory";
	}
}



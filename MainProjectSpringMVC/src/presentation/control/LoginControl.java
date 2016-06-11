package presentation.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import business.Login;
import business.exceptions.BackendException;
import business.exceptions.UserException;
import presentation.data.BrowseSelectData;
import presentation.data.CartItemPres;
import presentation.data.CatalogPres;
import presentation.data.LoginData;
import presentation.data.ManageProductsData;
import presentation.data.ProductPres;
import presentation.gui.GuiUtils;

@Controller
public class LoginControl {
	LoginData ld = new LoginData();

	
	
	@RequestMapping("/login/callback/{name}")
	public String viewLoginHandler(@PathVariable String name, ModelMap modelMap) {
		modelMap.addAttribute("callback", name);
		return "login";
	}

	@RequestMapping(value = "/login/callback/{name}", method = RequestMethod.POST)
	public String submitLoginHandler(@PathVariable String name, @RequestParam Map<String, String> allRequestParams,
			ModelMap modelMap) {
		try {
			ld.authenticate(new Login(GuiUtils.toInteger(allRequestParams.get("custId")),
					(String) allRequestParams.get("password")));
			modelMap.addAttribute("message", "Successfully Logged In");
			return name;
		} catch (UserException e) {
			modelMap.addAttribute("callback", name);
			modelMap.addAttribute("message", e.getMessage());
			return "login";
		} catch (BackendException e) {
			modelMap.addAttribute("callback", name);
			modelMap.addAttribute("message", e.getMessage());
			return "login";
		}
		
	}

	
}

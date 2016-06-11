package presentation.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import business.exceptions.BackendException;
import presentation.data.BrowseSelectData;
import presentation.data.CatalogPres;

@Controller
public class ManageProductUIController {
	
	@RequestMapping("/addProduct")
	public String viewProductsHandler(ModelMap modelMap) {
		System.out.println("*******************");
		
		return "addProduct";
	}

}

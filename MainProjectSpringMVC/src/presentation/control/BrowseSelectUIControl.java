package presentation.control;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import business.exceptions.BackendException;
import business.usecasecontrol.BrowseAndSelectController;
import javafx.collections.ObservableList;
import business.exceptions.BusinessException;
import business.exceptions.RuleException;
import business.externalinterfaces.Product;
import business.usecasecontrol.BrowseAndSelectController;
import presentation.data.BrowseSelectData;
import presentation.data.CartItemPres;
import presentation.data.CatalogPres;
import presentation.data.DefaultData;
import presentation.data.ManageProductsData;
import presentation.data.ProductPres;

@Controller
public class BrowseSelectUIControl {
	CartItemPres cartPres;
	@RequestMapping(value="/")
	public String viewCatalogsHandler(ModelMap modelMap) {
		System.out.println("in catlog");
		List<CatalogPres> catalogs = null;
		try {
			catalogs = BrowseSelectData.INSTANCE.getCatalogList();
		} catch (BackendException e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("catalogs", catalogs);
		return "catalog";
	}
	/*@RequestMapping("/")
	public String viewCatalogsHandler(ModelMap modelMap) {
		System.out.println("*******************");
		List<CatalogPres> catalogs = null;
		try {
			catalogs = BrowseSelectData.INSTANCE.getCatalogList();
		} catch (BackendException e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("catalogs", catalogs);
		return "catalog";
	}
*/
	@RequestMapping(value = "/viewProductList/catalogId/{id}/catalogName/{name}", method = RequestMethod.GET)
	public String viewProductListHandler(@PathVariable int id, @PathVariable String name, ModelMap modelMap) {
		System.out.println("id: " + id + ", name: " + name);
		List<ProductPres> products = null;
		try {
			products = BrowseSelectData.INSTANCE
					.getProductList(ManageProductsData.INSTANCE.createCatalogPres(id, name));
		} catch (BackendException e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("products", products);
		modelMap.addAttribute("catalogName", name);
		return "product";
	}

	@RequestMapping("/viewProductDetail")
	public String viewProductDetailHandler(@RequestParam("id") int id, ModelMap modelMap) {
		System.out.println("viewProductsHandler2 - id: " + id);
		ProductPres prodPres = null;
		try {
			prodPres = ManageProductsData.INSTANCE.createProductPresByName(id);
		} catch (BackendException e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("product", prodPres);
		return "productdetail";
	}

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCartHandler(@RequestParam Map<String, String> allRequestParams, ModelMap modelMap) {
		System.out.println("addToCartHandler.....");
		String name = allRequestParams.get("prodName");
		double unitPrice = Double.valueOf(allRequestParams.get("unitPrice"));
		int quanAvailable=Integer.valueOf(allRequestParams.get("quantityAvail"));
		cartPres = BrowseSelectData.INSTANCE.cartItemPresFromData(name, unitPrice, 1);
		/*BrowseSelectData.INSTANCE.addToCart2(cartPres);
		List<CartItemPres> cartItems = BrowseSelectData.INSTANCE.getCartData2();
		modelMap.addAttribute("cartItems", cartItems);*/
		modelMap.addAttribute("quantity",quanAvailable);
		return "changeQuantity";
	}
	
	@RequestMapping(value= "/retriveSavedCart", method = RequestMethod.GET)
	public String retriveSavedCart(ModelMap modelMap){
		List<ProductPres> products = null;
		
			/*BrowseAndSelectController.INSTANCE.retrieveSavedCart();
			BrowseSelectData.INSTANCE.updateCartData();*/
			modelMap.addAttribute("products", DefaultData.PRODUCT_LIST_DATA);
			modelMap.addAttribute("catalogName", "Default product press");
			return "retrivesavedcart";
	}
	@RequestMapping(value = "/addToCart", method = RequestMethod.GET)
	public String editQuantityHandler(@RequestParam("quan") int quan, ModelMap modelMap) {
		modelMap.addAttribute("quantity", quan);
		return "changeQuantity";
	}
	@RequestMapping(value = "/saveQuantity", method = RequestMethod.POST)
	public String saveQuantityHandler(@RequestParam Map<String, String> allRequestParams, ModelMap modelMap) {
		String quantityRequested = (allRequestParams.get("quantity"));
		//if rule pass
		String message="";
		Product product;
		boolean rulesok=true;
		try {
			product = BrowseSelectData.INSTANCE.getProductForProductName(cartPres.getItemName());
			BrowseAndSelectController.INSTANCE.runQuantityRules(product, quantityRequested);
			
		} catch (RuleException e) {
			rulesok=false;
			message=e.getMessage();
		} catch (BackendException e) {
			rulesok=false;
			message=e.getMessage();
		} catch (BusinessException e) {
			rulesok=false;
			message=e.getMessage();
		}
		if (rulesok) {
			BrowseSelectData.INSTANCE.addToCart2(cartPres);
			cartPres.setQuantity(Integer.valueOf(quantityRequested));
			List<CartItemPres> cartItems = BrowseSelectData.INSTANCE.getCartData2();
			modelMap.addAttribute("cartItems", cartItems);
			return "cart";
		}else{
			modelMap.addAttribute("message",message);
			return "changeQuantity";
		}
		
		
	
	}
}

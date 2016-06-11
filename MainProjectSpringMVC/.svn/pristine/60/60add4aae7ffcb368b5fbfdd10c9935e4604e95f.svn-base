package presentation.control;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import business.exceptions.BackendException;
import business.externalinterfaces.Address;
import business.externalinterfaces.CustomerProfile;
import presentation.data.AddressPres;
import presentation.data.CheckoutData;
import presentation.data.DefaultData;
import presentation.gui.GuiConstants;

@Controller
public class CheckoutUIControl {
	
	@RequestMapping(value="/shippingbilling",method=RequestMethod.GET)
	public String proceedFromCartToShipBill(ModelMap modelMap){
		CheckoutData data = CheckoutData.INSTANCE;
		Address defaultShipAddress;
		try {
			defaultShipAddress = data.getDefaultShippingData();
			AddressPres uiShipAddress=new AddressPres();
			AddressPres uiBillAddress=new AddressPres();
			Address defaultBillAddress = data.getDefaultBillingData();
			uiBillAddress.setAddress(defaultBillAddress);
			uiShipAddress.setAddress(defaultShipAddress);
			modelMap.addAttribute("addressFields",GuiConstants.DISPLAY_ADDRESS_FIELDS);
			modelMap.addAttribute("shippingAddress", uiShipAddress);
			modelMap.addAttribute("billingAddress",uiBillAddress);
		} catch (BackendException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "shippingbilling";
	}
	@RequestMapping(value="/selectshipaddress",method=RequestMethod.GET)
	public String selectshipAddress(ModelMap modelMap){
		modelMap.addAttribute("addressList",DefaultData.ADDRESSES_ON_FILE);
		modelMap.addAttribute("title","Shipping Address");
		return "selectaddress";
	}
	@RequestMapping(value="/selectbilladdress",method=RequestMethod.GET)
	public String selectbillAddress(ModelMap modelMap){
		modelMap.addAttribute("addressList",DefaultData.ADDRESSES_ON_FILE);
		modelMap.addAttribute("title","Billing Address");
		return "selectaddress";
	}
	
	@RequestMapping(value="/payment",method=RequestMethod.GET)
	public String proceedToPayment(ModelMap modelMap){
		modelMap.addAttribute("ccard",DefaultData.DEFAULT_PAYMENT_INFO);
		return "payment";
	}
	@RequestMapping(value="/terms",method=RequestMethod.POST)
	public String proceedToTermsAndCondition(@RequestParam Map<String, String> allRequestParams,ModelMap modelMap){
		
		return "redirect:/terms";
	}
	@RequestMapping(value="terms",method=RequestMethod.GET)
	public String proceedToTermsAndConditionget(ModelMap modelMap){
		modelMap.addAttribute("terms",GuiConstants.TERMS_MESSAGE);
		return "termsncondition";
	}
	
}

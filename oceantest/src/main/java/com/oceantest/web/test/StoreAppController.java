package com.oceantest.web.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.reflect.TypeToken;
import com.oceantest.services.jpa.model.PantEntity;
import com.oceantest.utils.RestTempleteGetUtils;

@Controller
@RequestMapping("/store")
public class StoreAppController {
	@Autowired
	private com.oceantest.services.jpa.service.PantJpaService pantService;
	
	
	@RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }
	@RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String contactUsPage(ModelMap model) {
        return "about";
    }	
//	http://localhost:9004/oceantest/web/store/about
	
	
	@RequestMapping(value = {"/tops"}, method = RequestMethod.GET)
	public ModelAndView shirtListPage() throws Exception {
		ModelAndView shirtList = new ModelAndView("shirtList");
		List<Map<String, Object>> shirtTest = new RestTempleteGetUtils() {
			@Override
			public String url() {
				return "http://localhost:9004/oceantest/rest/testProduct/shirt/";
			}
			@Override
			public Map<String, Object> methodUrlVariables() {
				// TODO Auto-generated method stub
				return null;
			}					
		}.getData(new TypeToken<List<Map<String, Object>>>() {
		}.getType());
		shirtList.addObject("shirtTest", shirtTest);

		return shirtList;
	}    
 
	
	@RequestMapping(value={"/shoes"}, method=RequestMethod.GET)
	public ModelAndView shoesListPage() throws Exception {
		ModelAndView shoesList = new ModelAndView("shoesList");
		List<Map<String, Object>> shoesTest = new RestTempleteGetUtils() {
			@Override
			public String url() {
				return "http://localhost:9004/oceantest/rest/testProduct/shoes/";
			}
			@Override
			public Map<String, Object> methodUrlVariables() {
				// TODO Auto-generated method stub
				return null;
			}					
		}.getData(new TypeToken<List<Map<String, Object>>>() {
		}.getType());
		shoesList.addObject("shoesTest", shoesTest);
		return shoesList;
	}
	
	
	// ------- Delete single pant -------
	@RequestMapping(value = "/bottoms/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSinglePant(@PathVariable("id") long id, final RedirectAttributes redirectAttributes) throws Exception {
		ModelAndView pantList = new ModelAndView("redirect:/web/store/bottoms");
		PantEntity pant = pantService.findById(id);
		pantService.deletePantById(id);
		String message = "The Bottom ID: "+pant.getPantId()+" was deleted.";
		redirectAttributes.addFlashAttribute("message", message);
		return pantList;
	}
	
	// ------- create new pant -------
	@RequestMapping(value="/bottoms/create", method=RequestMethod.GET)
	public ModelAndView NewBottom() {
		ModelAndView mav = new ModelAndView("pantCreate");
		return mav;
	}

	@RequestMapping(value = "/bottoms/create", method = RequestMethod.POST)
	public ModelAndView createNewBottom(@ModelAttribute @Validated PantEntity pant, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("pantCreate");

		ModelAndView mav = new ModelAndView();
		String message = "New shop " + pant.getPantId() + " was successfully created.";

		pantService.create(pant);

		mav.setViewName(("redirect:/web/store/bottoms"));
		redirectAttributes.addFlashAttribute("message", message);
		return mav;

	}
	
	// ------- list all pant -------
	@RequestMapping(value = {"/bottoms"}, method = RequestMethod.GET)
	public ModelAndView pantListPage() throws Exception {
		ModelAndView pantList = new ModelAndView("pantList");
		List<PantEntity> pants = pantService.findAll();
		pantList.addObject("pants", pants);
		return pantList;
	}
	
	// -------- find pant by brand -------
	@RequestMapping(value = {"/bottoms/{brand}"}, method = RequestMethod.GET)
	public ModelAndView findPantByBrand(@PathVariable("brand") String brand) {
		ModelAndView pantLisyByBrand = new ModelAndView("pantListByBrand");
		List<PantEntity> pants = pantService.findByBrand(brand);
		pantLisyByBrand.addObject("brand", brand);
		pantLisyByBrand.addObject("pants",pants);		
		return pantLisyByBrand;
	}
	
		
	// ------- edit pant -------
	@RequestMapping(value="/bottoms/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPantPage(@PathVariable("id") long id) throws Exception {
		ModelAndView mav = new ModelAndView("pantEdit");
		PantEntity pant = pantService.findById(id);
		mav.addObject("pants", pant);
		return mav;
	}
	
	@RequestMapping(value="/bottoms/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editPant(@ModelAttribute()  PantEntity pant,
			BindingResult result,
			@PathVariable("id") long id,
			final RedirectAttributes redirectAttributes) throws Exception {
		
		if (result.hasErrors())
			return new ModelAndView("pantEdit");
		
		ModelAndView mav = new ModelAndView("redirect:/web/store/bottoms");
		String message = "Pant was successfully updated.";

		PantEntity currentPant = pantService.findById(id);
		
		currentPant.setPantBrand(pant.getPantBrand());
		currentPant.setPantTest(pant.getPantTest());
		currentPant.setPantPrice(pant.getPantPrice());
		currentPant.setCategoryId(pant.getCategoryId());
		
		pantService.updatePant(pant);
		
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;
	}
		

}

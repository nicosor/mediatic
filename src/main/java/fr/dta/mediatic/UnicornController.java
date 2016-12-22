package fr.dta.mediatic;

import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unicorn")
public class UnicornController {

//	private static DataSingleton dataSingleton = DataSingleton.getInstance();
//	
//	public static DataSingleton getDataSingleton() {
//		return dataSingleton;
//	}
//
//	public static void setDataSingleton(DataSingleton dataSingleton) {
//		UnicornController.dataSingleton = dataSingleton;
//	}
//
	@RequestMapping(method = RequestMethod.GET)
	public void getById() {
		System.out.println("tutu");
		return;
	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	public List<Unicorn> getAll() {
//		return getDataSingleton().getAll();
//	}
//
//	@RequestMapping(method = RequestMethod.PUT)
//	public void create(@RequestBody @Valid Unicorn unicorn, BindingResult bindingResult) {
//		System.out.println(unicorn.getFirstName());
//		if (bindingResult.hasErrors()) {
//			System.out.println(bindingResult.getErrorCount());
//			for (ObjectError obj : bindingResult.getAllErrors()) {
//				System.out.println(obj.getCodes()[0] + " " + obj.getDefaultMessage());
//			}
//		} else
//			getDataSingleton().create(unicorn);
//	}

//	@RequestMapping(method = RequestMethod.POST)
//	public void update(@RequestBody Unicorn unicorn) {
//		getDataSingleton().update(unicorn);
//	}
//
//	@RequestMapping(method = RequestMethod.DELETE)
//	public void delete(@RequestBody Unicorn unicorn) {
//		getDataSingleton().delete(unicorn);
//	}

//	
//	@RequestMapping(value = "/validation", method = RequestMethod.POST)
//	public String validation(@ModelAttribute("unicorn") @Valid Unicorn unicorn, BindingResult bindingResult,Model model) {
//		System.out.println(unicorn.getLastName());
//		if (bindingResult.hasErrors()) {
//			System.out.println(bindingResult.getErrorCount());
//			for (ObjectError obj : bindingResult.getAllErrors()) {
//				System.out.println(obj.getCodes()[0] + " " + obj.getDefaultMessage());
//			}
//		}else
//			System.out.println("else");
//			getDataSingleton().create(unicorn);
//		return "toto";
//	}
}

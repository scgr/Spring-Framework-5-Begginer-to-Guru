package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

	@RequestMapping({ "/vets", "/vets/listVets", "/vets/listVets.html" })
	public String listVets() {
		return "vets/index";
	}

}

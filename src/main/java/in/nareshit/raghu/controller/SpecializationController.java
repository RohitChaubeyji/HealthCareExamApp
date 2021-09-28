package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nareshit.raghu.entity.Specialization;
import in.nareshit.raghu.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {
	
	@Autowired
	private ISpecializationService service;
	
	/**
	 * 1.Display all Specialization
	 */
	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Specialization> list = service.getAllSpecialization();
		model.addAttribute("list",list);		
		return "SpecializationData";
	}

}

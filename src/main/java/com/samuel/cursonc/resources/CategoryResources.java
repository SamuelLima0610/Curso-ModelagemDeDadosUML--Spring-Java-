package com.samuel.cursonc.resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/category")
public class CategoryResources {
	
	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "Rest está funcionando";
	}
}

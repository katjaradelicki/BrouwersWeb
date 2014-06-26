package be.vdab.web;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView toonIndex(){
		ModelAndView modelAndView=new ModelAndView("index");
		int tijd=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		final String  GROET_KEY="groet";
		if(tijd>0 && tijd <=5){
			modelAndView.addObject(GROET_KEY, "goedeNacht");
		}else if(tijd>6 && tijd<=11){
			modelAndView.addObject(GROET_KEY, "goedeMorgen");
		}else if(tijd>12 && tijd<17){
			modelAndView.addObject(GROET_KEY, "goedeMiddag");
		}else{
			modelAndView.addObject(GROET_KEY, "goedeAvond");
		}
		return modelAndView;
	}
}

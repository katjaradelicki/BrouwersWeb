package be.vdab.web;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
public class BrouwerController {
	
	
	 private BrouwerService brouwerService;
	 @Autowired
	 public BrouwerController(BrouwerService brouwerService){
		 this.brouwerService=brouwerService;
	 }
	 
	 @RequestMapping
	 public ModelAndView brouwers(){
		 ModelAndView modelAndView=new ModelAndView("brouwers/brouwers", "brouwers", brouwerService.findAll());
		 modelAndView.addObject("brouwersMaxOmzet",brouwerService.findBrouwerMetHoogsteOmzet());
		 return modelAndView;
	 }
	
	 
	 
	 @RequestMapping(value="opnaam" ,method=RequestMethod.GET)
		public ModelAndView findOpNaamForm(){
			ModelAndView modelAndView=new ModelAndView("brouwers/opnaam", "brouwersOpNaamForm", new BrouwersOpNaamForm());//form laten zien
			return modelAndView;
		}
	
	@RequestMapping(value="opnaam" ,method=RequestMethod.GET,params={"beginNaam"})
	public ModelAndView findOpNaam(@Valid BrouwersOpNaamForm brouwersOpNaamForm,BindingResult bindingResult){
		ModelAndView modelAndView=new ModelAndView("brouwers/opnaam");
		if(!bindingResult.hasErrors()){
			List<Brouwer> gevondenBrouwers=(List<Brouwer>) brouwerService.findByNaam(brouwersOpNaamForm.getBeginNaam());
			modelAndView.addObject("gevondenBrouwers", gevondenBrouwers);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="toevoegen",method=RequestMethod.GET)
	public ModelAndView toevoegenForm(){
		return new ModelAndView("brouwers/toevoegen","brouwer",new Brouwer());
	}
	
	@RequestMapping(value="toevoegen",method=RequestMethod.POST)
	public String toevoegenBrouwer(@Valid Brouwer brouwer,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "brouwers/toevoegen";
		}
		brouwerService.create(brouwer);
		return "redirect:/"   ;
	}
	
	
	@RequestMapping(value="opalfabet",method=RequestMethod.GET)
	public ModelAndView findOpAlfabet(){
		Character[] alfabet=new Character['Z'-'A'+1];
		for(int i=0;i<'Z'-'A'+1;i++){
			alfabet[i]=Character.valueOf((char)('A'+i));
		}
		
		return new ModelAndView("brouwers/opalfabet","alfabet",alfabet);
	}
	
	@RequestMapping(value="opalfabet",method=RequestMethod.GET,params="gekozenLetter")
	public ModelAndView toonBrouwersOpAlfabet(@RequestParam Character gekozenLetter){
		Character[] alfabet=new Character['Z'-'A'+1];
		for(int i=0;i<'Z'-'A'+1;i++){
			alfabet[i]=Character.valueOf((char)('A'+i));
		}
		List<Brouwer> gevondenBrouwers=(List<Brouwer>)brouwerService.findByNaam(gekozenLetter.toString());
		ModelAndView answer=new ModelAndView("brouwers/opalfabet","alfabet",alfabet);
		answer.addObject("gevondenBrouwers", gevondenBrouwers);
		
		return answer;
	}
	
	@InitBinder("brouwer")
	public void initBinderBrouwer(DataBinder dataBinder){
		Brouwer brouwer=(Brouwer)dataBinder.getTarget();
		if(brouwer.getAdres()==null){
			brouwer.setAdres(new AdresForm());
		}else{
			brouwer.setAdres(new AdresForm(brouwer.getAdres()));
		}
	}
	
	
	
}

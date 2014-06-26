package be.vdab.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

class BrouwersOpNaamForm {
	
	@NotNull
	@Size(min=1,max=50,message="{Size.tekst}")
	private String beginNaam;

	public BrouwersOpNaamForm() {
		// voor Spring
	}

	public String getBeginNaam() {
		return beginNaam;
	}

	public void setBeginNaam(String beginNaam) {
		if(beginNaam.equals("")){
			beginNaam=null;
		}
		this.beginNaam = beginNaam.trim();
	}
	
	
}

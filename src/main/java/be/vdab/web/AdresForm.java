package be.vdab.web;

import be.vdab.valueobjects.Adres;

class AdresForm extends Adres{
	
	@Override
	public void setStraat(String straat){
		super.setStraat(straat);
	}
	@Override
	public void setHuisNr(String huisNr){
		super.setHuisNr(huisNr);
	}
	@Override
	public void setPostcode(Integer postcode){
		super.setPostcode(postcode);
	}
	
	@Override
	public void setGemeente(String gemeente){
		super.setGemeente(gemeente);
	}
	
	AdresForm(){
		
	}
	
	AdresForm(Adres adres){
		setStraat(adres.getStraat());
		setHuisNr(adres.getHuisNr());
		setPostcode(adres.getPostcode());
		setGemeente(adres.getGemeente());
	}

}

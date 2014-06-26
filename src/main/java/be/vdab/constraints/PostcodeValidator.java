package be.vdab.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostcodeValidator implements ConstraintValidator<Postcode, Integer> {

	private static final Integer MIN_POSTCODE=1000;
	private static final Integer MAX_POSTCODE=9999;
	@Override
	public void initialize(Postcode arg0) {
	}

	@Override
	public boolean isValid(Integer postcode, ConstraintValidatorContext arg1) {
		if(postcode==null){
			return true;
		}
		return postcode>=MIN_POSTCODE && postcode<=MAX_POSTCODE;
	}
	
	

}

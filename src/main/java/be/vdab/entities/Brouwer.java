package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name="brouwers")
public class Brouwer implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue
	private long brouwerNr;
	@NotNull
	@Size(min=1,max=50,message="{Size.tekst}")
	private String naam;
	@Min(value=0,message="{Min.nul}")
	@NotNull
	private Integer omzet;
	@Embedded
	@Valid
	private Adres adres;
	
	
	
	
	
	
	public long getBrouwerNr() {
		return brouwerNr;
	}
	public String getNaam() {
		return naam;
	}
	public Integer getOmzet() {
		return omzet;
	}
	public Adres getAdres() {
		return adres;
	}
	public void setBrouwerNr(long brouwerNr) {
		this.brouwerNr = brouwerNr;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	public Brouwer(){ //nodig in andere package ok?
		//nodig om van Brouwer een form te maken
	}
	
	public Brouwer(String naam, Integer omzet, Adres adres) {
		
		this.naam = naam;
		this.omzet = omzet;
		this.adres = adres;
	}
	public Brouwer(long brouwerNr, String naam, Integer omzet, Adres adres) {
		
		this(naam,omzet,adres);
		this.brouwerNr = brouwerNr;
		
	}
	
	@Override
	public String toString() {
		
		return naam+ "("+brouwerNr+")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brouwer other = (Brouwer) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	
	
	

}

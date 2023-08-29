package dersler.pojos.gmi_bank;

import java.util.List;
import java.io.Serializable;

public class CountryPojo implements Serializable {
	private String name;
	private List<StatesPojo> states;

	public CountryPojo() {

	}

	public CountryPojo(String name, List<StatesPojo> states) {
		this.name = name;
		this.states = states;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setStates(List<StatesPojo> states){
		this.states = states;
	}

	public List<StatesPojo> getStates(){
		return states;
	}

	@Override
 	public String toString(){
		return 
			"CountryPojo{" + 
			"name = '" + name + '\'' + 
			",states = '" + states + '\'' + 
			"}";
		}
}
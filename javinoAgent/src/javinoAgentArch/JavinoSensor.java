package javinoAgentArch;

import java.util.Collection;

import jason.asSyntax.Atom;
import jason.asSyntax.Literal;

public abstract class JavinoSensor {

	protected Atom id;
	
	
	
	public JavinoSensor(Atom id) {
		super();
		this.id = id;
	}


	/* Returns a collection of percepts from the sensor */
	public abstract Collection<Literal> getPercepts();
	

	public Atom getId() {
		return id;
	}

	public void setId(Atom id) {
		this.id = id;
	}
	
	
	
}

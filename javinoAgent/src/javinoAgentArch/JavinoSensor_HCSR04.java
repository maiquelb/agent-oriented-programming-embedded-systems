package javinoAgentArch;

import java.util.Collection;

import br.pro.turing.javino.Javino;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;

public class JavinoSensor_HCSR04 extends JavinoSensor {

	private Javino j = new Javino();
	private String port = "COM3";
	
	public JavinoSensor_HCSR04(Atom id) {
		super(id);
	}

	@Override
	public Collection<Literal> getPercepts() {
		
		if (j.sendCommand(port,"forward")) {
			//j.listenArduino(port);
			System.out.println("going forward!!");
		}
		
		return null;
	}

}

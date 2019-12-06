package javinoAgentArch;

import jason.asSyntax.Atom;

public class JavinoAgentCar extends JavinoAgent {

	@Override
	protected void setupSensors() {
		this.sensors.add(new JavinoSensor_HCSR04(new Atom("frontalDistance")));

	}

}

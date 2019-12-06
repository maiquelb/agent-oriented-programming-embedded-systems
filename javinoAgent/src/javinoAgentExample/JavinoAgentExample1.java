package javinoAgentExample;

import javinoAgentArch.JavinoAgent;
import static jason.asSyntax.ASSyntax.createAtom;

public class JavinoAgentExample1 extends JavinoAgent {
	
	
	@Override
	public void initAg() {		
    	super.initAg();		    	
	}

	@Override
	public void setupSensors() {
		this.sensors.add(new ExampleSensor1(createAtom("sensor1")));
		this.sensors.add(new ExampleSensor1(createAtom("sensor2")));		
	}
	
	
	

}



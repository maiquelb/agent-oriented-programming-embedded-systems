// javac -cp ~/git/jacamo/build/libs/jason-2.4.jar -d ../bin/ javinoAgentArch/*.java && jar cfv javinoAgentArch.jar -C ../bin . && javac -cp javinoAgentArch.jar:/home/maiquel/git/jacamo/build/libs/jason-2.4.jar -d ../bin/ javinoAgentExample/*.java && jar cfv ../bin/javinoAgentArch.jar -C ../bin/ . && rm javinoAgentArch.jar && cp ../bin/javinoAgentArch.jar /home/maiquel/temp/javinoArch/javinoArchTeste/bin/

package javinoAgentArch;

import java.util.Collection;

import jason.RevisionFailedException;
import jason.architecture.AgArch;
import jason.asSemantics.Event;
import jason.asSemantics.Intention;
import jason.asSyntax.Literal;
import jason.asSyntax.Trigger;
import jason.asSyntax.Trigger.TEOperator;
import jason.asSyntax.Trigger.TEType;


public class JavinoAgentArch extends AgArch{

	protected Collection<JavinoSensor> sensors = null;


	public JavinoAgentArch() {		
		super();

	}

	@Override
	public Collection<Literal> perceive() {
		if(this.sensors!=null)
			updateSensor();

		return super.perceive();

	}


	public void setSensors(Collection<JavinoSensor> sensors) {
		this.sensors = sensors;
	}


	public Collection<JavinoSensor> getSensors(){
		return this.sensors;

	}

	private final void updateSensor() {
		for(JavinoSensor s:this.sensors) { //for each sensor			
			Collection<Literal> percepts = s.getPercepts(); //get all the percepts from the current sensor
			if(percepts!=null) {
				for(Literal l:percepts) { //for each percept..
					try {					
						((JavinoAgent)getTS().getAg()).abolishByFunctorAndSource(l, getTS().getAg()); //remove the corresponding current belief
						if(getTS().getAg().addBel(l)) {
							Trigger te = new Trigger(TEOperator.add, TEType.belief, l.copy());
							getTS().updateEvents(new Event(te, Intention.EmptyInt));
						}

					} catch (RevisionFailedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}

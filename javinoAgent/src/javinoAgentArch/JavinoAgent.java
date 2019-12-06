/* Agents having perceptions from sensors must extend this class */

/*package javinoAgentArch;

import java.util.ArrayList;
import java.util.List;

import jason.asSemantics.Agent;

public abstract class JavinoAgent extends Agent{

	private List<ISensor> sensors = new ArrayList<ISensor>();

	public void addSensor(ISensor sensor) {
		sensors.add(sensor);
	}

	public void removeSensor(ISensor sensor) {
		sensors.remove(sensor);
	}
 */


package javinoAgentArch;

import java.util.ArrayList;
import java.util.List;

import jason.asSemantics.Agent;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;

public abstract class JavinoAgent extends Agent {

	protected final List<JavinoSensor> sensors = new ArrayList<JavinoSensor>();
	
	
	@Override
	public void initAg() {
		setupSensors();
   	    super.initAg();
   	    //TODO: find a better way to set the JavinoAgentArch to the JavinoAgent. It is needed to check when/where the agent architecture is set. 
		checkSensor c = new checkSensor();
		c.start();

	}


	/* remove a belief according to the functor and source of the parameter*/
	protected void abolishByFunctorAndSource(Literal bel, Agent ag) {
		bel = (Literal) bel.clone();
		bel.makeTermsAnnon(); //change all the terms anonimous variables ("_")
		Literal belFound = ag.findBel(bel, new Unifier()); //find the belief by the functor
	    if(belFound!=null) {
	       belFound = (Literal) belFound.clone(); //clone to 
	       belFound.delSources(); //del all the sources (the same belief may be many sources) to add the only interesting source (below)
	       belFound.addSource(bel.getSources().get(0));
		   ag.getBB().remove(belFound);
	    }
	}
	
	protected abstract void setupSensors();
	
	public void addSensor(JavinoSensor sensor) {
		sensors.add(sensor);
	}

	public void removeSensor(JavinoSensor sensor) {
		sensors.remove(sensor);
	}


	class checkSensor extends Thread{

		@Override
		public void run() {
			while(true) {
				synchronized (ts) {
					if(getTS().getUserAgArch() instanceof JavinoAgentArch)
						/* The architecture requres a list of sensors to handle the perceptions. 
						   In some point after the agent creation, an architecture other than JavinoAgentArch is set and the list of sensor is lost.
						   This method update the list of sensors if it is null.
						   TODO: improve this */ 
						if(((JavinoAgentArch) getTS().getUserAgArch()).getSensors()==null) {
							((JavinoAgentArch) getTS().getUserAgArch()).setSensors(sensors);
						}

				}
			}

		}
	}
}




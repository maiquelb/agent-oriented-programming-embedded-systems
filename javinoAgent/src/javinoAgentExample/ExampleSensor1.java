/**
 * This is an example of implementation of a JavinoAgent. It must be of JavinoAgentArch architecture.
 * The method getPercepts simulates the reading of sensors. The "collected" data are current date and time. 
 * To simulate a non deterministic environment, the sensor may randomly collect null data (simulating no new perceptions) 
 */

package javinoAgentExample;

import static jason.asSyntax.ASSyntax.parseLiteral;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.parser.ParseException;
import javinoAgentArch.JavinoSensor;

public class ExampleSensor1 extends JavinoSensor {

	private Random r = new Random();
	private Date currentTime = Calendar.getInstance().getTime();



	public ExampleSensor1(Atom id) {
		super(id);
	}

	@Override
	public Collection<Literal> getPercepts() {		
		if(r.nextBoolean()==true) { //a random update of the collected data
			currentTime = Calendar.getInstance().getTime();
		}
		try {
			Literal l1 = parseLiteral("currentDate("+  new SimpleDateFormat("ddMMyyyy").format(currentTime) +")");
			Literal l2 = parseLiteral("currentTime("+  new SimpleDateFormat("HHmmss").format(currentTime) +")");

			l1.addSource(this.getId());
			l2.addSource(this.getId());


			ArrayList<Literal> l = new ArrayList<Literal>();
			l.add(l1);
			l.add(l2);
			return l;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}

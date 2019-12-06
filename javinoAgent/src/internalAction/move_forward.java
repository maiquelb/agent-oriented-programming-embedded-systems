package internalAction;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

public class move_forward extends DefaultInternalAction {

	@Override
	public Object execute( TransitionSystem ts, Unifier un, Term[] args ) throws Exception {
		System.out.println("executing move_forward...");
		return true;
	}

}

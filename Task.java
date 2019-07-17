package scripts;
import org.powerbot.script.ClientAccessor;
import org.powerbot.script.ClientContext;

public abstract class Task<C extends ClientContext> extends ClientAccessor<C> {

	
	
	
	
	
public abstract String status();
public String userChoice;










public Task(C ctx) {
	super(ctx);
	
}
	
	public abstract boolean activate();
	
	
	
	
	
	
	public abstract void execute() ;
	
	
	
}
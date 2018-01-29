import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;

public class MyJobListener implements TriggerListener {
	
	public String getName() {
		return "MyJobListener";
	}
	@Override
	public void triggerComplete(Trigger arg0, JobExecutionContext arg1, CompletedExecutionInstruction arg2) {
		System.out.println("Job was exected: " + arg1.getFireInstanceId() + ", job listener: " + getName());
		
	}
	@Override
	public void triggerFired(Trigger arg0, JobExecutionContext arg1) {
		System.out.println("Job to be exected: " + arg1.getFireInstanceId() + ", job listener: " + getName());
		
	}
	@Override
	public void triggerMisfired(Trigger arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean vetoJobExecution(Trigger arg0, JobExecutionContext arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}

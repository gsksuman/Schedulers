import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.ims.console.model.NotificationModel;

public class Scheduler implements Job{
	private static final Logger logger=Logger.getLogger(Scheduler.class);
	@Override
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try{
			//Do your work here
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

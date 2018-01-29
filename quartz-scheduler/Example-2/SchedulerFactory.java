import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerFactory 
{
	private static final Logger logger=Logger.getLogger(SchedulerFactory.class);
	private static SchedulerFactory schedulerFactory;

	private SchedulerFactory sf;
	private Scheduler scheduler;
	private JobDetail job;
	private CronTrigger trigger;
	private String hour="1";
	private String minute="4";
	
	private SchedulerFactory(){
	}

	public static SchedulerFactory getInstance(){	
		if (schedulerFactory == null)
			schedulerFactory = new SchedulerFactory();
		return schedulerFactory;
	}
	
	public void startScheduler(){
		try{
			//Fire at noon
			//String schedulerExpression="0/5 * * * * ?";
			String schedulerExpression="0 0 0 * * ?";
			//String schedulerExpression="0 "+minute+" 0/"+hour+" * * ?";
			//String schedulerExpression="0 1 0 * * ?";
			this.sf = new StdSchedulerFactory();
			this.scheduler = sf.getScheduler();
			this.job= newJob(Scheduler.class)
			.withIdentity("job1", "group1")
			.build();
			
			this.trigger = newTrigger()
		    .withIdentity("trigger1", "group1")
		    .withSchedule(CronScheduleBuilder.cronSchedule(schedulerExpression))
		    .build();
			
			this.scheduler.scheduleJob(job, trigger);
			this.scheduler.start();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void stopScheduler(){
		try {
			this.scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public boolean getIcbrSchedularInfo(){
		boolean flag = false;
		try{
		  	if(this.scheduler.isShutdown()){
			  flag=true;	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
    public String getSchedulerTime(){
    	return this.hour+":"+this.minute;
    }
	
    public void setSchedulerTime(String hour,String minute){
    	this.hour=hour;
    	this.minute=minute;
    }
    
	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}	
}

import java.util.Timer;
public class Factory
{
	private static Factory schedulerFactory;
	private transient Timer timer;
	private long timeInSecond=20l; //scheduler intervel 
	private Factory(){}
	
	public static Factory getInstance(){	
		if (schedulerFactory == null)
			schedulerFactory = new Factory();
		return schedulerFactory;
	}

	public void startScheduler(){
		try{
			this.timer.schedule(new SchedulerTask(), 0, timeInSecond*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void stopScheduler(){
		try{
			this.timer.cancel();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean getSchedularInfo(){
		boolean schedularFlag = true;
		try {
			if(this.timer==null){
				schedularFlag = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return schedularFlag;
	}
}

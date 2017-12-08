package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.impl.calendar.WeeklyCalendar;

import java.util.Date;


public  class MyJob implements Job {

	
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    	System.out.println("times = " + new Date());
        
        
    }
}
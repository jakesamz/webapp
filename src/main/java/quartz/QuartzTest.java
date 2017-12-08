package quartz;

import org.quartz.*;
import org.quartz.core.jmx.JobDataMapSupport;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest{

    public static void main(String[] args) {
        //创建一个SchedulerFactory对象
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;

        try {
            //通过SchedulerFactory对象获取任务调度器
            scheduler = schedulerFactory.getScheduler();
            //创建一个job
            JobDetail job = JobBuilder.newJob(MyJob.class)
                                 .withIdentity("job1", "group1")
                                 .build();
            JobDataMap dataMap = new JobDataMap();
            dataMap.put("smtp_host", "smtp.163.com");
            dataMap.put("recipient", "");
            dataMap.put("sender", "");
            dataMap.put("subject", "");
            dataMap.put("message", "");
            //定义触发器，也就是执行job的规则
            Trigger trigger=TriggerBuilder.newTrigger()
                    .withSchedule(CronScheduleBuilder.cronSchedule("1/1 * * * * ?"))
                    .build();
            //把job和触发器注册到调度器中
            scheduler.scheduleJob(job,trigger);
            //启动调度器
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    	
    	/*WeeklyCalendar wc = new WeeklyCalendar();
        
        System.out.println(wc.isDayExcluded(1));;*/

    }
}
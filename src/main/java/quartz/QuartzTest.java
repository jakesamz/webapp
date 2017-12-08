package quartz;

import org.quartz.*;
import org.quartz.core.jmx.JobDataMapSupport;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest{

    public static void main(String[] args) {
        //����һ��SchedulerFactory����
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;

        try {
            //ͨ��SchedulerFactory�����ȡ���������
            scheduler = schedulerFactory.getScheduler();
            //����һ��job
            JobDetail job = JobBuilder.newJob(MyJob.class)
                                 .withIdentity("job1", "group1")
                                 .build();
            JobDataMap dataMap = new JobDataMap();
            dataMap.put("smtp_host", "smtp.163.com");
            dataMap.put("recipient", "");
            dataMap.put("sender", "");
            dataMap.put("subject", "");
            dataMap.put("message", "");
            //���崥������Ҳ����ִ��job�Ĺ���
            Trigger trigger=TriggerBuilder.newTrigger()
                    .withSchedule(CronScheduleBuilder.cronSchedule("1/1 * * * * ?"))
                    .build();
            //��job�ʹ�����ע�ᵽ��������
            scheduler.scheduleJob(job,trigger);
            //����������
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    	
    	/*WeeklyCalendar wc = new WeeklyCalendar();
        
        System.out.println(wc.isDayExcluded(1));;*/

    }
}
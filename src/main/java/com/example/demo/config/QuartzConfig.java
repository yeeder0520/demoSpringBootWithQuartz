package com.example.demo.config;

import com.example.demo.JobTest;
import com.example.demo.JobTest2;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail crlDownloadDailyJob(){
        JobDetail jobDetail = JobBuilder.newJob(JobTest.class)
                .withIdentity("crlDownloadDailyJob_NAME", "crlDownloadDailyJob_GROUP")
                .usingJobData("no1","a")
                .usingJobData("no2","b")
                .usingJobData("no3","c")
                .usingJobData("no4","d")
                .storeDurably()
                .build();
        return jobDetail;
    }

    @Bean
    public Trigger crlDownloadDailyTrigger() {
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(crlDownloadDailyJob())
                .withIdentity("crlDownloadDailyTrigger_NAME", "crlDownloadDailyTrigger_GROUP")
//                .startNow()
                // 每天0點執行
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();
        return trigger;
    }

    @Bean
    public JobDetail abcJob(){
        JobDetail jobDetail = JobBuilder.newJob(JobTest2.class)
                .withIdentity("abcJob_NAME", "abcJob_GROUP")
                .storeDurably()
                .build();
        return jobDetail;
    }

    @Bean
    public Trigger abcTrigger() {
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(abcJob())
                .withIdentity("abcTrigger_NAME", "abcTrigger_GROUP")
                .startNow()
                // 每天0點執行
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();
        return trigger;
    }
}

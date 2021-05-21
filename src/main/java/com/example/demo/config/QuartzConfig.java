package com.example.demo.config;

import com.example.demo.JobTest;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail crlDownloadDailyJob(){
        JobDetail jobDetail = JobBuilder.newJob(JobTest.class)
                .withIdentity("crlDownloadDailyJob_NAME", "crlDownloadDailyJob_GROUP")
                .storeDurably()
                .build();
        return jobDetail;
    }

    @Bean
    public Trigger trigger() {
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(crlDownloadDailyJob())
                .withIdentity("trigger_NAME", "trigger_GROUP")
                .startNow()
                // 每天0點執行
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();
        return trigger;
    }
}

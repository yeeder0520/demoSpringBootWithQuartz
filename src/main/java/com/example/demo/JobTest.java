package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class JobTest extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        Set<String> jobDataMapSet = jobDataMap.keySet();
        for (String job : jobDataMapSet) {
            System.out.println("job = " + job);
        }

        File file = new File("C:\\Users\\yeeder\\Desktop\\我是排程安安.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,true);
            fw.write("排成成功寫出來啦 現在時間 : " + new Date() + "\r");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

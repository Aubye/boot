package com.app.index.scheduled;

import com.app.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@EnableScheduling
public class IndexScheduled {

    @Autowired
    private IndexService indexService;

    @Scheduled(cron = "0/5 * * * * ? ")
    public void execute() {
        indexService.aaa();
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().length());
    }

}

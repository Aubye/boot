package com.app.index.scheduled;

import com.app.index.service.IndexService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@EnableScheduling
public class IndexScheduled {

    @Autowired
    private IndexService indexService;

    @Scheduled(cron = "0/5 * * * * ? ")
    public void execute() {
        //indexService.aaa();
    }

    public static void main(String[] args) {
        List<String> objects = Lists.newArrayList();
        objects.add("1");

        Map<Integer, List<String>> hashMap = Maps.newHashMap();
        hashMap.put(1, objects);
        hashMap.put(2, objects);
        hashMap.put(3, objects);
        hashMap.put(4, objects);
        Optional<String> first;
        if (hashMap.get(5) == null) {
            first = Optional.empty();
        } else {
            first = hashMap.get(5).stream().findFirst();
        }
        if (first.isPresent()) {
            System.out.println("asaa");
        }
    }

}

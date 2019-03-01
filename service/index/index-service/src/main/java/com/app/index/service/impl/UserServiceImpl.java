package com.app.index.service.impl;

import com.app.index.service.IndexService;
import com.app.index.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IndexService indexService;

    @PostConstruct
    public void execute() {
        indexService.aaa();
    }

    @Override
    public void init() {

    }
}

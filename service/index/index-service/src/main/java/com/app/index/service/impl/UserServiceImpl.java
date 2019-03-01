package com.app.index.service.impl;

import com.app.index.service.IndexService;
import com.app.index.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

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

package com.app.index.service.impl;

import com.app.index.dao.UserRepository;
import com.app.index.domain.po.User;
import com.app.index.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Slf4j
@Service("indexService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String getIndex() {
        log.info("IndexServiceImpl getIndex...");
        return "";
    }

    @Transactional(readOnly = true)
    public void aaa() {
        try (Stream<User> allByIsDelIsNotNull = userRepository.findAllByIsDelIsNotNull()) {
            allByIsDelIsNotNull.forEach(it -> {
                log.info("################## user:{}", it);
            });
        }
    }


}

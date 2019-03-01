package com.app.index.service.impl;

import com.app.index.dao.UserRepository;
import com.app.index.domain.po.User;
import com.app.index.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service("indexService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class IndexServiceImpl implements IndexService {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public String getIndex() {
        LOGGER.info("IndexServiceImpl getIndex...");
        return "";
    }

    @Transactional(readOnly = true)
    public void aaa() {
        try (Stream<User> allByIsDelIsNotNull = userRepository.findAllByIsDelIsNotNull()) {
            allByIsDelIsNotNull.forEach(it -> {
                LOGGER.info("################## user:{}", it);
            });
        }
    }


}

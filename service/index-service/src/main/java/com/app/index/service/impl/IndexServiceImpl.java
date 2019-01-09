package com.app.index.service.impl;

import com.app.index.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("indexService")
public class IndexServiceImpl implements IndexService {

    @Override
    public String getIndex() {
        log.info("IndexServiceImpl getIndex...");
        return "";
    }

}

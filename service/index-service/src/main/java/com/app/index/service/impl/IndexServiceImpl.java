package com.app.index.service.impl;

import com.app.index.service.IndexService;
import org.springframework.stereotype.Service;

@Service("indexService")
public class IndexServiceImpl implements IndexService {


    @Override
    public String getIndex() {
        return "";
    }

}

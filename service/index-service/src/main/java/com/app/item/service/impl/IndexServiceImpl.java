package com.app.item.service.impl;

import com.app.item.service.IndexService;
import org.springframework.stereotype.Service;

@Service("indexService")
public class IndexServiceImpl implements IndexService {


    @Override
    public String getIndex() {
        return "";
    }

}

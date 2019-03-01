package com.app.index.utils;

import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeanMapper extends ConfigurableMapper {

    @Override
    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return super.mapAsList(source, destinationClass);
    }
}

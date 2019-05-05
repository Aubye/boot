package com.app.platform.common.function;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public final class Nullable {

    private Nullable() {
    }

    public static <T> Optional<T> of(T value) {
        return value instanceof Collection
                ? CollectionUtils.isEmpty((Collection) value) ? Optional.empty() : Optional.of(value)
                : Optional.ofNullable(value);
    }

    public static <T> Stream<T> stream(Collection<T> collection) {
        return collection == null ? Stream.empty() : collection.stream();
    }
}

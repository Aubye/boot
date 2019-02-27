package org.orgin.annotations.bean;

import com.app.smart.origins.emnu.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
    String value();

    RequestMethod method() default RequestMethod.GET;
}
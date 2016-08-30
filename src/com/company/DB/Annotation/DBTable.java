package com.company.DB.Annotation;
import java.lang.annotation.*;
/**
 * Created by tianhang on 30/8/2016.
 */
@Target(ElementType.TYPE) // 应用于类、接口、enum、注解类型
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}

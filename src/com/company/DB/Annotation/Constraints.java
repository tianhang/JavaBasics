package com.company.DB.Annotation;
import java.lang.annotation.*;
/**
 * Created by tianhang on 30/8/2016.
 */
@Target(ElementType.FIELD) //用于变量名
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    boolean primaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;
}

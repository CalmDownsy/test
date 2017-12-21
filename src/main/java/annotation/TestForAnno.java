package annotation;

import java.lang.annotation.*;

/**
 * @author zhangsy
 * @date 2017/11/28
 */
@Documented
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestForAnno {

    String type();
    int id() default 0;
}

package annotation;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author zhangsy
 * @date 2017/11/28
 */
public class ParseAnno {

    private Logger logger = LoggerFactory.getLogger(ParseAnno.class);

    @Test
    public void parse() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("annotation.AnnotationTest");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            TestForAnno test = (TestForAnno) annotation;
            logger.info("{} : {}", String.valueOf(test.id()), test.type());
        }
    }

    @Test(description = "annotation for method")
    public void test1() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("annotation.AnnotationTest");
        Method run = clazz.getDeclaredMethod("run");
        boolean b = run.isAnnotationPresent(TestForAnno.class);
        if (b) {
            TestForAnno annotation = run.getAnnotation(TestForAnno.class);
            logger.info("{} :{}", annotation.id(), annotation.type());
        }
    }

    @Test
    public String a() {
        return "12";
    }

    @Test
    public void forNull() {
        String s = null;
        String b = "2";
        clearBucket(s, b);
    }

    private void clearBucket(String... bucketName) {
        for (String s : bucketName) {
            System.out.println(StringUtils.isEmpty(s));
        }
    }
}

package annotation;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

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

    @Test(description = "使用Spring扫描注解原理扫描自定义注解")
    public void annoScan() throws ClassNotFoundException {
        //是否使用默认过滤器
        //只能扫描到自定义注解的类
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(TestForAnno.class));
        Set<BeanDefinition> annotation = provider.findCandidateComponents("annotation");
        for (BeanDefinition bean : annotation) {
            System.out.println(bean.getBeanClassName());
            //反射
            Class<?> testClass = Class.forName(bean.getBeanClassName());
            Method[] declaredMethods = testClass.getDeclaredMethods();
            for (Method m : declaredMethods) {
                boolean b = m.isAnnotationPresent(Test.class);
                if (b) {
                    Test mAnnotation = m.getAnnotation(Test.class);
                    System.out.println(mAnnotation.description());
                }
            }
        }
    }
}

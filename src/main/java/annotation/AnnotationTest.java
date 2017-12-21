package annotation;

import java.lang.annotation.Annotation;

/**
 * @author zhangsy
 * @date 2017/11/28
 */
@TestForAnno(type = "class")
public class AnnotationTest {

    @TestForAnno(type = "field", id = 1)
    private String sch;

    @TestForAnno(type = "field", id = 2)
    private String cls;

    @TestForAnno(type = "constructor", id = 3)
    public AnnotationTest() {
    }

    @TestForAnno(type = "method", id = 4)
    public void run() {
        System.out.println("someone running!!");
    }
}

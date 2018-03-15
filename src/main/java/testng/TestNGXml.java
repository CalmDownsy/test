package testng;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class TestNGXml {

    @Test(description = "java代码实现动态生成testNG的xml文件")
    public void test() {
        TestNG testNG = new TestNG();
        //依据xml文件的标签逐级设置参数
        //suite
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("测试xml文件");
        //设置并行级别和数量
        xmlSuite.setParallel(XmlSuite.ParallelMode.METHODS);
        xmlSuite.setThreadCount(2);

        //test
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName("testNgXml-youLike");

        //classes
        XmlClass xmlClass = new XmlClass("testng.Test123");

        //method include
        XmlInclude xmlInclude = new XmlInclude("test1");
        XmlInclude xmlInclude2 = new XmlInclude("test2");
        XmlInclude xmlInclude3 = new XmlInclude("test3");

        List<XmlInclude> xmlIncludeList = new ArrayList<XmlInclude>();
        xmlIncludeList.add(xmlInclude);
        xmlIncludeList.add(xmlInclude2);
        xmlIncludeList.add(xmlInclude3);
        xmlClass.setIncludedMethods(xmlIncludeList);
        List<XmlClass> xmlClassList = new ArrayList<XmlClass>();
        xmlClassList.add(xmlClass);
        xmlTest.setXmlClasses(xmlClassList);
        List<XmlTest> xmlTestList = new ArrayList<XmlTest>();
        xmlTestList.add(xmlTest);
        xmlSuite.setTests(xmlTestList);
        List<XmlSuite> xmlSuiteList = new ArrayList<XmlSuite>();
        xmlSuiteList.add(xmlSuite);
        testNG.setXmlSuites(xmlSuiteList);
        testNG.run();
    }
}

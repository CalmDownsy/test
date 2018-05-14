package compare;

import org.testng.annotations.Test;

import java.io.*;

/**
 * Created by zhangsy on 2018/4/9.
 */
public class SearchKeywords {

    public void searchKeyword(File file, String keyword) throws IOException {
        //行读取
        LineNumberReader lineReader = null;
        try {
            FileReader fileReader = new FileReader("D:" + File.separator + "content.txt");
            lineReader = new LineNumberReader(fileReader);
            String readLine;
            while ((readLine = lineReader.readLine()) != null) {
                //每行出现的位置
                int index = 0;
                //下次开始匹配的位置
                int next = 0;
                //每行出现的次数
                int times = 0;
                //判断每行出现的次数
                while ((index = readLine.indexOf(keyword, next)) != -1) {
                    next = index + keyword.length();
                    times++;
                }
                if (times > 0) {
                    System.out.println("第" + lineReader.getLineNumber() + "行" + "出现 " + keyword + " 次数: " + times);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (lineReader != null) {
                lineReader.close();
            }
        }
    }

   @Test
    public void as() throws IOException {
       searchKeyword(new File("D:/content.txt"), "4");
   }
}

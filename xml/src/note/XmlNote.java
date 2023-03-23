package note;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Iterator;
/**
 * @Description 解析xml文件
 * 需要导入dom4j-1.1.jar
 * @Author Noby
 * @Date 2023/3/21 12:03
 */
public class XmlNote {
    public static void main(String[] args) throws MalformedURLException, DocumentException {
        //1.获取文件字节码路径
        String path = XmlNote.class.getClassLoader().getResource("xmlText.xml").getPath();
//        InputStream inputStream = XmlNote.class.getClassLoader().getResourceAsStream("xmlText.xml");//该方法可直接获得输入流
        System.out.println(path);

        //2.创建文件解析器
        SAXReader saxReader = new SAXReader();

        //3.获得文档对象
        Document document = saxReader.read(new File(path));

        //4.获得根标签
        Element rootElement = document.getRootElement();
        System.out.println("rootElement.asXML() : \n" + rootElement.asXML());
        System.out.println();

        //5.通过迭代器遍历根标签里的所有子标签
        Iterator<?> iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element next = (Element) iterator.next();
            Attribute name = next.attribute("name");//获取标签的属性
            Attribute id = next.attribute("id");
            System.out.println("id,name = " + id.getValue() + "," + name.getValue());//获取属性值
            System.out.println("next.getText() = " + next.getText());//获取标签的内容
        }
    }
}

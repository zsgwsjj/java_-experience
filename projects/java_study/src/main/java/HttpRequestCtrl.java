import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : jiang
 * @time : 2018/4/9 14:46
 */
public class HttpRequestCtrl {

    public static void main(String[] args) {
        GetProductRequest object = new GetProductRequest();
        object.setSign("inner_test");
        object.setType(1);
        List<String> productIds = new ArrayList<>();
        productIds.add("111");
        productIds.add("222");
        object.setProductIDs(productIds);
        String objectStr = objectToXml(object);
        System.out.println(objectStr);

        try {

            String newStr = "<GetProductRequest><Type>1</Type><ProductIDs><ProductID>111</ProductID><ProductID>222</ProductID></ProductIDs></GetProductRequest>";
            System.out.println(newStr);
            InputStream inputStream = new ByteArrayInputStream(newStr.getBytes());
            SAXReader reader = new SAXReader();
            Document element = reader.read(inputStream);
            Element root = element.getRootElement();
            HashMap<String, String> nodeMap = new HashMap<>();
            List<Element> list = root.elements();
            for (Element element1 : list) {
                nodeMap.put(element1.getName(), element1.getData().toString());
            }
            System.out.println(nodeMap);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        HttpClient httpClient = new HttpClient();
//        PostMethod postMethod = new PostMethod("http://123.59.61.216:8080/reward/test");
//        postMethod.setRequestHeader("Content-Type", "text/xml");
//        postMethod.setRequestHeader("charset", "utf-8");
//        postMethod.setRequestBody(objectStr);
//        try {
//            httpClient.executeMethod(postMethod);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static String objectToXml(Object value) {
        String str = null;
        JAXBContext context = null;
        StringWriter writer = null;
        try {
            context = JAXBContext.newInstance(value.getClass());
            Marshaller marshaller = context.createMarshaller();
            writer = new StringWriter();
            marshaller.marshal(value, writer);
            str = writer.toString().replace("getProductRequest", "GetProductRequest");
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            if (context != null) {
                context = null;
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writer = null;
            }
        }
        return str;
    }
}

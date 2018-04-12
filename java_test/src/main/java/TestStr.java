import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author : jiang
 * @time : 2018/4/10 10:30
 */
public class TestStr {

    public static void main(String[] args) {

        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement("xml");
        xml.addAttribute("version", "2.0")
                .addElement("appid").addText("111")
                .addElement("mchId")
                .addElement("nonceStr")
                .addElement("transactionId")
                .addElement("sign");
        System.out.println(document.asXML());
    }
}

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author : jiang
 * @time : 2018/4/9 14:47
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProductRequest", propOrder = {
        "sign",
        "Type",
        "ProductIDs"
})
public class GetProductRequest {

    @XmlElement(name = "sign")
    private String sign;
    @XmlElement(name = "Type")
    private Integer Type;
    @XmlElementWrapper(name = "ProductIDs")
    @XmlElement(name = "ProductID")
    private List<String> ProductIDs;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        sign = sign;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public List<String> getProductIDs() {
        return ProductIDs;
    }

    public void setProductIDs(List<String> productIDs) {
        ProductIDs = productIDs;
    }
}

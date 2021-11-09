package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Card {

    @XmlAttribute
    String name;

    @XmlElement
    Cost cost;

    public String getName() {
        return name;
    }

    public Cost getCost() {
        return cost;
    }
}


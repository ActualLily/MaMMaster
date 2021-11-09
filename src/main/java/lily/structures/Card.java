package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Card {

    @XmlAttribute()
     String name;

    public String getName() {
        return name;
    }
}

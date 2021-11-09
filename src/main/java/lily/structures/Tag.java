package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Tag {

    @XmlAttribute
    String name;

    public String getName() {
        return name;
    }
}

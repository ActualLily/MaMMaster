package lily.structures.config;

import jakarta.xml.bind.annotation.XmlAttribute;

public class TextElement extends Elements{

    @XmlAttribute
    Integer fontSize;

    @XmlAttribute
    Boolean wrap;
}

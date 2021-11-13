package lily.structures.config;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Elements {

    @XmlAttribute
    Double version;

    @XmlAttribute
    Double xPosStart;

    @XmlAttribute
    Double yPosStart;

    @XmlAttribute
    Boolean trackHeight;

    @XmlAttribute
    String alignment;
}

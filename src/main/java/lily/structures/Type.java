package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Type {

    @XmlAttribute
    String main;

    @XmlAttribute
    String tribe;

    @XmlAttribute
    String range;

    public String getMain() {
        return main;
    }

    public String getTribe() {
        return tribe;
    }

    public String getMainTribe() {
        return main + " / " + tribe;
    }

    public String getRange() {
        return range;
    }
}

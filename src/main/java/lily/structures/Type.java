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
        String builtType = main;
        if (tribe != null) {
            builtType += " / " + tribe;
        }

        return builtType;
    }

    public String getRange() {
        return range;
    }
}

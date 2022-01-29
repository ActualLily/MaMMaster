package lily.structures.parameterized;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Type extends IParameterized {

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

    public String getRange() {
        return range;
    }
}

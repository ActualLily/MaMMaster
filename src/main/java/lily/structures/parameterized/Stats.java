package lily.structures.parameterized;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Stats extends IParameterized {

    @XmlAttribute
    String attack;

    @XmlAttribute
    String health;

    public String getAttack() {
        return attack;
    }

    public String getHealth() {
        return health;
    }
}

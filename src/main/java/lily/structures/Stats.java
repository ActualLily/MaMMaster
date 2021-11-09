package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Stats {

    @XmlAttribute
    Integer attack;

    @XmlAttribute
    Integer health;

    public Integer getAttack() {
        return attack;
    }

    public Integer getHealth() {
        return health;
    }
}

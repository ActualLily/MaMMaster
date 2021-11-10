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

    public String getAll() {
        String builtType = "";

        if (attack != null) {
            builtType += attack;
        }

        if (attack != null && health != null) {
            builtType += " / ";
        }

        if (health != null) {
            builtType += health;
        }

        return builtType;
    }
}

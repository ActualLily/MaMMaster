package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Stats {

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

package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Cost {

    @XmlAttribute
    Integer gold = null;

    @XmlAttribute
    Integer mana = null;

    public Integer getGold() {
        return gold;
    }

    public Integer getMana() {
        return mana;
    }

    public String getAll() {
        String string = "(";

        if (gold != null) {
            string = string + gold + "G";
        }

        if (gold != null && mana != null) {
            string = string + " / ";
        }

        if (mana != null) {
            string = string + mana + "M";
        }

        string = string + ")";

        return string;

    }
}

package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Cost {

    @XmlAttribute
    Integer gold = 0;

    @XmlAttribute
    Integer mana = 0;

    public Integer getGold() {
        return gold;
    }

    public Integer getMana() {
        return mana;
    }

    public String getAll() {
        String string = "(";

        if (gold > 0) {
            string = string + gold + "G";
        }

        if (gold > 0 && mana > 0) {
            string = string + " / ";
        }

        if (mana > 0) {
            string = string + mana + "M";
        }

        string = string + ")";

        return string;

    }
}

package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Cost {

    @XmlAttribute
    Integer gold;

    @XmlAttribute
    Integer mana;

    public Integer getGold() {
        return gold;
    }

    public Integer getMana() {
        return mana;
    }
}

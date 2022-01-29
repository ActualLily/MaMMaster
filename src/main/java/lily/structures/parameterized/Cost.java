package lily.structures.parameterized;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Cost extends IParameterized {

    @XmlAttribute
    String gold = null;

    @XmlAttribute
    String mana = null;

    public String getGold() {
        return gold + "G";
    }

    public String getMana() {
        return mana + "M";
    }
}
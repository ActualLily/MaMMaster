package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Art {

    @XmlAttribute
    String path;

    @XmlAttribute
    String credit;

    public String getPath() {
        return path;
    }

    public String getCredit() {
        return credit;
    }
}

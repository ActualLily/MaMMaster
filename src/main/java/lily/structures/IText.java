package lily.structures;

import jakarta.xml.bind.annotation.XmlAttribute;

public class IText {

    @XmlAttribute
    String text;

    @Override
    public String toString() {
        return getText();
    }

    public String getText() {
        return text;
    }
}

package lily.structures;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class Card extends IText {

    @XmlElement
    Cost cost;

    @XmlElement
    Stats stats;

    @XmlElement
    Type type;

    @XmlElement
    Art art;

    @XmlElement
    ArrayList<IText> description;

    public void setText(String text) {
        super.text = text;
    }

    public Cost getCost() {
        return cost;
    }

    public Stats getStats() {
        return stats;
    }

    public Type getType() {
        return type;
    }

    public Art getArt() {
        return art;
    }

    public ArrayList<IText> getDescription() {
        return description;
    }
}


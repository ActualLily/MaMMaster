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
    ArrayList<IText> tag = new ArrayList<>();

    @XmlElement
    Art art;

    @XmlElement
    IText description;

    public Cost getCost() {
        return cost;
    }

    public Stats getStats() {
        return stats;
    }

    public Type getType() {
        return type;
    }

    public ArrayList<IText> getTag() {
        return tag;
    }

    public Art getArt() {
        return art;
    }

    public IText getDescription() {
        return description;
    }
}


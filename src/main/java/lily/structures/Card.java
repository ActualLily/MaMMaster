package lily.structures;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lily.structures.parameterized.Cost;
import lily.structures.parameterized.Stats;
import lily.structures.parameterized.Type;

import java.util.ArrayList;

@XmlRootElement
public class Card extends ISimpleText {

    @XmlElement
    Cost cost;

    @XmlElement
    Stats stats;

    @XmlElement
    Type type;

    @XmlElement
    Art art;

    @XmlElement
    ArrayList<ISimpleText> description;

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

    public ArrayList<ISimpleText> getDescription() {
        return description;
    }
}


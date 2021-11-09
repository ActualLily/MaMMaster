package lily.structures;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;

public class Definitions {

    @XmlElement
    ArrayList<IText> description;

    @XmlElement
    ArrayList<IText> play;

    @XmlElement
    ArrayList<IText> passive;

    @XmlElement
    ArrayList<IText> active;

    @XmlElement
    IText flavor;

    public ArrayList<IText> getDescription() {
        return description;
    }

    public ArrayList<IText> getPlay() {
        return play;
    }

    public ArrayList<IText> getPassive() {
        return passive;
    }

    public ArrayList<IText> getActive() {
        return active;
    }

    public IText getFlavor() {
        return flavor;
    }
}

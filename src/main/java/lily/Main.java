package lily;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBContextFactory;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lily.structures.Card;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println(CardParser.getCard("src/main/resources/World Ender.xml").getCost().getGold());
    }
}

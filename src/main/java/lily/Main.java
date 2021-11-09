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
        JAXBContext context;

        try {
            context = JAXBContext.newInstance(Card.class);

            File input = new File("src/main/resources/World Ender.xml");
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

            Card card = (Card) jaxbUnmarshaller.unmarshal(input);

            System.out.println(card.getName());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

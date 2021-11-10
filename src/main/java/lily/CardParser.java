package lily;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lily.structures.Card;

import java.io.File;

public class CardParser {

    public static Card getCard(String fileLocation) {
        JAXBContext context;
        Card card = null;

        try {
            context = JAXBContext.newInstance(Card.class);
            File input = new File(fileLocation);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            card = (Card) jaxbUnmarshaller.unmarshal(input);

            if (card.getText() == null) {
                card.setText(input.getName().substring(0, input.getName().length() - 4));
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return card;
    }
}

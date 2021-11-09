package lily;

import lily.structures.Card;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FontFormatException {

        Card card = CardParser.getCard("src/main/resources/cards/World Ender.xml");

        System.out.println(card.getText());

        CardCreator cc = new CardCreator();
        cc.create(card);
    }
}

package lily;

import lily.structures.Card;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {

    private final static String FILE_BASE = "src/main/resources/cards/";

    public static void main(String[] args) throws IOException, FontFormatException {

        for (File fileEntry : Objects.requireNonNull(new File(FILE_BASE).listFiles()))
            if (fileEntry.getName().endsWith(".xml")) {
                Card card = CardParser.getCard(fileEntry.getAbsolutePath());

                System.out.println(card.getText());

                CardCreator cc = new CardCreator();
                cc.create(card);
            }
    }
}

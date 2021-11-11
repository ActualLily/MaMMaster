package lily;

import lily.structures.Card;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {

    private final static String FILE_BASE = "src/main/resources/cards/";
    private final static String FILE_PRINT = "target/";

    public static void main(String[] args) throws IOException, FontFormatException {
        grabImageFromCreator(new File(FILE_BASE));
    }

    private static void grabImageFromCreator(File file) throws IOException, FontFormatException {
        if (file.getName().endsWith(".xml")) {
            Card card = CardParser.getCard(file.getAbsolutePath());

            System.out.println(card.getText());

            CardCreator cc = new CardCreator();
            cc.create(card);

            ImageIO.write(cc.create(card), "png", new File(FILE_PRINT + card.getText() + "_CARD.png"));
        } else if (file.isDirectory()) {
            for (File fileEntry : Objects.requireNonNull(file.listFiles())) {
                grabImageFromCreator(fileEntry);
            }
        }
    }
}

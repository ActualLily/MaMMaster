package lily;

import lily.structures.Card;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Main {

    private final static String FILE_BASE = "src/main/resources/cards/";
    private final static String FILE_PRINT = "target/cards/";

    static Logger log = Logger.getLogger("Main");

    public static void main(String[] args) throws IOException, FontFormatException {
        sendFilesToCardCreator(new File(FILE_BASE));

        log.info("finished creating your cards :)");
    }

    private static void sendFilesToCardCreator(File file) throws IOException, FontFormatException {
        if (file.getName().endsWith(".xml")) {
            Card card = CardParser.getCard(file.getAbsolutePath());

            CardCreator cc = new CardCreator();

            Files.createDirectories(Path.of(FILE_PRINT + file.getParent().substring(25) + "/"));
            ImageIO.write(cc.create(card), "png", new File(FILE_PRINT + file.getParent().substring(25) + "/" + card.getText() + "_CARD.png"));
        } else if (file.isDirectory()) {
            log.debug("found directory: " + file.getName());
            for (File fileEntry : Objects.requireNonNull(file.listFiles())) {
                sendFilesToCardCreator(fileEntry);
            }
        }
    }
}

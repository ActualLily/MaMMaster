package lily;

import lily.structures.Card;
import lily.structures.GeneratorSettings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CardCreator {

    String imagePath = "src/main/resources/cardTemplate.png";
    Font font;

    public CardCreator() throws IOException, FontFormatException {
        font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tangent-Black.ttf")));
        font = font.deriveFont(52f);
    }

    public CardCreator(String templateImagePath) {
        this.imagePath = templateImagePath;
    }

    public void create(Card card) {
        try {
            final BufferedImage image = ImageIO.read(new File(imagePath));

            Graphics g = image.getGraphics();
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString(card.getText(),
                    (int) (image.getWidth() * GeneratorSettings.CARDNAME_OFFSETX),
                    (int) (image.getHeight() * GeneratorSettings.CARDNAME_OFFSETY));
            g.dispose();

            ImageIO.write(image, "png", new File("target/classes/cards/World Ender.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

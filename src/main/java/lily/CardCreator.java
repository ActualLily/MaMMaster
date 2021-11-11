package lily;

import lily.structures.Card;
import lily.structures.IText;
import org.apache.commons.text.WordUtils;
import org.apache.log4j.Logger;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static lily.structures.GeneratorSettings.SettingConstants.*;

public class CardCreator {

    static Logger log = Logger.getLogger("Main");

    String imagePath = "src/main/resources/cardTemplate.png";
    Font font;

    Double trackDescYPos = 0.0;

    public CardCreator() throws IOException, FontFormatException {
        font = Font.createFont(Font.TRUETYPE_FONT,
                Objects.requireNonNull(getClass().getClassLoader()
                        .getResourceAsStream("Tangent-Black.ttf")));
    }

    @SuppressWarnings("ThrowablePrintedToSystemOut")
    public BufferedImage create(Card card) {

        log.info("creating " + card.getText());

        try {
            BufferedImage image = ImageIO.read(new File(imagePath));

            writeOnImage(image, card.getText(), NAME_X, NAME_Y, NAME_SIZE);
            writeOnImage(image, card.getType().getMainTribe(), TYPE_X, TYPE_Y, TYPE_SIZE);

            if (card.getCost() != null) {
                writeOnImage(image, card.getCost().getAll(), COST_X, COST_Y, COST_SIZE, true);
            }

            if (card.getStats() != null) {
                writeOnImage(image, card.getStats().getAll(), STATS_X, STATS_Y, STATS_SIZE, true);
            }

            trackDescYPos = DESC_Y_START;

            if (card.getType().getRange() != null) {
                writeOnImage(image, "[" + card.getType().getRange() + "]", RANGE_X, trackDescYPos, RANGE_SIZE, true);
            }

            if (card.getDescription() != null) {
                for (IText cardDescription : card.getDescription()) {
                    writeOnImage(image, cardDescription.getText(), DESC_X, trackDescYPos, DESC_SIZE);
                }
            }

            BufferedImage combined = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g = combined.getGraphics();
            g.drawImage(image, 0, 0, null);

            if (card.getArt() != null) {
                log.info("downloading image from " + card.getArt().getPath());
                BufferedImage art = ImageIO.read(new URL(card.getArt().getPath()));

                if (SCALEART) {
                    int boundingbox = (int) (image.getWidth() - (image.getWidth() * ART_X * 2));
                    if (boundingbox != art.getWidth()) {
                        log.warn("image for " + card.getText() + " doesn't fit - resizing");
                        art = simpleResizeImage(art, boundingbox);
                    }
                }
                int cropWidth = Math.min(art.getWidth(), (int) (image.getWidth() - (image.getWidth() * ART_X * 2)));
                int cropHeight = Math.min(art.getHeight(), (int) (image.getHeight() * ART_HEIGHT));

                BufferedImage croppedArt = art.getSubimage((art.getWidth() - cropWidth) / 2, (art.getHeight() - cropHeight) / 2, cropWidth, cropHeight);

                int xPos = Math.max((int) (ART_X * image.getWidth()), (image.getWidth() - cropWidth) / 2);
                int yPos = (int) (ART_Y * image.getHeight());

                g.drawImage(croppedArt, xPos, yPos, null);
            }

            return combined;

        } catch (IOException e) {
            System.out.println(e);
        }

        return null;
    }

    private void writeOnImage(BufferedImage image, String text, double pctLocationX, double pctLocationY, int fontSize, boolean rightbound) {
        writeOnImage(image, text, (int) (image.getWidth() * pctLocationX), (int) (image.getHeight() * pctLocationY), fontSize, rightbound);
    }

    private void writeOnImage(BufferedImage image, String text, double pctLocationX, double pctLocationY, int fontSize) {
        writeOnImage(image, text, (int) (image.getWidth() * pctLocationX), (int) (image.getHeight() * pctLocationY), fontSize, false);
    }

    private void writeOnImage(BufferedImage image, String text, int locationX, int locationY, int fontSize, boolean rightbound) {
        font = font.deriveFont((float) fontSize);

        Graphics graphics = image.getGraphics();
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);

        if (rightbound) {
            locationX = locationX - graphics.getFontMetrics().stringWidth(text);
        }

        drawWrapped(graphics, text, image, locationX, locationY);
        graphics.dispose();
    }

    private void drawWrapped(Graphics graphics, String text, BufferedImage image, int locationX, int locationY) {
        ArrayList<String> workingStrings = new ArrayList<>(Arrays.asList(text.split("\\r?\\n")));

        for (int i = text.length() - 1; i > 10; i--) {
            int largestLength = 0;

            for (String string : workingStrings) {
                int currentLength = graphics.getFontMetrics().stringWidth(string);
                if (currentLength > largestLength) {
                    largestLength = currentLength;
                }
            }

            if (largestLength <= (image.getWidth() - (locationX * 2))) {
                break;
            } else {
                workingStrings = new ArrayList<>(Arrays.asList(WordUtils.wrap(text, i).split("\\r?\\n")));
            }
        }

        for (String string : workingStrings) {
            graphics.drawString(string, locationX, locationY);
            int fontHeight = graphics.getFontMetrics().getHeight();
            locationY += fontHeight;
            if (trackDescYPos != 0.0) {
                trackDescYPos += (float) fontHeight / image.getHeight();
            }
        }
    }

    private BufferedImage simpleResizeImage(BufferedImage originalImage, int targetWidth) {
        return Scalr.resize(originalImage, targetWidth);
    }
}

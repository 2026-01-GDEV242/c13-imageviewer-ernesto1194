 import java.awt.Color;

/**
 * Creates a Warhol-style 2x2 image:
 * each quadrant shows a quarter-size version of the image
 * with different color tints applied.
 *
 * @author (Ernesto Cuellar)
 */

public class WarholFilter extends Filter
{
    public WarholFilter()
    {
        super("Warhol Filter");
    }

    public void apply(OFImage image)
    {
        int width = image.getWidth();
        int height = image.getHeight();

        OFImage result = new OFImage(width, height);

        int halfW = width / 2;
        int halfH = height / 2;

        // loop over destination image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                // map destination pixel to source pixel (scaled down)
                int srcX = x % halfW;
                int srcY = y % halfH;

                Color pixel = image.getPixel(srcX, srcY);

                // TOP LEFT - original (quarter image)
                if (x < halfW && y < halfH) {
                    result.setPixel(x, y, pixel);
                }

                // TOP RIGHT - red tint (quarter image)
                else if (x >= halfW && y < halfH) {
                    result.setPixel(x, y,
                        new Color(pixel.getRed(), 0, 0));
                }

                // BOTTOM LEFT - green tint (quarter image)
                else if (x < halfW && y >= halfH) {
                    result.setPixel(x, y,
                        new Color(0, pixel.getGreen(), 0));
                }

                // BOTTOM RIGHT - blue tint (quarter image)
                else {
                    result.setPixel(x, y,
                        new Color(0, 0, pixel.getBlue()));
                }
            }
        }

        // copy result back into original image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setPixel(x, y, result.getPixel(x, y));
            }
        }
    }
}
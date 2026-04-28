import java.awt.Color;

/**
 * Creates a flipped Warhol-style 2x2 image:
 * original, red tint (h-flip), green tint (v-flip),
 * blue tint (both flips).
 *
 * @author (Ernesto Cuellar)
 */

public class FlippedWarholFilter extends Filter
{
    public FlippedWarholFilter()
    {
        super("Flipped Warhol Filter");
    }

    public void apply(OFImage image)
    {
        int width = image.getWidth();
        int height = image.getHeight();

        OFImage result = new OFImage(width, height);

        int halfW = width / 2;
        int halfH = height / 2;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                Color pixel = image.getPixel(x, y);

                // TOP LEFT - original
                if (x < halfW && y < halfH) {
                    result.setPixel(x, y, pixel);
                }

                // TOP RIGHT - red tint + horizontal flip
                else if (x >= halfW && y < halfH) {

                    int fx = width - 1 - x;

                    Color flipped = image.getPixel(fx, y);

                    result.setPixel(x, y,
                        new Color(flipped.getRed(), 0, 0));
                }

                // BOTTOM LEFT - green tint + vertical flip
                else if (x < halfW && y >= halfH) {

                    int fy = height - 1 - y;

                    Color flipped = image.getPixel(x, fy);

                    result.setPixel(x, y,
                        new Color(0, flipped.getGreen(), 0));
                }

                // BOTTOM RIGHT - blue tint + both flips
                else {

                    int fx = width - 1 - x;
                    int fy = height - 1 - y;

                    Color flipped = image.getPixel(fx, fy);

                    result.setPixel(x, y,
                        new Color(0, 0, flipped.getBlue()));
                }
            }
        }

        // Copy result back into original image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setPixel(x, y, result.getPixel(x, y));
            }
        }
    }
}
import java.awt.Color;

/**
 * Flipped Warhol filter.
 */

public class FlippedWarholFilter extends Filter
{
    public FlippedWarholFilter(String name)
    {
        super(name);
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

                if (x < halfW && y < halfH) {
                    result.setPixel(x, y, image.getPixel(x, y));
                }
                else if (x >= halfW && y < halfH) {
                    result.setPixel(x, y,
                        new Color(image.getPixel(width - 1 - x, y).getRed(), 0, 0));
                }
                else if (x < halfW && y >= halfH) {
                    result.setPixel(x, y,
                        new Color(0, image.getPixel(x, height - 1 - y).getGreen(), 0));
                }
                else {
                    result.setPixel(x, y,
                        new Color(0, 0,
                            image.getPixel(width - 1 - x, height - 1 - y).getBlue()));
                }
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setPixel(x, y, result.getPixel(x, y));
            }
        }
    }
}
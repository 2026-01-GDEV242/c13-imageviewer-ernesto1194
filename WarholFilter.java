import java.awt.Color;

/**
 * Warhol filter (2x2 tinted image).
 */

public class WarholFilter extends Filter
{
    public WarholFilter(String name)
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

                Color pixel = image.getPixel(x % halfW, y % halfH);

                if (x < halfW && y < halfH) {
                    result.setPixel(x, y, pixel);
                }
                else if (x >= halfW && y < halfH) {
                    result.setPixel(x, y,
                        new Color(pixel.getRed(), 0, 0));
                }
                else if (x < halfW && y >= halfH) {
                    result.setPixel(x, y,
                        new Color(0, pixel.getGreen(), 0));
                }
                else {
                    result.setPixel(x, y,
                        new Color(0, 0, pixel.getBlue()));
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
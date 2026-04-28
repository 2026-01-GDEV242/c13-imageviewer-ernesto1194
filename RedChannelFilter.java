import java.awt.Color;

/**
 * Red channel grayscale filter.
 */

public class RedChannelFilter extends Filter
{
    public RedChannelFilter(String name)
    {
        super(name);
    }

    public void apply(OFImage image)
    {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                Color pixel = image.getPixel(x, y);
                int red = pixel.getRed();

                image.setPixel(x, y, new Color(red, red, red));
            }
        }
    }
}
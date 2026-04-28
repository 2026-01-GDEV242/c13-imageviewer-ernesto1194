import java.awt.Color;

/**
 * Blue channel grayscale filter.
 */

public class BlueChannelFilter extends Filter
{
    public BlueChannelFilter(String name)
    {
        super(name);
    }

    public void apply(OFImage image)
    {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                Color pixel = image.getPixel(x, y);
                int blue = pixel.getBlue();

                image.setPixel(x, y, new Color(blue, blue, blue));
            }
        }
    }
}
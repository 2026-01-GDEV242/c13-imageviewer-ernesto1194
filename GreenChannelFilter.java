import java.awt.Color;

/**
 * Green channel grayscale filter.
 */

public class GreenChannelFilter extends Filter
{
    public GreenChannelFilter(String name)
    {
        super(name);
    }

    public void apply(OFImage image)
    {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                Color pixel = image.getPixel(x, y);
                int green = pixel.getGreen();

                image.setPixel(x, y, new Color(green, green, green));
            }
        }
    }
}
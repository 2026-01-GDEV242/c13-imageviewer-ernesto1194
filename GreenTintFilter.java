import java.awt.Color;

/**
 * Green tint filter.
 */

public class GreenTintFilter extends Filter
{
    public GreenTintFilter(String name)
    {
        super(name);
    }

    public void apply(OFImage image)
    {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                Color pixel = image.getPixel(x, y);

                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();

                image.setPixel(x, y,
                    new Color((int)(red * 0.3), green, (int)(blue * 0.3)));
            }
        }
    }
}
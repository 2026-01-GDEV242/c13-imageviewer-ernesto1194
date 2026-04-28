import java.awt.Color;

/**
 * A filter that applies a blue tint to an image.
 * The blue component is preserved while red and green are reduced,
 * giving the image a bluish appearance.
 *
 * @author (Ernesto Cuellar)
 */

public class BlueTintFilter extends Filter
{
    /**
     * Constructor for BlueTintFilter.
     */
    public BlueTintFilter()
    {
        super("Blue Tint Filter");
    }

    /**
     * Applies a blue tint by reducing red and green values.
     */
    public void apply(OFImage image)
    {
        // Loop through every pixel
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                Color pixel = image.getPixel(x, y);

                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();

                // Reduce non-blue channels
                Color newColor = new Color(
                    (int)(red * 0.3),
                    (int)(green * 0.3),
                    blue
                );

                image.setPixel(x, y, newColor);
            }
        }
    }
}
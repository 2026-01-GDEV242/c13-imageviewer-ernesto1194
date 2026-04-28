import java.awt.Color;

/**
 * A filter that applies a red tint to an image.
 * The red component is preserved while green and blue are reduced,
 * giving the image a reddish appearance.
 *
 * @author (Ernesto Cuellar)
 */

public class RedTintFilter extends Filter
{
    /**
     * Constructor for RedTintFilter.
     */
    public RedTintFilter()
    {
        super("Red Tint Filter");
    }

    /**
     * Applies a red tint by reducing green and blue values.
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

                // Reduce non-red channels to create tint
                Color newColor = new Color(
                    red,
                    (int)(green * 0.3),
                    (int)(blue * 0.3)
                );

                image.setPixel(x, y, newColor);
            }
        }
    }
}
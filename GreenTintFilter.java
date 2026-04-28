import java.awt.Color;

/**
 * A filter that applies a green tint to an image.
 * The green component is preserved while red and blue are reduced,
 * giving the image a greenish appearance.
 *
 * @author (Ernesto Cuellar)
 */

public class GreenTintFilter extends Filter
{
    /**
     * Constructor for GreenTintFilter.
     */
    public GreenTintFilter()
    {
        super("Green Tint Filter");
    }

    /**
     * Applies a green tint by reducing red and blue values.
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

                // Reduce non-green channels
                Color newColor = new Color(
                    (int)(red * 0.3),
                    green,
                    (int)(blue * 0.3)
                );

                image.setPixel(x, y, newColor);
            }
        }
    }
}
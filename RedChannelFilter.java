import java.awt.Color;

/**
 * A filter that converts an image to grayscale based on the red channel.
 * Pixels are replaced with a shade of gray where brightness depends on
 * the intensity of the red component.
 *
 * @author (Ernesto Cuellar)
 */

public class RedChannelFilter extends Filter
{
    /**
     * Constructor for RedChannelFilter.
     * Sets the name of the filter in the parent Filter class.
     */
    public RedChannelFilter()
    {
        super("Red Channel Filter");
    }

    /**
     * Applies the filter to the image.
     * Each pixel is replaced with a grayscale value based on its red component.
     */
    public void apply(OFImage image)
    {
        // Loop through every pixel in the image
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                Color pixel = image.getPixel(x, y);

                int red = pixel.getRed();

                // Convert to grayscale using red value only
                Color newColor = new Color(red, red, red);

                image.setPixel(x, y, newColor);
            }
        }
    }
}
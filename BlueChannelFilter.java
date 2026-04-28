import java.awt.Color;

/**
 * A filter that converts an image to grayscale based on the blue channel.
 * Pixels are replaced with a shade of gray where brightness depends on
 * the intensity of the blue component.
 *
 * @author (Ernesto Cuellar)
 */

public class BlueChannelFilter extends Filter
{
    /**
     * Constructor for BlueChannelFilter.
     * Sets the name of the filter in the parent Filter class.
     */
    public BlueChannelFilter()
    {
        super("Blue Channel Filter");
    }

    /**
     * Applies the filter to the image.
     * Each pixel is replaced with a grayscale value based on its blue component.
     */
    public void apply(OFImage image)
    {
        // Loop through every pixel in the image
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                Color pixel = image.getPixel(x, y);

                int blue = pixel.getBlue();

                // Create grayscale color using blue value only
                Color newColor = new Color(blue, blue, blue);

                image.setPixel(x, y, newColor);
            }
        }
    }
}
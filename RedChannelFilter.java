import java.awt.Color;

public class RedChannelFilter extends Filter
{
    public RedChannelFilter()
    {
        super("Red Channel Filter");
    }

    public void apply(OFImage image)
    {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                Color pixel = image.getPixel(x, y);

                int red = pixel.getRed();

                Color newColor = new Color(red, red, red);

                image.setPixel(x, y, newColor);
            }
        }
    }
}
import java.awt.Color;

/**
 * A filter that creates a Warhol-style 2x2 image:
 * original, red tint, green tint, and blue tint.
 *
 * @author (Ernesto Cuellar)
 */

public class WarholFilter extends Filter
{
    public WarholFilter()
    {
        super("Warhol Filter");
    }

    public void apply(OFImage image)
    {
        // We will rebuild the image, so first create copies
    }
}
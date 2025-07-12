import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Util {

    private static HashMap<String, Image> cache = new HashMap<String, Image>();

    public static Image loadImage (String path) {
        Image image = null;

        if (cache.containsKey(path)) {
            return cache.get(path);
        }

        try {
            InputStream in = Util.class.getClassLoader().getResourceAsStream(path);
            if (in != null) {
                image = ImageIO.read(in);
                in.close();
            } else {
                image = ImageIO.read(new File(path));
            }

            if (image != null && !cache.containsKey(path)) {
                cache.put(path, image);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}

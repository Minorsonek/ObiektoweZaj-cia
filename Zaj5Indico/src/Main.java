import io.indico.Indico;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
        var apiKey = "c368c941ab2289043cc2b60e6c35d9d4";

        var filePath = "foto/bocian.jpg";

        try
        {
            File file = new File(filePath);

            BufferedImage image = ImageIO.read(file);

            Indico indico = new Indico(apiKey);
            var result = indico.fer.predict(image);

            System.out.println(result.getFer());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        System.out.println("Hello world");
    }
}

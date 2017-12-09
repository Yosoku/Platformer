import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	private  BufferedImage image;
	private String path;
	BufferedImageLoader(String path)
	{
		this.path = path;
	}

	public BufferedImage loadBufferedImage()
	{
		try {
			image = ImageIO.read(getClass().getResource(path));
	}catch(IOException e)
		{
			e.printStackTrace();
		}
		return image;
	}
}


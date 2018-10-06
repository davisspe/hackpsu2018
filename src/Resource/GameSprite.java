package Resource;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class GameSprite {
	
	public BufferedImage sprite;
	
	private Dimension dimension;
	
	public GameSprite(BufferedImage b) {
		this.sprite = b;
		this.dimension = new Dimension(b.getWidth(), b.getHeight());
	}
	
	public int height(){
		return dimension.height;
	}
	
	public int width(){
		return dimension.width;
	}

}

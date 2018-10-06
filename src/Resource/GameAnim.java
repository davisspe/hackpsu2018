package Resource;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameAnim {
	
	private ArrayList<BufferedImage> frames;
	
	public GameAnim(BufferedImage br, Dimension dim, int frameCount) {
		
		frames = new ArrayList<BufferedImage>();
		
		for(int i = 0; i < frameCount; i++){
			frames.add(br.getSubimage(i*dim.width, 0, dim.width, dim.height));
		}
	}
	
	public AnimationStream getAnimationStream(){
		return new AnimationStream();
	}
	
	public class AnimationStream{
		
		public int frameIndex;
		public AnimationStream(){}
		
		public GameSprite next(){
			if(frameIndex >= frames.size()){
				frameIndex = 0;
			}
			frameIndex++;
			return new GameSprite(frames.get(frameIndex - 1));
		}
		
	}

}

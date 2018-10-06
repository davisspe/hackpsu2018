package Resource.Name;

import java.awt.Dimension;

public enum AnimName {

	test_anim("test.gif", 30, 30, 5);
	
	String filePath;
	Dimension dim;
	int frameCount;
	
	AnimName(String filePath, int width, int height, int frameCount){
		this.filePath = filePath;
		this.dim = new Dimension(width, height);
		this.frameCount = frameCount;
	}
	
	public String toString(){
		return filePath;
	}
	
	public Dimension getDim(){
		return dim;
	}
	
	public int getFrameCount(){
		return frameCount;
	}
	
	
}

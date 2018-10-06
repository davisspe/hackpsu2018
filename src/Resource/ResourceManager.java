package Resource;
import Resource.Name.*;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ResourceManager {
	
	static HashMap<ScriptName, GameScript> Scripts = new HashMap<ScriptName, GameScript>();
	static HashMap<DialogName, GameDialog> Dialogs = new HashMap<DialogName, GameDialog>(); 
	static HashMap<SpriteName, GameSprite> Sprites = new HashMap<SpriteName, GameSprite>();
	static HashMap<AnimName, GameAnim> Animations = new HashMap<AnimName, GameAnim>();
	
	//Accessing Resources
	
	public GameScript getScript(ScriptName s){
		if(!Scripts.containsKey(s)){
			loadScript(s);
		}
		return Scripts.get(s);
	}
	
	public GameDialog getDialog(DialogName d){
		if(!Dialogs.containsKey(d)){
			loadDialog(d);
		}
		return Dialogs.get(d);
	}
	
	public GameSprite getSprite(SpriteName s){
		if(!Sprites.containsKey(s)){
			loadSprite(s);
		}
		return Sprites.get(s);
	}
	
	public GameAnim.AnimationStream getAnim(AnimName a){
		if(!Animations.containsKey(a)){
			loadAnim(a);
		}
		return Animations.get(a).getAnimationStream();
	}
	
	//Loading Resources
	
	private BufferedReader getFileReader(String filePath) throws FileNotFoundException, UnsupportedEncodingException{
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream(filePath);
		return new BufferedReader(new InputStreamReader(is, "UTF-8"));
	}
	
	private BufferedImage getImage(String filePath) throws IOException{
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream(filePath);
		return ImageIO.read(is);
	}
	
	public void loadAnim(AnimName a){
		try{
			GameAnim g = new GameAnim(getImage("Animations/" + a.toString()),
					a.getDim(),
					a.getFrameCount());
			Animations.put(a, g);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error loading animation: " + a.name() + " \"" + a.toString() + "\"");
		}
	}
	
	public void loadSprite(SpriteName s){
		try{
			GameSprite g = new GameSprite(getImage("Sprites/" + s.toString()));
			Sprites.put(s, g);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error loading sprite: " + s.name() + " \"" + s.toString() + "\"");
		}
	}
	
	public void loadScript(ScriptName s){
		
		try(BufferedReader br = getFileReader("Scripts/" + s.toString())){
			
			Scripts.put(s, new GameScript(br));
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error loading script: " + s.name() + " \"" + s.toString() + "\"");
		}
		
	}
	
	public void loadDialog(DialogName d){
		
		try(BufferedReader br = getFileReader("Dialogs/" + d.toString())){
			
			Dialogs.put(d, new GameDialog(br));
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error loading dialog: " + d.name() + " \"" + d.toString() + "\"");
		}
		
	}
	
	
	
}

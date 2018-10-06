package Resource;
import java.io.BufferedReader;
import java.io.IOException;

public class GameScript {

	public String script;
	
	public GameScript(String script) {
		this.script = script;
	}
	
	public GameScript(BufferedReader r) throws IOException {
		
		StringBuilder s = new StringBuilder();
		
		String line;
		while((line = r.readLine()) != null){
			s.append(line);
		}
		
		this.script = s.toString();
	}
}

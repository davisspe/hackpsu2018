package Scripting;
import java.util.Scanner;

import Resource.GameDialog;
import Resource.GameScript;
import Resource.ResourceManager;


public class ScriptTest {

	public ScriptTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ScriptManager m = new ScriptManager();
		
		ResourceManager r = new ResourceManager();
		
		GameScript g = r.getScript(Resource.Name.ScriptName.test_script);
		
		m.runScript(g);
		
	}

}

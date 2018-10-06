package Scripting;
import Resource.GameScript;

import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import Scripting.ScriptResponses.ScriptResponse;

public class ScriptManager {

	private ScriptEngine engine;
	
	public ScriptManager() {
		this(new HashMap<ScriptFlag, Object>());
	}
	
	public ScriptManager(Map<ScriptFlag, Object> d){
		engine = new ScriptEngineManager().getEngineByName("JavaScript");
		
		for(ScriptFlag flag : ScriptFlag.values()){
			if(d.containsKey(flag)){
				engine.getContext().setAttribute(flag.toString(), d.get(flag), ScriptContext.GLOBAL_SCOPE);
			}else{
				engine.getContext().setAttribute(flag.toString(), false, ScriptContext.GLOBAL_SCOPE);
			}
			
		}
	}
	
	public Map<ScriptFlag, Object> scriptFlags(){
		Map<ScriptFlag, Object> d = new HashMap<ScriptFlag, Object>();
		
		for(ScriptFlag f : ScriptFlag.values()){
			try{
				Object val = engine.getContext().getAttribute(f.toString());
				d.put(f, val);
			}catch(Exception e){
				//ignore errors
			}
		}		
		return d;
	}
	
	public ScriptResponse runScript(GameScript g){
		String response = "";
		
		try{
			response = engine.eval(g.script).toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ScriptResponse.parseResponse(response);
	}
	
	
	public void setFlag(ScriptFlag f, Object o){
		engine.getContext().setAttribute(f.toString(), o, ScriptContext.GLOBAL_SCOPE);
	}
	
	public Object getFlag(ScriptFlag f){
		Object val;
		try{
			val = engine.getContext().getAttribute(f.toString(), ScriptContext.GLOBAL_SCOPE); 
		}catch(Exception e){
			val = null;
		}
		return val;
	}

}

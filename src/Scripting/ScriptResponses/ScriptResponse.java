package Scripting.ScriptResponses;

import Resource.Name.DialogName;



public abstract class ScriptResponse {
	
	enum ScriptResponses{
		STD_OUT,
		DIALOG
	}
	
	public static ScriptResponse parseResponse(String response){
		
		String[] tokens = response.split(" ");
		
		if(tokens[0].equals(ScriptResponses.STD_OUT.toString())){
			System.out.println(tokens[1]);
			return new EmptyResponse();
		}else if(tokens[0].equals(ScriptResponses.DIALOG.toString())){
			return new DialogResponse(DialogName.valueOf(tokens[1]));
		}
		else{
			return new EmptyResponse();
		}
	}

}

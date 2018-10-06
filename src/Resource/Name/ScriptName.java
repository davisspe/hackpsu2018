package Resource.Name;

public enum ScriptName {
	
	test_script("test.js");
	
	
	private String filePath;
	private ScriptName(String filePath){
		this.filePath = filePath;
		
	}
	
	public String toString(){
		return filePath;
	}
}

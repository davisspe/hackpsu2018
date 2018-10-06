package Resource.Name;

public enum SpriteName {

	test_sprite("");
	
	String filePath;
	
	SpriteName(String filePath){
		this.filePath = filePath;
	}
	
	public String toString(){
		return filePath;
	}
	
	
}

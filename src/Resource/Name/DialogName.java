package Resource.Name;

public enum DialogName {

	test_dialog("test.txt");
	
	
	String filePath;
	
	DialogName(String filePath){
		this.filePath = filePath;
	}
	
	public String toString(){
		return filePath;
	}
	
	
}

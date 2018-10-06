package Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameDialog {
	
	private int index;
	private ArrayList<String> paragraphs;
	
	public static final String END_DIALOG = "";
	
	private final String lineBreak = "";
	
	public GameDialog(List<String> l) {
		paragraphs = new ArrayList<String>();
		for(String s : l){
			paragraphs.add(s);
		}
	}
	
	public GameDialog(BufferedReader r) throws IOException{
		paragraphs = new ArrayList<String>();
		
		StringBuilder s = new StringBuilder();
		String line;
		while((line = r.readLine()) != null){
			if(line.equals(lineBreak)){
				paragraphs.add(s.toString());
				s = new StringBuilder();
			}else{
				s.append(line + System.lineSeparator());
			}
		}
		paragraphs.add(s.toString());
	}
	
	public void reset(){
		index = 0;
	}
	
	public String next(){
		if(index >= paragraphs.size()){
			reset();
			return END_DIALOG;
		}
		index++;
		return paragraphs.get(index-1);
		
	}

}

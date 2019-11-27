package com.tutorial.common;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Component
public class FileContentReader {
	
	public String readFileContent(File file) {
		try {
			if(file.exists()){
				if(file.isFile()){
					if(file.canRead()) {
						BufferedReader br = new BufferedReader(new FileReader(file));
						StringBuilder stringBuilder = new StringBuilder();
						String st;
						int tabCount=0;
						while((st=br.readLine())!=null) {
							if(isBlankLine(st))
								stringBuilder.append("<br>");
							for(int i=0;i<st.length();i++) {
								char ch = st.charAt(i);
								if(ch=='\t') {
									tabCount++;
								}else {
									for(int j=0;j<tabCount;j++)
										stringBuilder.append("&nbsp;&nbsp;");
									stringBuilder.append(getOpenHeading(tabCount)+st+getCloseHeading(tabCount)+"<br>");
									tabCount =0;
									break;
								}
							}
						}
						br.close();
						return stringBuilder.toString();
					}else {
						return "File is not readable";
					}
				}else if(file.isDirectory()) {
					return "this is a directory. Path = "+file.getAbsolutePath(); 
				}
			}else {
				return "file does not exist. ";
			}
			
		} catch (Exception e) {
			return "exception occur. e="+e;
		}
		return "return null.";
	}

	private String getOpenHeading(int tabCount) {
		tabCount++;
		return "<h"+tabCount+">";
	}
	
	private String getCloseHeading(int tabCount) {
		tabCount++;
		return "</h"+tabCount+">";
	}
	
	private boolean isBlankLine(String st) {
		for(int i=0;i<st.length();i++){
			char ch = st.charAt(i);
			if(!Character.isWhitespace(ch))
				return false;
		}
		return true;
	}

}

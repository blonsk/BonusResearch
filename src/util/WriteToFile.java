package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	String fileAddr;
	BufferedWriter bw;

	public WriteToFile(String fileAddr) throws Exception {
		super();
		this.fileAddr = fileAddr;
		File file = new File(fileAddr);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file);
		this.bw = new BufferedWriter(fw);
	}

	public void writeToFile(String content) throws Exception{
		bw.write(content);
	}
	public void closeWriting() throws IOException{
		bw.close();
	}
}

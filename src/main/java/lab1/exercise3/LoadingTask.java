package lab1.exercise3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class LoadingTask implements Runnable{
	
	private File fileName;
	private JTextArea ta;
	
	/**
	 * @param fileName
	 * @param ta
	 */
	public LoadingTask(File fileName, JTextArea ta) {
		this.fileName = fileName;
		this.ta = ta;
	}
	
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(fileName));
			int i = 0;
			String line = in.readLine();
			while(line != null) {
				i ++;
				ta.append(i + ": " + line);
				ta.append("\n");
				line = in.readLine();
			}
			
		}catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}	
	}

}

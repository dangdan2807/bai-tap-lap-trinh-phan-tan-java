package lab1.exercise3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class LoadingTask3 extends SwingWorker<Long, Long>{
	
	private File fileName;
	private JTextArea ta;
	
	/**
	 * @param fileName
	 * @param ta
	 */
	public LoadingTask3(File fileName, JTextArea ta) {
		this.fileName = fileName;
		this.ta = ta;
	}

	@Override
	protected Long doInBackground() throws Exception {
		BufferedReader in = null;
		
		long lines = 0l;
		
		try {
			in = new BufferedReader(new FileReader(fileName));
			lines = Files.lines(Paths.get(fileName.getAbsolutePath()), StandardCharsets.UTF_8).count();
			long n = lines / 100; 
			long i = 0;
			int p = 0;
			String line = in.readLine();
			while(line != null) {
				i ++;
				ta.append(i + ": " + line);
				ta.append("\n");
				
				if(n > 0 && i % n == 0) {
					p ++;
					setProgress(Math.min(100, p));
					
					publish(i);
				}
				
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
		return lines;
	}

	@Override
	protected void process(List<Long> chunks) {
		System.out.println(chunks);
	}

	@Override
	protected void done() {
		try {
			long lines = get();
			JOptionPane.showMessageDialog(null, "Completed! Lines in total : " + lines);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
}

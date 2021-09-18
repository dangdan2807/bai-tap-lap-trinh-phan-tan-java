package lab1.exercise3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MyNotepad extends JFrame{
	
	private JTextArea ta;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem menuOpen;
	private JProgressBar progress;
	private JFileChooser fc;

	public MyNotepad() {
		setTitle("My notepad");
		setMinimumSize(new Dimension(800, 500));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setJMenuBar(menuBar = new JMenuBar());
		menuBar.add(menuFile = new JMenu("File"));
		menuFile.setMnemonic('F');
		
		menuFile.add(menuOpen = new JMenuItem("Open"));
		menuOpen.setMnemonic('O');
		menuOpen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
		
		add(new JScrollPane(ta = new JTextArea()), BorderLayout.CENTER);
		
		add(progress = new JProgressBar(), BorderLayout.SOUTH);
		progress.setStringPainted(true);
		
		fc = new JFileChooser();
		fc.setCurrentDirectory(new File("./data"));
		
		menuOpen.addActionListener((e) -> {
			int app = fc.showOpenDialog(this);
			if(app == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				BufferedReader in = null;
				try {
					in = new BufferedReader(new FileReader(file));
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
		});
	}
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> new MyNotepad().setVisible(true));
	}

}

package lab1.exercise3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.io.File;
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

public class MyNotepad2 extends JFrame{
	
	private JTextArea ta;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem menuOpen;
	private JProgressBar progressBar;
	private JFileChooser fc;

	public MyNotepad2() {
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
		
		add(progressBar = new JProgressBar(), BorderLayout.SOUTH);
		progressBar.setStringPainted(true);
		
		fc = new JFileChooser();
		fc.setCurrentDirectory(new File("./data"));
		
		menuOpen.addActionListener((e) -> {
			int app = fc.showOpenDialog(this);
			if(app == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				LoadingTask task = new LoadingTask(file, ta);
				Thread thread = new Thread(task);
				thread.start();
			}
		});
	}
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> new MyNotepad2().setVisible(true));
	}

}

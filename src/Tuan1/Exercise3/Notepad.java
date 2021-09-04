package Tuan1.Exercise3;

import javax.swing.*;
// import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class Notepad extends JFrame implements ActionListener, KeyListener {
    private String notepadName = "Simple";
    private JMenu mFile, mEdit, mHelp;
    private JMenuItem itemNew, itemOpen, itemSave, itemExit, itemPrint, itemCopy, itemCut, itemPaste, itemAbout;
    private JTextPane tpContent;
    private JLabel lblStatus;
    private JFileChooser fc = new JFileChooser();

    public Notepad(String notepadName) {
        this.notepadName = notepadName;
        setTitle(notepadName + " Notepad");
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createNotepad();
    }

    public Notepad() {
        setTitle(notepadName + " Notepad");
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createNotepad();
    }

    public void createNotepad() {
        JPanel pnMain = new JPanel();
        pnMain.setBackground(Color.decode("#ffffff"));
        getContentPane().add(pnMain, BorderLayout.CENTER);
        pnMain.setLayout(new BorderLayout(0, 0));

        JMenuBar menuBar = new JMenuBar();
        pnMain.add(menuBar, BorderLayout.NORTH);

        menuBar.add(mFile = new JMenu("File"));
        menuBar.add(mEdit = new JMenu("Edit"));
        menuBar.add(mHelp = new JMenu("Help"));

        mFile.add(itemNew = new JMenuItem("Tập tin mới"));
        mFile.addSeparator();
        mFile.add(itemOpen = new JMenuItem("Mở tập tin"));
        mFile.add(itemSave = new JMenuItem("Lưu tập tin"));
        mFile.addSeparator();
        mFile.add(itemPrint = new JMenuItem("In ra máy in"));
        mFile.addSeparator();
        mFile.add(itemExit = new JMenuItem("Thoát"));

        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.ALT_DOWN_MASK));

        mEdit.add(itemCopy = new JMenuItem("Copy"));
        mEdit.add(itemCut = new JMenuItem("Cut"));
        mEdit.add(itemPaste = new JMenuItem("Paste"));

        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));

        mHelp.add(itemAbout = new JMenuItem("About"));

        tpContent = new JTextPane();
        pnMain.add(new JScrollPane(tpContent), BorderLayout.CENTER);

        lblStatus = new JLabel("Thông báo");
        pnMain.add(lblStatus, BorderLayout.SOUTH);

        itemNew.addActionListener(this);
        itemOpen.addActionListener(this);
        itemSave.addActionListener(this);
        itemPrint.addActionListener(this);
        itemExit.addActionListener(this);
        itemCopy.addActionListener(this);
        itemCut.addActionListener(this);
        itemPaste.addActionListener(this);
        itemAbout.addActionListener(this);
    }

    public static void main(String[] args) {
        new Notepad().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(itemNew)) {
            lblStatus.setText("btn new");
        } else if (o.equals(itemOpen)) {
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    // lấy đường dẫn của file được chọn
                    String selFile = fc.getSelectedFile().getAbsolutePath();
                    Scanner sc = new Scanner(new FileInputStream(selFile));
                    lblStatus.setText("Opened: " + selFile);
                    String line = "";
                    while (sc.hasNextLine())
                        line += sc.nextLine() + "\n";
                    tpContent.setText(line);
                    sc.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (o.equals(itemSave)) {
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    String selFile = fc.getSelectedFile().getAbsolutePath();
                    int isConfirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu lại file", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (isConfirm == JOptionPane.YES_OPTION) {
                        lblStatus.setText("Saved: " + selFile);
                        PrintWriter out = new PrintWriter(new FileOutputStream(selFile), true);
                        out.print(tpContent.getText());
                        out.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (o.equals(itemPrint)) {
            try {
                MessageFormat header = new MessageFormat("Header Print");
                MessageFormat footer = new MessageFormat("Footer Print");
                tpContent.print(header, footer, true, null, null, true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (o.equals(itemExit)) {
            int isConfirm = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát notepad này?", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            if (isConfirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (o.equals(itemCopy)) {
            String text = tpContent.getSelectedText();
            tpContent.copy();
            lblStatus.setText("Copy: " + text);
        } else if (o.equals(itemCut)) {
            String text = tpContent.getSelectedText();
            tpContent.cut();
            lblStatus.setText("Cut: " + text);
        } else if (o.equals(itemPaste)) {
            String text = tpContent.getSelectedText();
            tpContent.paste();
            lblStatus.setText("Paste: " + text);
        } else if (o.equals(itemAbout)) {
            lblStatus.setText("About");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}

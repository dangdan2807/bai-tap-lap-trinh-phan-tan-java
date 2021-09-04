package Tuan1.Exercise4;

import javax.swing.*;
// import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class CopyFile extends JFrame implements ActionListener, MouseListener {
    private JTextField txtTo, txtFrom;
    private JButton btnCopy;
    // private JFileChooser fc = new JFileChooser();

    public CopyFile() {
        setTitle("Copying File");
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createFrom();
    }

    public void createFrom() {
        JPanel pnMain = new JPanel();
        getContentPane().add(pnMain, BorderLayout.CENTER);
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

        JPanel pnFrom = new JPanel();
        pnFrom.setPreferredSize(new Dimension(100, 40));
        pnFrom.setBorder(new TitledBorder(null, "From ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnMain.add(pnFrom);

        txtFrom = new JTextField();
        pnFrom.add(txtFrom);
        txtFrom.setColumns(40);

        JPanel pnTo = new JPanel();
        pnTo.setPreferredSize(new Dimension(100, 40));
        pnTo.setBorder(new TitledBorder(null, "To ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnMain.add(pnTo);

        txtTo = new JTextField();
        pnTo.add(txtTo);
        txtTo.setColumns(40);

        JPanel pnBtn = new JPanel();
        pnMain.add(pnBtn);

        btnCopy = new JButton("Copy");
        pnBtn.add(btnCopy);

        JPanel panel = new JPanel();
        pnMain.add(panel);

        txtFrom.addActionListener(this);
        txtTo.addActionListener(this);
        btnCopy.addActionListener(this);
        btnCopy.addMouseListener(this);
    }

    public static void main(String[] args) {
        new CopyFile().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(txtFrom)) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

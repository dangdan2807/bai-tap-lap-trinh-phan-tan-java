package lab2.codeCuaCo.btgson.exercise6;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class SQL2JsonTool extends JFrame {

	private static final String PW = "sapassword";
	private static final String USER = "sa";
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private JTextField tfDBName;
	private JTextField tfUser;
	private JPasswordField tfPass;
	private JButton btnConnect;
	private JList<String> listTable;
	private DefaultListModel<String> dataTableModel;
	private JButton btnToJson;
	private JButton btnToJsons;
	private Connection con;
	private DatabaseUtil dbUtil;

	public SQL2JsonTool() throws SQLException {

		setTitle("SQL to Json tool");
		setMinimumSize(new Dimension(800, 500));
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cp = getContentPane();
		JPanel pnlLeft, pnlRight;
		cp.add(pnlLeft = new JPanel(), BorderLayout.WEST);
		cp.add(pnlRight = new JPanel(), BorderLayout.CENTER);

		pnlLeft.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlLeft.setLayout(new BorderLayout());
		pnlLeft.setPreferredSize(new Dimension(400, 0));
		pnlLeft.add(new JScrollPane(list = new JList<String>(listModel = new DefaultListModel<String>())));
		list.setFixedCellHeight(30);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10),
				BorderFactory.createTitledBorder("Databases")));

		pnlRight.setLayout(new BorderLayout());
		Box b, b1, b2, b3, b4, b5;
		b = Box.createVerticalBox();
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));

		pnlRight.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		pnlRight.add(b, BorderLayout.NORTH);

		JLabel lblDBName, lblUser, lblPass;
		b1.add(lblDBName = new JLabel("Database Name: "));
		b1.add(tfDBName = new JTextField("Northwind"));
		b2.add(lblUser = new JLabel("User Name: "));
		tfUser = new JTextField("sa");
		b2.add(tfUser);
		b3.add(lblPass = new JLabel("Password: "));
		tfPass = new JPasswordField("sapassword");
		b3.add(tfPass);
		b4.add(btnConnect = new JButton("Connect"));
		b4.add(Box.createHorizontalGlue());

		lblUser.setPreferredSize(lblDBName.getPreferredSize());
		lblPass.setPreferredSize(lblDBName.getPreferredSize());

		listTable = new JList<String>(dataTableModel = new DefaultListModel<String>());
		listTable.setFixedCellHeight(30);
		listTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listTable.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10),
				BorderFactory.createTitledBorder("Table Names")));
		pnlRight.add(new JScrollPane(listTable));

		pnlRight.add(b5 = Box.createHorizontalBox(), BorderLayout.SOUTH);
		b5.add(btnToJson = new JButton("Convert To Json"));
		btnToJsons = new JButton("Convert To Jsons");
		b5.add(btnToJsons);
		b5.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		String url = "jdbc:sqlserver://localhost:1433;databaseName=AdgTest";
		con = getConnection(url, USER, PW);
		this.dbUtil = new DatabaseUtil(con);

		// Nạp danh sách database
		List<String> listdb = this.dbUtil.getDatabases();
		listdb.forEach(db -> listModel.addElement(db));

		list.addListSelectionListener((e) -> {
			String dbName = list.getSelectedValue();
			tfDBName.setText(dbName);
		});

		btnConnect.addActionListener((e) -> {
			String dbName = tfDBName.getText();
			String urlx = "jdbc:sqlserver://localhost:1433;databaseName=" + dbName;
			con = getConnection(urlx, USER, PW);
			dataTableModel.clear();

			try {
				List<String> tables = dbUtil.getTables(dbName);
				tables.forEach(tbl -> {
					dataTableModel.addElement(tbl);
				});
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		btnToJson.addActionListener((e) -> {
			String tblName = listTable.getSelectedValue();
			if (tblName != null) {
				try {
					dbUtil.export2json(con, tblName, "data/" + tblName + ".json");
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private Connection getConnection(String url, String user, String ps) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> {
			try {
				new SQL2JsonTool().setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}
}

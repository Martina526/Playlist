import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;

public class HellowWorld {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_9;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HellowWorld window = new HellowWorld();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HellowWorld() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JButton btnLoad = new JButton("load file");
		btnLoad.setBounds(18, 96, 92, 24);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//event handler for click the botton of "load file", intend to load file of playlist.txt
			}
		});
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlaylist = new JLabel("Playlist");
		lblPlaylist.setBounds(305, 6, 176, 84);
		lblPlaylist.setFont(new Font("Libian SC", Font.BOLD, 50));
		frame.getContentPane().add(lblPlaylist);
		frame.getContentPane().add(btnLoad);
		
		textField = new JTextField();
		textField.setBounds(123, 95, 130, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFind = new JLabel("Find Your Song");
		lblFind.setBounds(493, 82, 210, 24);
		lblFind.setFont(new Font("Nanum Pen Script", Font.PLAIN, 20));
		frame.getContentPane().add(lblFind);
		
		JLabel lblNameOfSong = new JLabel("Name of Song");
		lblNameOfSong.setBounds(412, 108, 117, 24);
		lblNameOfSong.setFont(new Font("Nanum Pen Script", Font.PLAIN, 20));
		frame.getContentPane().add(lblNameOfSong);
		
		textField_9 = new JTextField();
		textField_9.setBounds(516, 109, 144, 25);
		textField_9.setColumns(10);
		frame.getContentPane().add(textField_9);
		
		JButton btnLoadSingle = new JButton("load single");
		btnLoadSingle.setBounds(6, 132, 117, 29);
		frame.getContentPane().add(btnLoadSingle);
		
		JLabel lblTopPlaylists = new JLabel("Top 8 Playlists");
		lblTopPlaylists.setBounds(493, 133, 110, 24);
		lblTopPlaylists.setFont(new Font("Nanum Pen Script", Font.PLAIN, 20));
		frame.getContentPane().add(lblTopPlaylists);
		
		JButton btnRefresh = new JButton("refresh");
		btnRefresh.setBounds(615, 134, 88, 29);
		frame.getContentPane().add(btnRefresh);
		
		String[] columnNames = {"# of popularity","Name of Playlist"};
		Object[][] data = {
				{new Integer(1),"song#1"},
				{new Integer(2),"song#2"},
				{new Integer(3),"song#3"},
				{new Integer(4),"song#4"},
				{new Integer(5),"song#5"},
				{new Integer(6),"song#6"},
				{new Integer(7),"song#7"},
				{new Integer(8),"song#8"}};
		table = new JTable(data,columnNames);
		table.setEnabled(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(426, 173, 324, 128);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		frame.getContentPane().add(table);
		
		
		
		Object[] LoadName = {"Category","Name of Playlist/Songs"};
		Object[][] loaddata = {
				{"Playlist","Name"},
				{"song#1","1"},
				{"song#2","2"},
				{"song#3","3"},
				{"song#4","4"},
				{"song#5","5"},
				{"song#6","6"},
				{"song#7","7"},
				};
		JTable table2 = new JTable(loaddata,LoadName);
		table2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table2.setBackground(Color.LIGHT_GRAY);
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table2.setBounds(37, 173, 300, 128);
		table2.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table2.setFillsViewportHeight(true);
		TableColumn column20 = table.getColumnModel().getColumn(0);
		column20.setPreferredWidth(10);
		frame.getContentPane().add(table2);
		
		
		frame.setBounds(100, 100, 776, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

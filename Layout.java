
import java.awt.EventQueue;



import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JTextArea;

public class Layout {

	JFrame frame;
	private JTextField textField_9;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Layout window = new Layout();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Layout() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(41, 217, 215, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnLoad = new JButton("load file");
		btnLoad.setBounds(43, 169, 92, 24);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          
		          File filePath = fileChooser.getSelectedFile();
		          
		          
		        	try{
		        		  BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));StringBuffer stringBuffer = new StringBuffer();
			        	  String line ;
			        	  	
			        	  File file =new File("/Users/allen/Desktop/test.txt");
			        	  if(!file.exists()){
			        		  file.createNewFile();
			        	  }
		          	
			        	  FileWriter fw = new FileWriter(file,true);
			        	  BufferedWriter bw = new BufferedWriter(fw);
			        	  while((line =bufferedReader.readLine())!=null){
			        	 
			        		  stringBuffer.append(line);
			        		  System.out.println(line);
			        		  bw.write(line);
			        		  bw.write("\n");
				           
			        	  }
			        	  bw.close();
		          	  
		        	} catch(IOException e1){
		        		e1.printStackTrace();	
		        	
		        	}
		        	try{
						LineNumberReader  lnr = new LineNumberReader(new FileReader(new File("/Users/allen/Desktop/test.txt")));
						lnr.skip(Long.MAX_VALUE);
		      		  	System.out.print(String.valueOf(lnr.getLineNumber()-1));
		      		  	int num=lnr.getLineNumber();
		      		  	if(num<=1024){
		      		  	lblNewLabel.setText("total "+String.valueOf(lnr.getLineNumber())+" playlist(s) in processing");
		      		    lblNewLabel.setVisible(true);
		      		    lnr.close();
		      		  	}
		      		  	else{
		      		  	lblNewLabel.setText("total "+"1024"+" playlist(s) in processing");
		      		    lblNewLabel.setVisible(true);
		      		    lnr.close();
		      		  	}
		      		  		
		      		
						
					}catch(IOException e3){
		        		e3.printStackTrace();	
		        	
		        	}
		            
		         }
		        
		        }
				
			}
		);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlaylist = new JLabel("Playlist");
		lblPlaylist.setBounds(305, 6, 176, 84);
		lblPlaylist.setFont(new Font("Libian SC", Font.BOLD, 50));
		frame.getContentPane().add(lblPlaylist);
		frame.getContentPane().add(btnLoad);
		     
		
		
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
		
		JTextArea txtrPleaseInputAs = new JTextArea();
		txtrPleaseInputAs.setToolTipText("Please input as format: Playlist \\t Popularity(integer)");
		txtrPleaseInputAs.setBounds(43, 124, 362, 21);
		frame.getContentPane().add(txtrPleaseInputAs);
		
		JButton btnLoadSingle = new JButton("load single list");
		btnLoadSingle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					  
					  String single=txtrPleaseInputAs.getText();
		        	  StringBuffer stringBuffer = new StringBuffer();
		        	  
		        	  File file =new File("/Users/allen/Desktop/test.txt");
		        	  if(!file.exists()){
			          	   file.createNewFile();
			          	}
		        	  FileWriter fw = new FileWriter(file,true);
		        	  BufferedWriter bw = new BufferedWriter(fw);
		        	  
		        	 
		        		  stringBuffer.append(single);
		        		  bw.write(single);
		        		  bw.write("\n");
		        		  bw.close();
	        	} catch(IOException e2){
	        		e2.printStackTrace();	
	        	
	        	}
				
				
				try{
					LineNumberReader  lnr = new LineNumberReader(new FileReader(new File("/Users/allen/Desktop/test.txt")));
					lnr.skip(Long.MAX_VALUE);
	      		  	System.out.print(String.valueOf(lnr.getLineNumber()-1));
	      		  	int num=lnr.getLineNumber();
	      		  	if(num<=1024){
	      		  	lblNewLabel.setText("total "+String.valueOf(lnr.getLineNumber())+" playlist(s) in processing");
	      		    lblNewLabel.setVisible(true);
	      		    lnr.close();
	      		  	}
	      		  	else{
	      		  	lblNewLabel.setText("total "+"1024"+" playlist(s) in processing");
	      		    lblNewLabel.setVisible(true);
	      		    lnr.close();
	      		  	}
	      		  		
	      		
					
				}catch(IOException e3){
	        		e3.printStackTrace();	
	        	
	        	}
				
				
			}
			
		}
		);
		btnLoadSingle.setBounds(184, 167, 117, 29);
		frame.getContentPane().add(btnLoadSingle);
		
		
		JLabel lblTopPlaylists = new JLabel("Top 8 Playlists");
		lblTopPlaylists.setBounds(493, 133, 110, 24);
		lblTopPlaylists.setFont(new Font("Nanum Pen Script", Font.PLAIN, 20));
		frame.getContentPane().add(lblTopPlaylists);
		
		JButton btnRefresh = new JButton("refresh");
		btnRefresh.setBounds(615, 134, 88, 29);
		frame.getContentPane().add(btnRefresh);
		
		FileReader fr = 
				new FileReader("/Users/allen/Desktop/day00.txt");
		BufferedReader br = new BufferedReader(fr);
		String[] song = new String[8];
		String c;
		for (int i = 0; i < 8 && (c = br.readLine()) != null;i++){
			song[i] = c;		
		}
		
		
		
		String[] columnNames = {"# of popularity","Name of Playlist"};
		Object[][] data = {
				{new Integer(1),song[0]},
				{new Integer(2),song[1]},
				{new Integer(3),song[2]},
				{new Integer(4),song[3]},
				{new Integer(5),song[4]},
				{new Integer(6),song[5]},
				{new Integer(7),song[6]},
				{new Integer(8),song[7]}};
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
				{"single list","1"},
				
				};
		TableColumn column20 = table.getColumnModel().getColumn(0);
		column20.setPreferredWidth(10);
		
		
		
		
		
		
		frame.setBounds(100, 100, 776, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

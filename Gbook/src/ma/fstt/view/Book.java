package ma.fstt.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ma.fstt.dao.BaseBook;

public class Book extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField auteur;
	private JTextField annee;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book frame = new Book();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		
		getContentPane().setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(26, 29, 61, 16);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(26, 57, 130, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Auteur");
		lblNewLabel_1.setBounds(247, 29, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		auteur = new JTextField();
		auteur.setBounds(245, 57, 130, 26);
		contentPane.add(auteur);
		auteur.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Anne");
		lblNewLabel_2.setBounds(26, 86, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		annee = new JTextField();
		annee.setBounds(36, 105, 130, 26);
		contentPane.add(annee);
		annee.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// code model 
				

				BaseBook baseBook;
				try {
					baseBook = new BaseBook();
					baseBook.save(new ma.fstt.model.Book(0, name.getText() , auteur.getText() , annee.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(295, 116, 117, 29);
		contentPane.add(btnNewButton);
		
		
		
		
		Object [] columns = { "name" , "auteur" , "annee"};
		
		Object [][] rows = { };
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(rows , columns);
		
		BaseBook baseBook;
		try {
			baseBook = new BaseBook();
			
			List<ma.fstt.model.Book> malist = baseBook.getAll() ;
			
			for(int i=0; i< malist.size() ; i++) {
				
			
				defaultTableModel.addRow(new Object[] {malist.get(i).getName()  ,malist.get(i).getAuteur(), malist.get(i).getAnnee()});
				
				
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
		
		table = new JTable(defaultTableModel);
		table.setBounds(46, 176, 373, 76);
		contentPane.add(table);
		
		
		
		
	}
}

package PopUps;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class AddMethodW {
	
	public AddMethodW() {
		
	}
	
	private static JTextField classNameBox;
	private static JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		JFrame frmJamblAdd = new JFrame("JAMBL - Add Class");
		frmJamblAdd.setTitle("JAMBL - Add Method");
		frmJamblAdd.setBounds(100, 100, 576, 225);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		
		JLabel lblAddMethod = new JLabel("Enter the name and type for a method to add and select a class");
		lblAddMethod.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddMethod.setBounds(10, 10, 542, 29);
		frmJamblAdd.getContentPane().add(lblAddMethod);
		
		JLabel lblClassName = new JLabel("Method Name");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(27, 78, 106, 18);
		frmJamblAdd.getContentPane().add(lblClassName);
		
		classNameBox = new JTextField();
		lblClassName.setLabelFor(classNameBox);
		classNameBox.setBounds(132, 80, 227, 19);
		frmJamblAdd.getContentPane().add(classNameBox);
		classNameBox.setColumns(10);
		frmJamblAdd.setVisible(true);
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Add Class Button
		JButton btnAddMethod = new JButton("Add Method");
		btnAddMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddMethod.setBounds(85, 136, 132, 21);
		frmJamblAdd.getContentPane().add(btnAddMethod);
		btnAddMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJamblAdd.dispose();
			}
		});
		
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(227, 136, 132, 21);
		frmJamblAdd.getContentPane().add(btnCancel);
		
		JLabel lblMethodType = new JLabel("Method Type:");
		lblMethodType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethodType.setBounds(27, 101, 106, 19);
		frmJamblAdd.getContentPane().add(lblMethodType);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(132, 103, 227, 19);
		frmJamblAdd.getContentPane().add(textField);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass.setBounds(30, 49, 45, 13);
		frmJamblAdd.getContentPane().add(lblClass);
		
		JComboBox comboBoxClasses = new JComboBox();
		comboBoxClasses.setBounds(85, 47, 132, 21);
		frmJamblAdd.getContentPane().add(comboBoxClasses);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJamblAdd.dispose();
			}
		});
		
		
	}
}

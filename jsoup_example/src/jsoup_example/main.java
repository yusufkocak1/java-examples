package jsoup_example;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class main extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel label;

	public main() {
		setSize(500, 500);
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(73, 11, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(73, 41, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("login");
		btnNewButton.setBounds(73, 72, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				label.setText(new jsoup().login(textField.getText(),
						textField_1.getText()));
			}
		});
		getContentPane().add(btnNewButton);

		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 11, 59, 20);
		getContentPane().add(lblEmail);

		lblPassword = new JLabel("password");
		lblPassword.setBounds(10, 45, 59, 15);
		getContentPane().add(lblPassword);

		label = new JLabel("");
		label.setBounds(180, 11, 229, 50);
		getContentPane().add(label);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main().setVisible(true);

	}
}

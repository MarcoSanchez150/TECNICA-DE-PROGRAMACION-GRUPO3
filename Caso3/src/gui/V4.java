package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Ejercicio;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V4 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtS;
	private JButton btnNewButton;
	private JTextField txtnum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V4 frame = new V4();
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
	public V4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			txtS = new JTextArea();
			txtS.setBounds(58, 126, 308, 112);
			contentPane.add(txtS);
		}
		{
			btnNewButton = new JButton("Procesar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(173, 24, 76, 23);
			contentPane.add(btnNewButton);
		}
		{
			txtnum = new JTextField();
			txtnum.setBounds(58, 25, 86, 20);
			contentPane.add(txtnum);
			txtnum.setColumns(10);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		double num=Double.parseDouble(txtnum.getText());
		Ejercicio ej= new Ejercicio(num);
		
		txtS.append("El numero es: "+num);
		txtS.append("\n"+ej.Resuelto());
		
	}
}

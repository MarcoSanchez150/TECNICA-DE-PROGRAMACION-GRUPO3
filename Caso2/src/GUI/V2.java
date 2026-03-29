package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Triangulo;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtS;
	private JTextField txtBase;
	private JTextField txtAltura;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V2 frame = new V2();
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
	public V2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			txtS = new JTextArea();
			txtS.setBounds(21, 96, 372, 134);
			contentPane.add(txtS);
		}
		{
			txtBase = new JTextField();
			txtBase.setBounds(44, 11, 86, 20);
			contentPane.add(txtBase);
			txtBase.setColumns(10);
		}
		{
			txtAltura = new JTextField();
			txtAltura.setBounds(44, 42, 86, 20);
			contentPane.add(txtAltura);
			txtAltura.setColumns(10);
		}
		{
			btnNewButton = new JButton("Procesar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(170, 10, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Limpiar");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(170, 41, 89, 23);
			contentPane.add(btnNewButton_1);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		txtAltura.setText("");
		txtBase.setText("");
		txtS.setText("");
		txtBase.grabFocus();//ubica el cursor 
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		double base= Double.parseDouble(txtBase.getText());
		double altura= Double.parseDouble(txtAltura.getText());
		Triangulo tr=new Triangulo(base, altura);
		
		
		txtS.append("La base es: " +base);
		txtS.append("\nLa altura es: " +altura);
		txtS.append("\nEl area es: " +tr.Area());
		txtS.append("\nNuevos cambios: ");
		tr.setAltura(tr.getAltura()-3);
		tr.setBase(tr.getBase()+2);
		txtS.append("\nLa base es: "+tr.getBase());
		txtS.append("\nLa altura es: " +tr.getAltura());
		txtS.append("\nEl area es: " +tr.Area());

		
	}
}

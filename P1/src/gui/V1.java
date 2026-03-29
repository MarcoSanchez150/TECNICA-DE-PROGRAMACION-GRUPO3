package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglo.ArregloEstudiante;
import clase.Estudiante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtCod;
	private JTextField txtNom;
	private JTextField txtN1;
	private JTextField txtN2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
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
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Codigo");
			lblNewLabel.setBounds(10, 11, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nombre");
			lblNewLabel_1.setBounds(141, 11, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Nota 1");
			lblNewLabel_2.setBounds(10, 48, 46, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Nota 2");
			lblNewLabel_3.setBounds(141, 48, 46, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			txtCod = new JTextField();
			txtCod.setBounds(45, 8, 86, 20);
			contentPane.add(txtCod);
			txtCod.setColumns(10);
		}
		{
			txtNom = new JTextField();
			txtNom.setBounds(181, 8, 86, 20);
			contentPane.add(txtNom);
			txtNom.setColumns(10);
		}
		{
			txtN1 = new JTextField();
			txtN1.setBounds(45, 45, 86, 20);
			contentPane.add(txtN1);
			txtN1.setColumns(10);
		}
		{
			txtN2 = new JTextField();
			txtN2.setBounds(181, 45, 86, 20);
			contentPane.add(txtN2);
			txtN2.setColumns(10);
		}
		{
			btnNewButton = new JButton("Reportar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnNewButton_actionPerformed(e);
				}
			});
			btnNewButton.setBounds(10, 82, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Adicionar");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(109, 82, 89, 23);
			contentPane.add(btnNewButton_1);
		}
		{
			btnNewButton_2 = new JButton("Eliminar");
			btnNewButton_2.addActionListener(this);
			btnNewButton_2.setBounds(208, 82, 89, 23);
			contentPane.add(btnNewButton_2);
		}
		{
			btnNewButton_3 = new JButton("Buscar");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnNewButton_3_actionPerformed(e);
				}
			});
			btnNewButton_3.setBounds(307, 82, 89, 23);
			contentPane.add(btnNewButton_3);
		}
		{
			btnNewButton_4 = new JButton("Modificar");
			btnNewButton_4.addActionListener(this);
			btnNewButton_4.setBounds(406, 82, 89, 23);
			contentPane.add(btnNewButton_4);
		}
		{
			txtS = new JTextArea();
			txtS.setBounds(10, 116, 505, 188);
			contentPane.add(txtS);
		}
Listado();
	}
	ArregloEstudiante ae=new ArregloEstudiante();
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		txtS.setText("");
		Listado();
		Imprimir("la cantidad de estudiantes es: "+ae.Tamaño());
		Imprimir("Promedio general: "+ae.PromedioGeneral());
	}
	void Imprimir(String s) {
		txtS.append(s+"\n");
	}
	void Listado() {
		Imprimir("Codigo\tNombre\tNota 1\tNota 2\tPromedio");
		for (int i = 0; i < ae.Tamaño(); i++) {
			Imprimir(""+ae.Obtener(i).getCod() +"\t"+ae.Obtener(i).getNom() 
			+"\t"+ae.Obtener(i).getN1()+"\t"+ae.Obtener(i).getN2() 
			+"\t"+ae.Obtener(i).Promedio());
		}	
		
	}
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		txtS.setText("");
		Estudiante es=ae.Buscar(LeerCodigo());
		if(es!=null) {
			Imprimir("Codigo\tNombre\tNota 1\tNota 2\tPromedio");
			Imprimir(es.getCod()+"\t"+es.getNom()+"\t"+es.getN1()+"\t"
			+es.getN2()+"\t"+es.Promedio());
		}
		else JOptionPane.showMessageDialog(this,"No existe codigo");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_4) {
			do_btnNewButton_4_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		Estudiante es=ae.Buscar(LeerCodigo());
		if(es==null) {
			Estudiante es1=new Estudiante(LeerCodigo(),LeerNombre() ,LeerN1() ,LeerN2()); 
			ae.Adicionar(es1);
		}
		else Mensaje("Existe codigo");
	}
	void Mensaje(String s) {
		JOptionPane.showMessageDialog(this,s);
	}
	int LeerCodigo() {
		return Integer.parseInt(txtCod.getText());
	}
	String LeerNombre() {
		return txtNom.getText();
	}
	double LeerN1() {
		return Double.parseDouble(txtN1.getText());
	}
	double LeerN2() {
		return Double.parseDouble(txtN2.getText());
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		Estudiante es=ae.Buscar(LeerCodigo());
		if(es!=null)ae.Eliminar(es);
		else Mensaje("No existe el codigo");
	}
	protected void do_btnNewButton_4_actionPerformed(ActionEvent e) {
		Estudiante es=ae.Buscar(LeerCodigo());
		if(es!=null) {
			es.setNom(LeerNombre());
			es.setN1(LeerN1());
			es.setN2(LeerN2());
		}
		else Mensaje("El codigo no existe");
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 268));
		setResizable(false);
		setContentPane(contentPane);
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel LU = new JLabel("LU");
		LU.setBounds(10, 10, 45, 13);
		tabInformation.add(LU);
		
		JLabel Apellido = new JLabel("Apellido");
		Apellido.setBounds(10, 45, 64, 13);
		tabInformation.add(Apellido);
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setBounds(10, 80, 45, 13);
		tabInformation.add(Nombre);
		
		JLabel mail = new JLabel("E-mail");
		mail.setBounds(10, 115, 45, 13);
		tabInformation.add(mail);
		
		JLabel Github = new JLabel("Github URL");
		Github.setBounds(10, 150, 79, 13);
		tabInformation.add(Github);
		
		String fecha= LocalDate.now().toString();
		String hora= LocalTime.now().toString().substring(0,8);
		
		JLabel cuando = new JLabel();
		cuando.setText("Esta ventana fue generada el "+fecha+" a las "+hora);
		contentPane.add(cuando, BorderLayout.SOUTH);
		
		textField = new JTextField();
		textField.setText(Integer.toString(studentData.getId()));
		textField.setBounds(87, 7, 328, 19);
		tabInformation.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(studentData.getLastName());
		textField_1.setColumns(10);
		textField_1.setBounds(87, 42, 328, 19);
		tabInformation.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText(studentData.getFirstName());
		textField_2.setColumns(10);
		textField_2.setBounds(87, 77, 328, 19);
		tabInformation.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText(studentData.getMail());
		textField_3.setColumns(10);
		textField_3.setBounds(87, 112, 328, 19);
		tabInformation.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText(studentData.getGithubURL());
		textField_4.setColumns(10);
		textField_4.setBounds(87, 147, 328, 19);
		tabInformation.add(textField_4);
		
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		
		
		JLabel foto = new JLabel("");
		foto.setVerticalAlignment(SwingConstants.BOTTOM);
		ImageIcon img=new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		img=new ImageIcon(img.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		foto.setIcon(img);
		
		panel.add(foto, BorderLayout.SOUTH);
	}
}

package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hash.Hash;
import modelo.sqlusuarios;
import modelo.usuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuarios;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmaPassword;
	private JTextField txtNombre;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro frame = new registro();
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
	public registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(27, 46, 40, 14);
		panel.add(lblUsuario);
		
		txtUsuarios = new JTextField();
		txtUsuarios.setBounds(137, 43, 108, 20);
		panel.add(txtUsuarios);
		txtUsuarios.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(27, 77, 50, 14);
		panel.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(137, 74, 108, 20);
		panel.add(txtPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
		lblConfirmarPassword.setBounds(27, 114, 100, 14);
		panel.add(lblConfirmarPassword);
		
		txtConfirmaPassword = new JPasswordField();
		txtConfirmaPassword.setBounds(137, 111, 108, 20);
		panel.add(txtConfirmaPassword);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(27, 173, 46, 14);
		panel.add(lblCorreo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(27, 139, 46, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(137, 142, 108, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(137, 170, 108, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				sqlusuarios modSql = new sqlusuarios();
				usuarios mod = new usuarios();
				
				String pass = new String(txtPassword.getPassword());
				String passCon = new String(txtConfirmaPassword.getPassword());
				
				if(pass.equals(passCon)) {
					
					String nuevoPass = Hash.sha1(pass);
					
					mod.setUsuario(txtUsuarios.getText());
					mod.setPassword(nuevoPass);
					mod.setNombre(txtNombre.getText());
					mod.setCorreo(txtConfirmaPassword.getText());
					mod.setIdtipo(2);
					
					if(modSql.registrar(mod)) {
						JOptionPane.showMessageDialog(null, "Registro Guardado" );
					}else {
						JOptionPane.showMessageDialog(null, "Error al guardar" );
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden" );
					
				}
				
				
				
			}
		});
		btnRegistrar.setBounds(156, 217, 89, 23);
		panel.add(btnRegistrar);
	}
}

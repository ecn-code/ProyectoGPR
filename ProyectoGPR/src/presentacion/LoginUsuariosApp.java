package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import excepciones.DAOExcepcion;
import excepciones.DominioExcepcion;

import logica.Controlador;
import logica.Jefe;
import logica.Maestro;
import logica.Operario;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class LoginUsuariosApp extends javax.swing.JFrame {
	private JTextField jTextUsuario;
	private JButton jButtonLogin;
	private JTextField jTextPass;
	static LoginUsuariosApp inst;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inst = new LoginUsuariosApp();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LoginUsuariosApp() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jTextUsuario = new JTextField();
				getContentPane().add(jTextUsuario);
				jTextUsuario.setText("usuario");
				jTextUsuario.setBounds(122, 100, 145, 23);
			}
			{
				jTextPass = new JTextField();
				getContentPane().add(jTextPass);
				jTextPass.setText("contraseña");
				jTextPass.setBounds(122, 150, 145, 23);
			}
			{
				jButtonLogin = new JButton();
				getContentPane().add(jButtonLogin);
				jButtonLogin.setText("Entrar");
				jButtonLogin.setBounds(165, 196, 45, 23);
				jButtonLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButtonLogin.actionPerformed, event="+evt);
						//TODO add your code for jButtonLogin.actionPerformed
						Controlador control;
						try {
							control = Controlador.dameControlador();
							final String usuario = jTextUsuario.getText();
							final String pass = jTextPass.getText();
							Operario operario = control.loguearOperario(usuario,pass);
							
							if(operario!=null) {
								GestionIncidenciasOperarioApp.main(operario);
								dispose();
							}
							
							Maestro maestro = control.loguearMaestro(usuario,pass);
							if(maestro!=null) {
								GestionIncidenciasMaestroApp.main(maestro);
								dispose();
							}
							
							Jefe jefe = control.loguearJefe(usuario,pass);
							if(jefe!=null) {
								//GestionIncidenciasMaestroApp.main(maestro);
								dispose();
							}
							
						
							
						} catch (DominioExcepcion e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (DAOExcepcion e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
				});
			}
			pack();
			setSize(500, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	public void cerrar() {
		dispose();
	}

}

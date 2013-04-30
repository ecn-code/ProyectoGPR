package presentacion;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
public class AvisoIncidenciaUsuarioApp extends javax.swing.JFrame {

	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JLabel jLabelNombreUsuario;
	private JTextField jTextFieldNombreIncidencia;
	private JLabel jLabelNombreIncidencia;
	private JButton jButtonLimpiar;
	private JButton jButtonEnviar;
	private JButton jButtonCancelar;
	private JTextPane jTextPanePrincipal;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem closeFileMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AvisoIncidenciaUsuarioApp inst = new AvisoIncidenciaUsuarioApp();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AvisoIncidenciaUsuarioApp() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setTitle("Aviso de incidencia - Usuario");
				getContentPane().setLayout(null);
				this.setState(Frame.ICONIFIED);
				this.setPreferredSize(new java.awt.Dimension(615, 474));
				this.setResizable(false);
				{
					jButtonEnviar = new JButton();
					jButtonEnviar.setLayout(null);
					jButtonEnviar.setText("Enviar");
				}
				{
					jButtonCancelar = new JButton();
					getContentPane().add(jButtonCancelar, new AnchorConstraint(901, 474, 975, 291, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					getContentPane().add(jButtonEnviar, new AnchorConstraint(901, 720, 975, 537, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButtonEnviar.setBounds(249, 381, 96, 26);
					jButtonCancelar.setLayout(null);
					jButtonCancelar.setText("Salir");
					jButtonCancelar.setBounds(440, 381, 96, 26);
					jButtonCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonCancelarActionPerformed(evt);
						}
					});
				}
				{
					jTextPanePrincipal = new JTextPane();
					getContentPane().add(jTextPanePrincipal, new AnchorConstraint(202, 1000, 866, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jTextPanePrincipal.setLayout(null);
					jTextPanePrincipal.setText("Escribe la incidencia, máximo 300 caracteres...");
					jTextPanePrincipal.setMargin(new java.awt.Insets(3, 3, 3, 3));
					jTextPanePrincipal.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jTextPanePrincipal.setBounds(12, 95, 585, 265);
				}
				{
					jButtonLimpiar = new JButton();
					getContentPane().add(jButtonLimpiar, new AnchorConstraint(901, 474, 975, 291, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButtonLimpiar.setLayout(null);
					jButtonLimpiar.setText("Limpiar");
					jButtonLimpiar.setBounds(58, 381, 96, 26);
					jButtonLimpiar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonLimpiarActionPerformed(evt);
						}
					});
				}
				{
					jLabelNombreIncidencia = new JLabel();
					getContentPane().add(jLabelNombreIncidencia);
					jLabelNombreIncidencia.setText("Escriba un nombre para la incidencia:");
					jLabelNombreIncidencia.setBounds(12, 54, 280, 29);
				}
				{
					jTextFieldNombreIncidencia = new JTextField();
					getContentPane().add(jTextFieldNombreIncidencia);
					jTextFieldNombreIncidencia.setBounds(246, 53, 350, 25);
					jTextFieldNombreIncidencia.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					jLabelNombreUsuario = new JLabel();
					getContentPane().add(jLabelNombreUsuario);
					jLabelNombreUsuario.setText("Nombre de Usuario");
					jLabelNombreUsuario.setBounds(246, 12, 198, 22);
				}
			}
			this.setSize(615, 474);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Archivo");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("Nuevo");
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Abrir");
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
						saveMenuItem.setText("Guardar");
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
						saveAsMenuItem.setText("Guardar como");
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
						closeFileMenuItem.setText("Cerrar");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Salir");
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Editar");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Cortar");
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Copiar");
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Pegar");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Borrar");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Ayuda");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Contenidos");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButtonCancelarActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonCancelar.actionPerformed, event="+evt);
		//TODO add your code for jButtonCancelar.actionPerformed
		System.exit(0);
	}
	
	private void jButtonLimpiarActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonLimpiar.actionPerformed, event="+evt);
		//TODO add your code for jButtonLimpiar.actionPerformed
		jTextPanePrincipal.setText("");
	}

}

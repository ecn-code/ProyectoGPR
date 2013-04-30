package presentacion;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public class GestionIncidenciasMaestroApp extends javax.swing.JFrame {

	private JMenuItem helpMenuItem;
	private JLabel jLabeiListadoAvisos;
	private JButton jButtonFiltrar;
	private JLabel jLabelHasta;
	private JLabel jLabelDesde;
	private JTextField jTextFieldHasta;
	private JTextField jTextFieldDesde;
	private JMenu jMenu5;
	private JButton jButtonAsignarOperario;
	private JLabel jLabelAsignarOperario;
	private JComboBox jComboBoxAsignarOperario;
	private JPanel jPanelAsignarOperario;
	private JButton jButtonEliminar;
	private JButton jButtonRegistrar;
	private JButton jButtonSalir;
	private JTable jTableIncidencias;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuBar jMenuBar1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GestionIncidenciasMaestroApp inst = new GestionIncidenciasMaestroApp();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GestionIncidenciasMaestroApp() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("Gestión de incidencias - Maestro de Área");
			this.setResizable(false);
			{
				TableModel jTableAvisosIncidenciaModel = 
					new DefaultTableModel(
							new String[][] { {}, {}, {}, {}},
							new String[] { "ID", "Nombre", "Descripcion", "FechaEntrada" });
				jTableIncidencias = new JTable();
				getContentPane().add(jTableIncidencias);
				jTableIncidencias.setModel(jTableAvisosIncidenciaModel);
				jTableIncidencias.setBounds(23, 89, 540, 306);
				jTableIncidencias.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			{
				jTextFieldDesde = new JTextField();
				getContentPane().add(jTextFieldDesde);
				jTextFieldDesde.setBounds(93, 33, 124, 23);
			}
			{
				jTextFieldHasta = new JTextField();
				getContentPane().add(jTextFieldHasta);
				jTextFieldHasta.setBounds(286, 33, 124, 23);
			}
			{
				jLabelDesde = new JLabel();
				getContentPane().add(jLabelDesde);
				jLabelDesde.setText("Desde:");
				jLabelDesde.setBounds(45, 36, 57, 16);
			}
			{
				jLabelHasta = new JLabel();
				getContentPane().add(jLabelHasta);
				jLabelHasta.setText("Hasta:");
				jLabelHasta.setBounds(239, 36, 57, 16);
			}
			{
				jButtonFiltrar = new JButton();
				getContentPane().add(jButtonFiltrar);
				jButtonFiltrar.setText("Filtrar");
				jButtonFiltrar.setBounds(438, 33, 102, 23);
			}
			{
				jLabeiListadoAvisos = new JLabel();
				getContentPane().add(jLabeiListadoAvisos);
				jLabeiListadoAvisos.setText("Listado de incidencias:");
				jLabeiListadoAvisos.setBounds(24, 67, 205, 16);
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(694, 375, 102, 23);
				jButtonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonSalirActionPerformed(evt);
					}
				});
			}
			{
				jButtonRegistrar = new JButton();
				getContentPane().add(jButtonRegistrar);
				jButtonRegistrar.setText("Registrar Resuelta");
				jButtonRegistrar.setBounds(643, 64, 153, 23);
			}
			{
				jButtonEliminar = new JButton();
				getContentPane().add(jButtonEliminar);
				jButtonEliminar.setText("Solicitar Material");
				jButtonEliminar.setBounds(643, 32, 153, 23);
			}
			{
				jPanelAsignarOperario = new JPanel();
				getContentPane().add(jPanelAsignarOperario);
				jPanelAsignarOperario.setBounds(587, 139, 208, 89);
				jPanelAsignarOperario.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				{
					jLabelAsignarOperario = new JLabel();
					jPanelAsignarOperario.add(jLabelAsignarOperario);
					jLabelAsignarOperario.setText("Asigna un operario:");
				}
				{
					ComboBoxModel jComboBoxAsignarOperarioModel = 
						new DefaultComboBoxModel(
								new String[] { "Operario 01", "Operario 02", "Operario 03" });
					jComboBoxAsignarOperario = new JComboBox();
					jPanelAsignarOperario.add(jComboBoxAsignarOperario);
					jComboBoxAsignarOperario.setModel(jComboBoxAsignarOperarioModel);
					jComboBoxAsignarOperario.setPreferredSize(new java.awt.Dimension(180, 23));
				}
				{
					jButtonAsignarOperario = new JButton();
					jPanelAsignarOperario.add(jButtonAsignarOperario);
					jButtonAsignarOperario.setText("Asignar");
					jButtonAsignarOperario.setPreferredSize(new java.awt.Dimension(96, 23));
				}
			}
			this.setSize(820, 470);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Listados");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Listado de incidencias resueltas");
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Listado de incidencias en curso");
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
	
	private void jButtonSalirActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonSalir.actionPerformed, event="+evt);
		//TODO add your code for jButtonSalir.actionPerformed
		System.exit(0);
	}

}

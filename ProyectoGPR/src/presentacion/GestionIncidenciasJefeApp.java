package presentacion;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
public class GestionIncidenciasJefeApp extends javax.swing.JFrame {

	private JMenuItem helpMenuItem;
	private JLabel jLabeiListadoAvisos;
	private JButton jButtonFiltrar;
	private JLabel jLabelHasta;
	private JLabel jLabelDesde;
	private JTextField jTextFieldHasta;
	private JTextField jTextFieldDesde;
	private JMenu jMenu5;
	private JButton jButtonEliminar;
	private JButton jButtonClasificar;
	private JButton jButtonSalir;
	private JTable jTableAvisosIncidencia;
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
				GestionIncidenciasJefeApp inst = new GestionIncidenciasJefeApp();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GestionIncidenciasJefeApp() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setTitle("Gestión de incidencias - Jefe Servicio Mantenimiento");
			this.setResizable(false);
			{
				TableModel jTableAvisosIncidenciaModel = 
					new DefaultTableModel(
							new String[][] {{}, {}, {}},
							new String[] { "ID", "FechaEntrada", "Descripcion" });
				jTableAvisosIncidencia = new JTable();
				getContentPane().add(jTableAvisosIncidencia);
				jTableAvisosIncidencia.setModel(jTableAvisosIncidenciaModel);
				jTableAvisosIncidencia.setBounds(28, 66, 540, 245);
				jTableAvisosIncidencia.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				//TableColumn columna = new TableColumn();;
				//jTableAvisosIncidencia.addColumn(columna);
			}
			{
				jTextFieldDesde = new JTextField();
				getContentPane().add(jTextFieldDesde);
				jTextFieldDesde.setBounds(101, 12, 124, 23);
			}
			{
				jTextFieldHasta = new JTextField();
				getContentPane().add(jTextFieldHasta);
				jTextFieldHasta.setBounds(294, 12, 124, 23);
			}
			{
				jLabelDesde = new JLabel();
				getContentPane().add(jLabelDesde);
				jLabelDesde.setText("Desde:");
				jLabelDesde.setBounds(48, 15, 57, 16);
			}
			{
				jLabelHasta = new JLabel();
				getContentPane().add(jLabelHasta);
				jLabelHasta.setText("Hasta:");
				jLabelHasta.setBounds(242, 15, 57, 16);
			}
			{
				jButtonFiltrar = new JButton();
				getContentPane().add(jButtonFiltrar);
				jButtonFiltrar.setText("Filtrar");
				jButtonFiltrar.setBounds(441, 12, 102, 23);
			}
			{
				jLabeiListadoAvisos = new JLabel();
				getContentPane().add(jLabeiListadoAvisos);
				jLabeiListadoAvisos.setText("Listado de avisos de incidencias:");
				jLabeiListadoAvisos.setBounds(28, 44, 205, 16);
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(585, 288, 102, 23);
				jButtonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonSalirActionPerformed(evt);
					}
				});
			}
			{
				jButtonClasificar = new JButton();
				getContentPane().add(jButtonClasificar);
				jButtonClasificar.setText("Clasificar");
				jButtonClasificar.setBounds(585, 12, 102, 23);
				jButtonClasificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonClasificarActionPerformed(evt);
					}
				});
			}
			{
				jButtonEliminar = new JButton();
				getContentPane().add(jButtonEliminar);
				jButtonEliminar.setText("Eliminar");
				jButtonEliminar.setBounds(585, 46, 102, 23);
			}
			this.setSize(715, 389);
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
	
	private void jButtonClasificarActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonClasificar.actionPerformed, event="+evt);
		//TODO add your code for jButtonClasificar.actionPerformed
		ClasificarIncidenciaJefejDialog dialogoClasificar = new ClasificarIncidenciaJefejDialog(this);
		dialogoClasificar.setModal(true);
		dialogoClasificar.setVisible(true);

	}
	
	private void jButtonSalirActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonSalir.actionPerformed, event="+evt);
		//TODO add your code for jButtonSalir.actionPerformed
		System.exit(0);
	}

}

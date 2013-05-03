package presentacion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import logica.Area;
import logica.Controlador;
import logica.Incidencia;


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
public class GestionIncidenciasOperarioApp extends javax.swing.JFrame {

	private Controlador control;
	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JButton jButtonConsultarMaterial;
	private JLabel jLabelSeleccionaIncidencia;
	private JTable jTableOrdenesTrabajo;
	private JScrollPane jScrollPaneOrdenesTrabajo;
	private JButton jButtonConsutarIncidencia;
	private JButton jButtonSalir;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GestionIncidenciasOperarioApp inst = new GestionIncidenciasOperarioApp();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GestionIncidenciasOperarioApp() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		/*try {
			
			ArrayList<Incidencia> incidencia = new ArrayList<Incidencia>();
			
			try{ 	   
				this.control = Controlador.dameControlador(); 
				
				   
			}catch (Exception e){ 
				JOptionPane.showMessageDialog( 
				this,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE); 
			}
			
			String[] elementosComboBox = new String[areas.size()];
			
			for(int i = 0; i < areas.size(); i++){
				Area area = areas.get(i);
				elementosComboBox[i]= area.getNombre();	
			}//fin bucle for*/
		try {
			{
				this.setTitle("Gestión de incidencias - Operario");
				getContentPane().setLayout(null);
				this.setResizable(false);
				{
					jLabelSeleccionaIncidencia = new JLabel();
					getContentPane().add(jLabelSeleccionaIncidencia);
					jLabelSeleccionaIncidencia.setText("Selecciona incidencia:");
					jLabelSeleccionaIncidencia.setBounds(18, 8, 158, 16);
				}
				{
					jButtonConsultarMaterial = new JButton();
					getContentPane().add(jButtonConsultarMaterial);
					jButtonConsultarMaterial.setText("Consultar Material");
					jButtonConsultarMaterial.setBounds(233, 70, 170, 23);
				}
				{
					jButtonSalir = new JButton();
					getContentPane().add(jButtonSalir);
					jButtonSalir.setText("Salir");
					jButtonSalir.setBounds(306, 182, 97, 23);
					jButtonSalir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonSalirActionPerformed(evt);
						}
					});
				}
				{
					jButtonConsutarIncidencia = new JButton();
					getContentPane().add(jButtonConsutarIncidencia);
					jButtonConsutarIncidencia.setText("Consultar Incidencia");
					jButtonConsutarIncidencia.setBounds(233, 36, 170, 23);
					jButtonConsutarIncidencia.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonConsutarIncidenciaActionPerformed(evt);
						}
					});
				}
				{
					jScrollPaneOrdenesTrabajo = new JScrollPane();
					getContentPane().add(jScrollPaneOrdenesTrabajo);
					jScrollPaneOrdenesTrabajo.setBounds(14, 36, 202, 169);
					{
						TableModel jTableOrdenesTrabajoModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] { "Column 1", "Column 2" });
						jTableOrdenesTrabajo = new JTable();
						jScrollPaneOrdenesTrabajo.setViewportView(jTableOrdenesTrabajo);
						jTableOrdenesTrabajo.setModel(jTableOrdenesTrabajoModel);
						jTableOrdenesTrabajo.setPreferredSize(new java.awt.Dimension(199, 132));
					}
				}
			}
			this.setSize(424, 280);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Listados");
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
	
	private void jButtonConsutarIncidenciaActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonConsutarIncidencia.actionPerformed, event="+evt);
		//TODO add your code for jButtonConsutarIncidencia.actionPerformed
		ConsultarIncidenciaOperarioJDialog dialogoConsultarIncidencia = new ConsultarIncidenciaOperarioJDialog(this);
		dialogoConsultarIncidencia.setModal(true);
		dialogoConsultarIncidencia.setVisible(true);

		
	}

}

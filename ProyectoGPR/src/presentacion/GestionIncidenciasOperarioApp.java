package presentacion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import presentacion.GestionIncidenciasMaestroApp.ModeloTablaOrdenTrabajo;

import logica.Area;
import logica.Controlador;
import logica.Incidencia;
import logica.Operario;
import logica.OrdenTrabajo;


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
	private ArrayList<OrdenTrabajo> ordenesTrabajo;
	private ModeloTablaOrdenTrabajo modelo;

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
		
		try {
			{
				this.setTitle("Gestión de incidencias - Operario");
				getContentPane().setLayout(null);
				this.setResizable(false);
				ordenesTrabajo = new ArrayList<OrdenTrabajo>();

				
				try{ 	   
					this.control = Controlador.dameControlador(); 
					ordenesTrabajo = this.control.getOrdenesTrabajoPorOperario(
							new Operario("006",null,null,null));
					
				}catch (Exception e){ 
					JOptionPane.showMessageDialog( 
					this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); 
				}
				 modelo = new ModeloTablaOrdenTrabajo();
				
				  for ( Iterator<OrdenTrabajo> ordenIter = ordenesTrabajo.iterator(); ordenIter.hasNext(); ){
					OrdenTrabajo orden = ordenIter.next();
					  if(!(orden.getEstado().equals("EN_CURSO"))) ordenIter.remove();
					else
					modelo.anyadirFila(orden);
				  }
				
				
				
				
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

						jTableOrdenesTrabajo = new JTable();
						jScrollPaneOrdenesTrabajo.setViewportView(jTableOrdenesTrabajo);
						jTableOrdenesTrabajo.setModel(modelo);
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
		int numeroFilaSeleccionada = jTableOrdenesTrabajo.getSelectedRow();
		if (numeroFilaSeleccionada > -1){
			
			OrdenTrabajo orden = ordenesTrabajo.get(numeroFilaSeleccionada);
		ConsultarIncidenciaOperarioJDialog dialogoConsultarIncidencia = 
			new ConsultarIncidenciaOperarioJDialog(this,orden);
		dialogoConsultarIncidencia.setModal(true);
		dialogoConsultarIncidencia.setVisible(true);
		}
		
	}
public void actualizarTabla (){
	
		
	try{ 	   
		this.control = Controlador.dameControlador(); 
		ordenesTrabajo = this.control.getOrdenesTrabajoPorOperario(
				new Operario("006",null,null,null));
		
	}catch (Exception e){ 
		JOptionPane.showMessageDialog( 
		this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); 
	}
	 modelo.limpiarTabla();
	
	  for ( Iterator<OrdenTrabajo> ordenIter = ordenesTrabajo.iterator(); ordenIter.hasNext(); ){
		OrdenTrabajo orden = ordenIter.next();
		  if(!orden.getEstado().equals("EN_CURSO")) ordenIter.remove();
		else
		modelo.anyadirFila(orden);
	  }	
		
		
		
	}
	
	/**
	 * Modelo de tabla para mostrar las órdenes de trabajo para el Maestro.
	 */
	class ModeloTablaOrdenTrabajo extends AbstractTableModel {
			
		private static final long serialVersionUID = 1L;
			
		// Columnas de la tabla
		private String[] columnNames = {"ID", "PRIORIDAD", "ESTADO", "NOMBRE_AREA", "DNI" };
			
		// Datos que muestra la tabla
		private ArrayList<OrdenTrabajo> ordenesTrabajo = new ArrayList<OrdenTrabajo>();
		
		public int getColumnCount() {
			return columnNames.length;
		}
			
		public int getRowCount() {
			return ordenesTrabajo.size();
		}
			
		public String getColumnName(int col) {
			return columnNames[col];
		}
			
		// Este método se dispara cada vez que la tabla necesita el valor de un campo
		public Object getValueAt(int row, int col) {
			
			OrdenTrabajo orden = ordenesTrabajo.get(row);
			switch(col){
				case 0: return orden.getID();
				case 1: return orden.getPrioridad();
				case 2: return orden.getEstado();
				case 3: return orden.getArea().getNombre();
				case 4:
						if(orden.getOperario() != null){
							return orden.getOperario().getDNI();
						}else return "No Asignada";
				default: return null;
			}
		}
		
		public void limpiarTabla(){
			ordenesTrabajo.clear();
			this.fireTableDataChanged();
		}
		
		/*
		* JTable uses this method to determine the default renderer/
		* editor for each cell. If we didn't implement this method,
		* then the last column would contain text ("true"/"false"),
		* rather than a check box.
		*/
		public Class<? extends Object> getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
			
		public void anyadirFila(OrdenTrabajo row) {
			ordenesTrabajo.add(row);
			this.fireTableDataChanged();
		}
			
		public void borrarFila(int row) {
			ordenesTrabajo.remove(row);
			this.fireTableDataChanged();
		}
	}
	

}

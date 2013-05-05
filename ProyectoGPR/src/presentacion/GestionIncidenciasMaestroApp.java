package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.ArrayList;
import javax.swing.BorderFactory;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import excepciones.DAOExcepcion;
import excepciones.DominioExcepcion;

import logica.Area;
import logica.Controlador;
import logica.Incidencia;
import logica.Maestro;
import logica.Operario;
import logica.OrdenTrabajo;
import presentacion.GestionIncidenciasJefeApp.ModeloTablaAvisosIncidencia;


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
	
	private Controlador control;
	private JComboBox jComboBoxAreas;
	private JLabel jLabelSeleccionaArea;
	private JPanel jPanel1;
	private ModeloTablaOrdenTrabajo modelo;
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
	private JScrollPane jScrollPaneOrdenesTrabajo;
	private JComboBox jComboBoxOperarios;
	private JPanel jPanelAsignarOperario;
	private JButton jButtonEliminar;
	private JButton jButtonRegistrar;
	private JButton jButtonSalir;
	private JTable jTableOrdenesTrabajo;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuBar jMenuBar1;
	private static Maestro maestro;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(Maestro _maestro) {
		maestro = _maestro;
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
		
			ArrayList<OrdenTrabajo> ordenesTrabajo = new ArrayList<OrdenTrabajo>();
			ArrayList<Area> areas = new ArrayList<Area>();
			ArrayList<Operario> operarios = new ArrayList<Operario>();
			Area areaComboBoxOperarios;
			
			try{ 	   
				this.control = Controlador.dameControlador(); 
				areas = this.control.getAreas();
				areaComboBoxOperarios = control.getAreaPorNombre(maestro.getArea().getNombre());
				operarios = control.getOperariosPorArea(maestro.getArea());
				//System.out.println(areas.get(0).getNombre());
				ordenesTrabajo = this.control.getOrdenesTrabajoPorArea(maestro.getArea());
			}catch (Exception e){ 
				JOptionPane.showMessageDialog( 
				this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); 
			}
			
			this.modelo = new ModeloTablaOrdenTrabajo();
			for(OrdenTrabajo orden: ordenesTrabajo){
				modelo.anyadirFila(orden);
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
				jPanelAsignarOperario.setBounds(594, 202, 208, 89);
				jPanelAsignarOperario.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				{
					jLabelAsignarOperario = new JLabel();
					jPanelAsignarOperario.add(jLabelAsignarOperario);
					jLabelAsignarOperario.setText("Asigna un operario:");
				}
				
				//Configuracion el contenido de jComboBoxOperarios
				String[] elementosComboBoxOperarios = new String[operarios.size()];
				Operario operario;
				for(int i = 0; i < operarios.size(); i++){
					operario = operarios.get(i);
					elementosComboBoxOperarios[i]= operario.getNombre();	
				}//fin bucle for
				
				{
					ComboBoxModel jComboBoxAsignarOperarioModel = 
						new DefaultComboBoxModel(elementosComboBoxOperarios);
					jComboBoxOperarios = new JComboBox();
					jPanelAsignarOperario.add(jComboBoxOperarios);
					jComboBoxOperarios.setModel(jComboBoxAsignarOperarioModel);
					jComboBoxOperarios.setPreferredSize(new java.awt.Dimension(180, 23));
				}
				{
					jButtonAsignarOperario = new JButton();
					jPanelAsignarOperario.add(jButtonAsignarOperario);
					jButtonAsignarOperario.setText("Asignar");
					jButtonAsignarOperario.setPreferredSize(new java.awt.Dimension(96, 23));
					jButtonAsignarOperario.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonAsignarOperarioActionPerformed(evt);
						}
					});
				}
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jPanel1.setBounds(594, 110, 208, 72);
				{
					jLabelSeleccionaArea = new JLabel();
					jPanel1.add(jLabelSeleccionaArea);
					jLabelSeleccionaArea.setText("Selecciona un área:");
				}
				
				//Configuracion el contenido de jComboBoxAreas
				Area areaComboBoxAreas;
				String[] elementosComboBoxAreas = new String[areas.size()];
				
				for(int i = 0; i < areas.size(); i++){
					areaComboBoxAreas = areas.get(i);
					elementosComboBoxAreas[i]= areaComboBoxAreas.getNombre();	
				}//fin bucle for
				
				{
					ComboBoxModel jComboBox1Model = 
						new DefaultComboBoxModel(elementosComboBoxAreas);
					jComboBoxAreas = new JComboBox();
					jPanel1.add(jComboBoxAreas);
					jComboBoxAreas.setModel(jComboBox1Model);
					jComboBoxAreas.setPreferredSize(new java.awt.Dimension(180,23));
					jComboBoxAreas.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							//jComboBoxAreasItemStateChanged(evt);
						}
					});
				}
			}
			{
				jScrollPaneOrdenesTrabajo = new JScrollPane();
				getContentPane().add(jScrollPaneOrdenesTrabajo);
				jScrollPaneOrdenesTrabajo.setBounds(14, 88, 562, 309);
				{
					
					jTableOrdenesTrabajo = new JTable();
					jScrollPaneOrdenesTrabajo.setViewportView(jTableOrdenesTrabajo);
					jTableOrdenesTrabajo.setModel(modelo);
					jTableOrdenesTrabajo.setBounds(529, 275, 307, 144);
					jTableOrdenesTrabajo.getAutoResizeMode();
					this.configurarAspectoTabla();
				}
			}
			this.setSize(825, 470);
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
	
	private void jButtonAsignarOperarioActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonAsignarOperario.actionPerformed, event="+evt);
		//TODO add your code for jButtonAsignarOperario.actionPerformed
		
		int numeroFilaSeleccionada = jTableOrdenesTrabajo.getSelectedRow();
		if (numeroFilaSeleccionada > -1){
			int id = (Integer)jTableOrdenesTrabajo.getValueAt(numeroFilaSeleccionada, 0);
			
			String prioridadCadena = Integer.toString((Integer)jTableOrdenesTrabajo.getValueAt(numeroFilaSeleccionada, 1));
			int prioridad = Integer.parseInt(prioridadCadena);
			String estado = "EN_CURSO";
			String nombreArea = (String) jTableOrdenesTrabajo.getValueAt(numeroFilaSeleccionada, 3);
			String nombre = (String)jComboBoxOperarios.getSelectedItem();
			OrdenTrabajo orden = new OrdenTrabajo(id, prioridad, estado, nombreArea);
			try {
				Operario operario = control.getOperarioPorNombre(nombre);
				control.asignarOrdenTrabajo(orden, operario.getDNI());
				JOptionPane.showMessageDialog(this, "Orden de trabajo asignada a " +
					nombre + ".");
				this.modelo.limpiarTabla();
				Area area = new Area((String)this.jComboBoxAreas.getSelectedItem());
				ArrayList<OrdenTrabajo> ordenesTrabajo = control.getOrdenesTrabajoPorArea(area);
				for(OrdenTrabajo ordenTrabajo: ordenesTrabajo)
					modelo.anyadirFila(ordenTrabajo);

			} catch (Exception e) {
				JOptionPane.showMessageDialog( 
				this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); 
			}	
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una orden de trabajo.");
		}
	}
	
	private void jComboBoxAreasItemStateChanged(ItemEvent evt) {
		//System.out.println("jComboBoxAreas.itemStateChanged, event="+evt);
		//TODO add your code for jComboBoxAreas.itemStateChanged
		this.actualizarTabla();
		this.actualizarComboBox();
		
		
	}

	private void actualizarComboBox(){

		
		ArrayList<Operario> operarios = new ArrayList<Operario>();
		Area area = new Area((String)this.jComboBoxAreas.getSelectedItem());
		
		try{ 	   
			operarios = control.getOperariosPorArea(area);
		}catch (Exception e){ 
			JOptionPane.showMessageDialog( 
			this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); 
		}

		//Configuracion el contenido de jComboBoxOperarios
		String[] elementosComboBoxOperarios = new String[operarios.size()];
		Operario operario;
		for(int i = 0; i < operarios.size(); i++){
			operario = operarios.get(i);
			elementosComboBoxOperarios[i]= operario.getNombre();	
		}//fin bucle for
		
		ComboBoxModel jComboBoxAsignarOperarioModel = 
				new DefaultComboBoxModel(elementosComboBoxOperarios);
		
		jComboBoxOperarios.setModel(jComboBoxAsignarOperarioModel);
	}
	
	private void actualizarTabla (){
		
		try {
			this.modelo.limpiarTabla();
			ArrayList<OrdenTrabajo> ordenesTrabajo = control.getOrdenesTrabajoPorArea(maestro.getArea());
			for(OrdenTrabajo ordenTrabajo: ordenesTrabajo)
				modelo.anyadirFila(ordenTrabajo);

		} catch (Exception e) {
			JOptionPane.showMessageDialog( 
			this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); 
		}	
	}
	
	private void configurarAspectoTabla(){
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.jTableOrdenesTrabajo.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		this.jTableOrdenesTrabajo.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		this.jTableOrdenesTrabajo.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		this.jTableOrdenesTrabajo.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		this.jTableOrdenesTrabajo.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);	
		this.jTableOrdenesTrabajo.getColumnModel().getColumn(0).setPreferredWidth(75);
		this.jTableOrdenesTrabajo.getColumnModel().getColumn(1).setPreferredWidth(100);
		this.jTableOrdenesTrabajo.getColumnModel().getColumn(2).setPreferredWidth(150);
		this.jTableOrdenesTrabajo.getColumnModel().getColumn(3).setPreferredWidth(200);
		this.jTableOrdenesTrabajo.getColumnModel().getColumn(4).setPreferredWidth(100);
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

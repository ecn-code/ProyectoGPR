package presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;

import logica.Controlador;
import logica.Incidencia;
import logica.Area;
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
public class ClasificarIncidenciaJefejDialog extends javax.swing.JDialog {
	
	private GestionIncidenciasJefeApp jFramePrincipal;
	private Incidencia incidencia;
	private Controlador control;
	private JComboBox jComboBoxArea;
	private JComboBox jComboBoxPrioridad;
	private JButton jButtonEnviar;
	private JButton jButtonCancelar;
	private JLabel jLabelPrioridad;
	private JLabel jLabelArea;
	private int numeroFilaSeleccionada;

	/**
	* Auto-generated main method to display this JDialog
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				ClasificarIncidenciaJefejDialog inst = new ClasificarIncidenciaJefejDialog(frame);
				inst.setVisible(true);
			}
		});
	}*/
	
	public ClasificarIncidenciaJefejDialog(GestionIncidenciasJefeApp frame, Incidencia _incidencia,
			int numeroFilaSeleccionada) {
		super(frame);
		this.jFramePrincipal = frame;
		this.incidencia = _incidencia;
		this.numeroFilaSeleccionada=numeroFilaSeleccionada;
		this.initGUI();
	}
	
	private void initGUI() {
		
		try {
			
			ArrayList<Area> areas = new ArrayList<Area>();
			
			try{ 	   
				this.control = Controlador.dameControlador(); 
				areas = this.control.getAreas();
				   
			}catch (Exception e){ 
				JOptionPane.showMessageDialog( 
				this,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE); 
			}
			
			String[] elementosComboBox = new String[areas.size()];
			
			for(int i = 0; i < areas.size(); i++){
				Area area = areas.get(i);
				elementosComboBox[i]= area.getNombre();	
			}//fin bucle for
				
				{
				getContentPane().setLayout(null);
				this.setTitle("Clasificar incidencia");
				{
					ComboBoxModel jComboBox1Model = 
						new DefaultComboBoxModel(elementosComboBox);
					jComboBoxArea = new JComboBox();
					getContentPane().add(jComboBoxArea);
					jComboBoxArea.setModel(jComboBox1Model);
					jComboBoxArea.setBounds(75, 38, 207, 23);
				}
				{
					jLabelArea = new JLabel();
					getContentPane().add(jLabelArea);
					jLabelArea.setText("Área:");
					jLabelArea.setBounds(14, 41, 70, 17);
				}
				{
					jLabelPrioridad = new JLabel();
					getContentPane().add(jLabelPrioridad);
					jLabelPrioridad.setText("Prioridad:");
					jLabelPrioridad.setBounds(12, 92, 75, 16);
				}
				{
					ComboBoxModel jComboBox2Model = 
						new DefaultComboBoxModel(
								new String[] { "1", "2", "3" });
					jComboBoxPrioridad = new JComboBox();
					getContentPane().add(jComboBoxPrioridad);
					jComboBoxPrioridad.setModel(jComboBox2Model);
					jComboBoxPrioridad.setBounds(75, 89, 207, 23);
					jComboBoxPrioridad.setInheritsPopupMenu(true);
				}
				{
					jButtonCancelar = new JButton();
					getContentPane().add(jButtonCancelar);
					jButtonCancelar.setText("Cancelar");
					jButtonCancelar.setBounds(55, 156, 102, 23);
					jButtonCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonCancelarActionPerformed(evt);
						}
					});
				}
				{
					jButtonEnviar = new JButton();
					getContentPane().add(jButtonEnviar);
					jButtonEnviar.setText("Enviar");
					jButtonEnviar.setBounds(179, 156, 102, 23);
					jButtonEnviar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonEnviarActionPerformed(evt);
						}
					});
				}
			}
			this.setSize(324, 244);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButtonCancelarActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonCancelar.actionPerformed, event="+evt);
		//TODO add your code for jButtonCancelar.actionPerformed
		this.dispose();
	}
	
	private void jButtonEnviarActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonEnviar.actionPerformed, event="+evt);
		//TODO add your code for jButtonEnviar.actionPerformed
		
		String nombreArea = (String) jComboBoxArea.getSelectedItem();
		Area area = new Area(nombreArea);
		//System.out.println(nombreArea);
		String prioridadCadena = (String) jComboBoxPrioridad.getSelectedItem();
		//int entero = Integer.parseInt(enteroString);
		int prioridad = Integer.parseInt(prioridadCadena);
		//System.out.println(prioridad);
		OrdenTrabajo orden = new OrdenTrabajo(this.incidencia, area, prioridad);
		this.dispose();
		this.jFramePrincipal.actualizarTablaAvisosIncidencia(numeroFilaSeleccionada);
		try{ 	   
			this.control = Controlador.dameControlador(); 
			this.control.clasificarIncidencia(incidencia, area, prioridad);
			JOptionPane.showMessageDialog(this, "Inciencia enviada al Maestro de Área"); 
		}catch (Exception e){ 
			JOptionPane.showMessageDialog( 
			this,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE); 
		}
	}

}

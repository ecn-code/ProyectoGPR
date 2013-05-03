package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import logica.Controlador;

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
public class ConsultarIncidenciaOperarioJDialog extends javax.swing.JDialog {
	
	private JLabel jLabelNombreIncidencia;
	private JButton jButtonEmpezar;
	private JLabel jLabelMaterialSeleccionado;
	private JTable jTableMaterialAnyadido;
	private JButton jButtonSolicitarMaterial;
	private JButton jButtonCancelar;
	private JButton jButtonAnyadirMaterial;
	private JLabel jLabelDescripcionIncidencia;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				ConsultarIncidenciaOperarioJDialog inst = new ConsultarIncidenciaOperarioJDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public ConsultarIncidenciaOperarioJDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setTitle("Consultar Incidencia - Operario");
				getContentPane().setLayout(null);
				{
					jLabelNombreIncidencia = new JLabel();
					getContentPane().add(jLabelNombreIncidencia);
					jLabelNombreIncidencia.setText("Nombre de la incidencia");
					jLabelNombreIncidencia.setBounds(238, 12, 192, 16);
				}
				{
					jLabelDescripcionIncidencia = new JLabel();
					getContentPane().add(jLabelDescripcionIncidencia);
					jLabelDescripcionIncidencia.setText("Descripción de la incidencia...");
					jLabelDescripcionIncidencia.setBounds(17, 40, 588, 149);
					jLabelDescripcionIncidencia.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jLabelDescripcionIncidencia.setBackground(new java.awt.Color(255,255,255));
					jLabelDescripcionIncidencia.setForeground(new java.awt.Color(0,0,0));
					jLabelDescripcionIncidencia.setVerticalAlignment(SwingConstants.TOP);
				}
				{
					jButtonAnyadirMaterial = new JButton();
					getContentPane().add(jButtonAnyadirMaterial);
					jButtonAnyadirMaterial.setText("Añadir material");
					jButtonAnyadirMaterial.setBounds(12, 217, 134, 23);
					jButtonAnyadirMaterial.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonAnyadirMaterialActionPerformed(evt);
						}
					});
				}
				{
					jButtonEmpezar = new JButton();
					getContentPane().add(jButtonEmpezar);
					jButtonEmpezar.setText("Empezar");
					jButtonEmpezar.setBounds(514, 323, 92, 23);
				}
				{
					jButtonCancelar = new JButton();
					getContentPane().add(jButtonCancelar);
					jButtonCancelar.setText("Cancelar");
					jButtonCancelar.setBounds(405, 323, 92, 23);
					jButtonCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonCancelarActionPerformed(evt);
						}
					});
				}
				{
					jLabelMaterialSeleccionado = new JLabel();
					getContentPane().add(jLabelMaterialSeleccionado);
					jLabelMaterialSeleccionado.setText("Material seleccionado:");
					jLabelMaterialSeleccionado.setBounds(161, 195, 173, 16);
				}
				{
					jButtonSolicitarMaterial = new JButton();
					getContentPane().add(jButtonSolicitarMaterial);
					jButtonSolicitarMaterial.setText("Solicitar material");
					jButtonSolicitarMaterial.setBounds(12, 288, 134, 23);
				}
				{
					TableModel jTableMaterialAnyadidoModel = 
						new DefaultTableModel(
								new String[][] {{}, {}, {}},
								new String[] { "nombre", "cantidad", "disponible" });
					jTableMaterialAnyadido = new JTable();
					getContentPane().add(jTableMaterialAnyadido);
					jTableMaterialAnyadido.setModel(jTableMaterialAnyadidoModel);
					jTableMaterialAnyadido.setBounds(157, 217, 448, 94);
					jTableMaterialAnyadido.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
			}
			this.setSize(633, 396);
			this.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButtonCancelarActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonCancelar.actionPerformed, event="+evt);
		//TODO add your code for jButtonCancelar.actionPerformed
		this.dispose();
	}
	
	private void jButtonAnyadirMaterialActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonAnyadirMaterial.actionPerformed, event="+evt);
		//TODO add your code for jButtonAnyadirMaterial.actionPerformed
		AnyadirMaterialOperarioJDialog dialogoAnyadir = new AnyadirMaterialOperarioJDialog(this);
		dialogoAnyadir.setModal(true);
		dialogoAnyadir.setVisible(true);
	}

}

package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
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
public class AnyadirMaterialOperarioJDialog extends javax.swing.JDialog {
	private JTable jTableTodoElMaterial;
	private JLabel jLabelMaterialSeleccionado;
	private JScrollPane jScrollPaneMaterialSeleccionado;
	private JScrollPane jScrollPaneTodoMaterial;
	private JButton jButtonCancelar;
	private JButton jButtonAceptar;
	private JTable jTableMaterialSeleccionado;
	private JLabel jLabelTodoElMaterial;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JDialog dialogo = new JDialog();
				AnyadirMaterialOperarioJDialog inst = new AnyadirMaterialOperarioJDialog(dialogo);
				inst.setVisible(true);
			}
		});
	}
	
	public AnyadirMaterialOperarioJDialog(JDialog dialogo) {
		super(dialogo);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Seleccionar material - Operario");
				{
					jLabelTodoElMaterial = new JLabel();
					getContentPane().add(jLabelTodoElMaterial);
					jLabelTodoElMaterial.setText("Todo el material:");
					jLabelTodoElMaterial.setBounds(20, 18, 155, 16);
				}
				{
					jLabelMaterialSeleccionado = new JLabel();
					getContentPane().add(jLabelMaterialSeleccionado);
					jLabelMaterialSeleccionado.setText("Material seleccionado:");
					jLabelMaterialSeleccionado.setBounds(20, 205, 163, 16);
				}
				{
					jButtonAceptar = new JButton();
					getContentPane().add(jButtonAceptar);
					jButtonAceptar.setText("Aceptar");
					jButtonAceptar.setBounds(348, 401, 97, 23);
				}
				{
					jButtonCancelar = new JButton();
					getContentPane().add(jButtonCancelar);
					jButtonCancelar.setText("Cancelar");
					jButtonCancelar.setBounds(231, 401, 97, 23);
					jButtonCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonCancelarActionPerformed(evt);
						}
					});
				}
				{
					jScrollPaneTodoMaterial = new JScrollPane();
					getContentPane().add(jScrollPaneTodoMaterial);
					jScrollPaneTodoMaterial.setBounds(12, 40, 437, 153);
					{
						TableModel jTableTodoElMaterialModel = 
							new DefaultTableModel(
									new String[][] { {}, {}, {} },
									new String[] {"NOMBRE", "DISPONIBLE", "CANTIDAD"});
						jTableTodoElMaterial = new JTable();
						jScrollPaneTodoMaterial.setViewportView(jTableTodoElMaterial);
						jTableTodoElMaterial.setModel(jTableTodoElMaterialModel);
						jTableTodoElMaterial.setBounds(155, 93, 249, 78);
						jTableTodoElMaterial.setPreferredSize(new java.awt.Dimension(434, 120));
					}
				}
				{
					jScrollPaneMaterialSeleccionado = new JScrollPane();
					getContentPane().add(jScrollPaneMaterialSeleccionado);
					jScrollPaneMaterialSeleccionado.setBounds(12, 227, 437, 147);
					{
						TableModel jTableMaterialSeleccionadoModel = 
							new DefaultTableModel(
									new String[][] { {}, {}, {} },
									new String[] {"NOMBRE", "DISPONIBLE", "CANTIDAD"});
						jTableMaterialSeleccionado = new JTable();
						jScrollPaneMaterialSeleccionado.setViewportView(jTableMaterialSeleccionado);
						jTableMaterialSeleccionado.setModel(jTableMaterialSeleccionadoModel);
						jTableMaterialSeleccionado.setBounds(328, 266, 121, 95);
						jTableMaterialSeleccionado.setPreferredSize(new java.awt.Dimension(434, 106));
					}
				}
			}
			this.setSize(477, 474);
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

}

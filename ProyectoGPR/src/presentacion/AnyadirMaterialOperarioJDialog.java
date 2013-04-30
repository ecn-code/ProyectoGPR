package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
					TableModel jTableTodoElMaterialModel = 
						new DefaultTableModel(
								new String[][] { {}, {}, {} },
								new String[] { "nombre", "disponible", "cantidad" });
					jTableTodoElMaterial = new JTable();
					getContentPane().add(jTableTodoElMaterial);
					jTableTodoElMaterial.setModel(jTableTodoElMaterialModel);
					jTableTodoElMaterial.setBounds(12, 40, 437, 148);
					jTableTodoElMaterial.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
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
					TableModel jTableMaterialSeleccionadoModel = 
						new DefaultTableModel(
								new String[][] { {}, {}, {} },
								new String[] { "nombre", "disponible", "cantidad" });
					jTableMaterialSeleccionado = new JTable();
					getContentPane().add(jTableMaterialSeleccionado);
					jTableMaterialSeleccionado.setModel(jTableMaterialSeleccionadoModel);
					jTableMaterialSeleccionado.setBounds(12, 227, 437, 134);
					jTableMaterialSeleccionado.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
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

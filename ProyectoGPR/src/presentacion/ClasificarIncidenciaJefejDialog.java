package presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;


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
	private JComboBox jComboBoxArea;
	private JComboBox jComboBoxPrioridad;
	private JButton jButtonEnviar;
	private JButton jButtonCancelar;
	private JLabel jLabelPrioridad;
	private JLabel jLabelArea;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				ClasificarIncidenciaJefejDialog inst = new ClasificarIncidenciaJefejDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public ClasificarIncidenciaJefejDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Clasificar incidencia");
				{
					ComboBoxModel jComboBox1Model = 
						new DefaultComboBoxModel(
								new String[] { "Mecánica", "Electricidad", "A.A/Calefacción",
									"Electromedicina", "Carpintería", "Pintura", "Fontanería",
									"Albañilería"});
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
								new String[] { "Alta", "Media", "Baja" });
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

}

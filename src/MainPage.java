package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCarInfo = new JButton("Car Info");
		btnCarInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carsUI cars = new carsUI();
			}
		});
		
		JButton btnServicing = new JButton("Servicing");
		btnServicing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BillingUI bill = new BillingUI();
			}
		});
		String url = "C:\'\'Users\'\'hp\'\'eclipse-workspace\'\'DBMS\'\'Images\'download.png";
		ImageIcon imageIcon = new ImageIcon(url);
		JLabel lblNewLabel = new JLabel(imageIcon);
		//lblNewLabel.setIcon(new ImageIcon(url));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addComponent(btnCarInfo, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addComponent(btnServicing, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(51))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(180)
					.addComponent(lblNewLabel)
					.addContainerGap(198, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(79)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnServicing, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCarInfo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(46))
		);
		contentPane.setLayout(gl_contentPane);
	}

}

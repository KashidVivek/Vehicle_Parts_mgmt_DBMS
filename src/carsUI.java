package userInterface;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class carsUI extends JFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carsUI frame = new carsUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 public Connection getConnection()
	    {
	        Connection con = null;
	        
	        try{
	        	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","vivek");
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }
	        return con;
	    }
	
	public carsUI() {
		setBounds(100, 100, 704, 418);
		
		JLabel lblCarInfomation = new JLabel("Car Type:");
		
		JLabel lblCarName = new JLabel("Car Name :");
		
		JLabel lblCarId = new JLabel("Car ID :");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblDisplacment = new JLabel("Displacment:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblUelType = new JLabel("Fuel Type:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblTransmission = new JLabel("Transmission:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblMileage = new JLabel("Mileage:");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblMaxPower = new JLabel("Max Power:");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblMaxTorque = new JLabel("Max Torque:");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblAbs = new JLabel("ABS:");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel lblFuelCapacity = new JLabel("Fuel Capacity:");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price:");
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		JButton btnMenu = new JButton("Menu");
		
		JButton btnNext = new JButton("Next");
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String type = comboBox_1.getSelectedItem().toString();
				System.out.println(type);
				String car = comboBox.getSelectedItem().toString();
				Statement st;
		        ResultSet rs;  
		        int ID;
		        try{
		            Connection con = getConnection();
		            st = con.createStatement();
		            String searchQuery = "SELECT * FROM "+type+" where Name = '"+car+"'";
		            rs = st.executeQuery(searchQuery);
		            while(rs.next())
		            {
		            textField_1.setText(rs.getString(2));
		            textField_2.setText(rs.getString(4));
		            textField_3.setText(rs.getString(5));
		            textField_4.setText(rs.getString(6));
		            textField_5.setText(rs.getString(7));
		            textField_6.setText(rs.getString(8));
		            textField_7.setText(rs.getString(9));
		            textField_8.setText(rs.getString(10));
		            textField_9.setText(rs.getString(11));
		            textField_10.setText(rs.getString(12));
		            }
		        }
		        catch(Exception ee)
		        {
		        	System.out.println(ee.getMessage());
		        }
			}
		});
		
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				comboBox.removeAllItems();
				if(comboBox_1.getSelectedItem().toString().equals("Nexa"))
				{
					comboBox.addItem(new String("S Cross"));
					comboBox.addItem(new String("Baleno"));
					comboBox.addItem(new String("Ciaz"));
					comboBox.addItem(new String("Ignis"));
				}
				else if(comboBox_1.getSelectedItem().toString().equals("Hatch Back"))
				{
					comboBox.addItem(new String("Alto 800"));
					comboBox.addItem(new String("Alto K10"));
					comboBox.addItem(new String("Swift"));
					comboBox.addItem(new String("Celerio"));
				}
				else if(comboBox_1.getSelectedItem().toString().equals("Sedan"))
				{
					comboBox.addItem(new String("Dzire"));
				}
				else if(comboBox_1.getSelectedItem().toString().equals("SUV"))
				{
					comboBox.addItem(new String("Gypsy"));
					comboBox.addItem(new String("Ertiga"));
					comboBox.addItem(new String("Vitara Brezza"));
				}
				else if(comboBox_1.getSelectedItem().toString().equals("Van"))
				{
					comboBox.addItem(new String("Omini"));
					comboBox.addItem(new String("Eeco"));
				}
			}
		});
		comboBox_1.addItem(new String("--Select--"));
		comboBox_1.addItem(new String("Nexa"));
		comboBox_1.addItem(new String("Hatch Back"));
		comboBox_1.addItem(new String("Sedan"));
		comboBox_1.addItem(new String("SUV"));
		comboBox_1.addItem(new String("Van"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCarInfomation, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCarName)
								.addComponent(lblCarId)
								.addComponent(lblDisplacment)
								.addComponent(lblUelType)
								.addComponent(lblTransmission)
								.addComponent(lblMaxPower)
								.addComponent(lblMileage)
								.addComponent(lblMaxTorque))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_7)
								.addComponent(textField_1)
								.addComponent(textField_2)
								.addComponent(textField_3)
								.addComponent(textField_4)
								.addComponent(textField_5)
								.addComponent(textField_6))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(94)
									.addComponent(lblAbs))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(81)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPrice)
										.addComponent(lblFuelCapacity))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_10, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addComponent(textField_9)
								.addComponent(textField_8)
								.addComponent(btnMenu, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnNext, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarInfomation, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarName)
						.addComponent(lblAbs)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarId)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFuelCapacity)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDisplacment)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrice)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUelType)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTransmission)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMileage)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaxPower)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaxTorque)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMenu)
						.addComponent(btnNext))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}
}

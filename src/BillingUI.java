package userInterface;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;



import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class BillingUI extends JFrame {
	private JTextField invoiceNoText;
	private JTextField invoiceDateText;
	private JTextField CustomerNameText;
	private JTextField CustomerNoText;
	private JTextField ContactNoText;
	private JTextField productCodetext;
	private JTextField ProductCodeText;
	private JTextField PriceText;
	private JTextField QuantityText;
	private JTextField AmountText;
	private JTextField VATText;
	private JTextField textField_11;
	private JTextField PaymentText;
	private JTextField PaymentDtText;
	private JTable jTable1;

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
	 public void findUsers()
	    {
	        ArrayList<T> users = ListUsers(CustomerNoText.getText());
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(new Object[]{"Product code","Product name","Quantity","Amount"});
	        Object[] row = new Object[4];
	        
	        for(int i = 0; i < users.size(); i++)
	        {
	            row[0] = users.get(i).getpdt_no();
	            row[1] = users.get(i).getname();
	            row[2] = users.get(i).getquantity();
	            row[3] = users.get(i).getamt();
	            model.addRow(row);
	            
	            
	            
	            
	            
	            
	        }
	        jTable1.setModel(model);     
	    } 
	 public ArrayList<T> ListUsers(String cust_no)
	    {
	        ArrayList<T> usersList = new ArrayList<T>();       
	        Statement st;
	        ResultSet rs;   
	        String searchQuery;
	       
	        try{
	            Connection con = getConnection();
	            st = con.createStatement();
	            
	            	 searchQuery = "SELECT pdt_no,pdt_name,quantity,amt FROM cart WHERE cust_no='"+cust_no+"' ";
	            
	            
	            rs = st.executeQuery(searchQuery);
	            
	            T user;
	            
	            while(rs.next())
	            {
	                user = new T(
	                		 		rs.getInt(1),
	                                 rs.getString(2),
	                                 rs.getInt(4),
	                                 rs.getInt(3)
	                                );
	                usersList.add(user);
	            }
	            
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }
	        
	        return usersList;
	    }
	public BillingUI() {
		setBounds(100, 100, 1071, 602);
		
		JLabel lblInvoiceInfo = new JLabel("Invoice Info:");
		
		JLabel lblInvoiceNo = new JLabel("Invoice No:");
		
		invoiceNoText = new JTextField();
		invoiceNoText.setColumns(10);
		
		JLabel lblInvoiceDate = new JLabel("Invoice Date:");
		
		invoiceDateText = new JTextField();
		invoiceDateText.setColumns(10);
		
		JLabel lblCustomerDetails = new JLabel("Customer Details:");
		
		JLabel lblCustomerNo = new JLabel("Customer No:");
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		
		JLabel lblContactNo = new JLabel("Contact No:");
		
		CustomerNameText = new JTextField();
		CustomerNameText.setColumns(10);
		
		JLabel lblProductDetails = new JLabel("Product Details:");
		
		CustomerNoText = new JTextField();
		CustomerNoText.setColumns(10);
		
		ContactNoText = new JTextField();
		ContactNoText.setColumns(10);
		
		JLabel lblProductCode = new JLabel("Product Code:");
		
		JLabel lblProductName = new JLabel("Product Name:");
		
		JLabel lblPrice = new JLabel("Price:");
		
		JLabel lblQuantity = new JLabel("Quantity:");
		
		JLabel lblAmount = new JLabel("Amount:");
		
		JLabel lblVat = new JLabel("VAT:");
		
		productCodetext = new JTextField();
		productCodetext.setColumns(10);
		
		ProductCodeText = new JTextField();
		ProductCodeText.setColumns(10);
		
		PriceText = new JTextField();
		PriceText.setColumns(10);
		
		QuantityText = new JTextField();
		QuantityText.setColumns(10);
		
		AmountText = new JTextField();
		AmountText.setColumns(10);
		
		VATText = new JTextField();
		VATText.setColumns(10);
		String data[][]= {{null,null,null,null}};
		String column[]= {"Code", "Name", "Quantity", "Amount"};
		/*table_2.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{null, null, null, null},
	        		{null, null, null, null},
	        		{null, null, null, null},
	        		{null, null, null, null},
	        	},
	        	new String[] {
	        		"Code", "Name", "Quantity", "Amount"
	        	}
	        ));*/
		JLabel lblTotalAmount_1 = new JLabel("Total Amount:");
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				productCodetext.setText(null);
				ProductCodeText.setText(null);
				PriceText.setText(null);
				QuantityText.setText(null);
				VATText.setText(null);
				AmountText.setText(null);
			}
		});
		 DefaultTableModel model = new DefaultTableModel();
	     model.setColumnIdentifiers(new Object[]{"Code", "Name", "Quantity", "Amount"});
		 Object[] row = new Object[4];
		JButton btnAddToCart = new JButton("Add To Cart");
		btnAddToCart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Statement st;
		        int r;  
		        int cno = Integer.parseInt(CustomerNoText.getText());
		        int prdtc = Integer.parseInt(productCodetext.getText());
		        String prdn =  ProductCodeText.getText();
		        int quan = Integer.parseInt(QuantityText.getText());
		        int amt = Integer.parseInt(AmountText.getText());
		        //int coct = Integer.parseInt(ContactNoText.getText());
		        try{
		            Connection con = getConnection();
		            st = con.createStatement();
		            String Query = "insert into cart values("+cno+","+prdtc+",'"+prdn+"',"+quan+","+amt+")";
		            r = st.executeUpdate(Query);
		            System.out.println(r+" Row affected");
		        }
		        catch(Exception ee)
		        {
		        	System.out.println(ee.getMessage());
		        }
		        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
		        model.setRowCount(0);
		        findUsers();
			}
		});
		
		JButton btnRemove = new JButton("Remove");
		
		JButton btnUpdate = new JButton("Update");
		
		JLabel lblPaymentInfo = new JLabel("Payment Info:");
		
		JLabel lblPaymentMode = new JLabel("Payment Mode :");
		
		JLabel lblPayment = new JLabel("Payment:");
		
		JLabel lblPaymentDate = new JLabel("Payment date:");
		
		PaymentText = new JTextField();
		PaymentText.setColumns(10);
		
		PaymentDtText = new JTextField();
		PaymentDtText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Products:");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Statement st;
		        int r;  
		        int cno = Integer.parseInt(CustomerNoText.getText());
		        String cnm = CustomerNameText.getText();
		        int coct = Integer.parseInt(ContactNoText.getText());
		        try{
		            Connection con = getConnection();
		            st = con.createStatement();
		            String Query = "insert into cust_info values("+cno+",'"+cnm+"',"+coct+")";
		            r = st.executeUpdate(Query);
		            System.out.println(r+" Row affected");
		        }
		        catch(Exception ee)
		        {
		        	System.out.println(ee.getMessage());
		        }
			}
		});
		
		JButton btnReset_1 = new JButton("Reset");
		
		JComboBox PaymentcomboBox = new JComboBox();
		PaymentcomboBox.addItem(new String("--Select--"));
		PaymentcomboBox.addItem(new String("Cash"));
		PaymentcomboBox.addItem(new String("Cheque"));
		PaymentcomboBox.addItem(new String("Demand Draft"));
		
		JSeparator separator_1 = new JSeparator();
		JSeparator separator_2 = new JSeparator();
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int pdi = Integer.parseInt(productCodetext.getText());
				Statement st;
				ResultSet rs;
				
				try{
		            Connection con = getConnection();
		            st = con.createStatement();
		            String Query = "select * from Product_info where PDT_NO = "+pdi+"" ;
		            rs = st.executeQuery(Query);
		            while(rs.next())
		            {
		            	ProductCodeText.setText(rs.getString(2));
		            	PriceText.setText(rs.getString(3));
		            }
		            AmountText.setText(null);
		        }
		        catch(Exception ee)
		        {
		        	System.out.println(ee.getMessage());
		        }
				
			}
		});
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int quantity;
				int price;
				String vat;
				String finalno;
				price = Integer.parseInt(PriceText.getText());
				quantity =Integer.parseInt(QuantityText.getText());
				finalno =Integer.toString(price*quantity); 
				AmountText.setText(finalno);
				vat = Float.toString(0.18f * price * quantity);
				VATText.setText(vat);
			}
		});
		
		JScrollPane jScrollPane1 = new JScrollPane();
	        //jScrollPane1.setViewportView(jTable1);
		jTable1 = new JTable();
		jScrollPane1.setViewportView(jTable1);
		 jTable1.setModel(new DefaultTableModel(
		        	new Object[][] {
		        		{null, null, null, null},
		        		{null, null, null, null},
		        		{null, null, null, null},
		        		{null, null, null, null},
		        	},
		        	new String[] {
		        			"Code", "Name", "Quantity", "Amount"
		        	}
		        ));
		        jScrollPane1.setViewportView(jTable1);
		
		JButton btnCalculateBill = new JButton("Calculate Bill");
		btnCalculateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Statement st;
				ResultSet rs;
				
				try{
		            Connection con = getConnection();
		            st = con.createStatement();
		            String Query = "select sum(amt) from cart where cust_no = "+CustomerNoText.getText()+"" ;
		            rs = st.executeQuery(Query);
		            while(rs.next())
		            {
		            	textField_11.setText(rs.getString(1));
		            }
		        }
		        catch(Exception ee)
		        {
		        	System.out.println(ee.getMessage());
		        }
			}	
		});
		        
		        
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(101, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblCustomerDetails)
								.addComponent(lblProductDetails)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(lblProductCode)
															.addComponent(lblProductName)
															.addComponent(lblPrice)
															.addComponent(lblQuantity)
															.addComponent(lblAmount))
														.addComponent(lblVat))
													.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addComponent(productCodetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
															.addGap(18)
															.addComponent(btnGo))
														.addComponent(PriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(QuantityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(ProductCodeText, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
														.addGroup(groupLayout.createSequentialGroup()
															.addComponent(AmountText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(btnCalculate))
														.addComponent(VATText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblCustomerName)
														.addComponent(lblContactNo)
														.addComponent(lblCustomerNo))
													.addGap(18)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(CustomerNoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(ContactNoText, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
														.addComponent(CustomerNameText, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))))
										.addComponent(lblInvoiceInfo, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblInvoiceDate)
												.addComponent(lblInvoiceNo))
											.addGap(28)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(invoiceDateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(invoiceNoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblPaymentInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnAddToCart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnRemove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblPaymentMode)
														.addComponent(lblPayment))
													.addGap(10)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(PaymentcomboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(PaymentText)))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblPaymentDate)
													.addGap(34)
													.addComponent(PaymentDtText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(btnReset_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(76)
											.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(189)
											.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
									.addGap(22))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
									.addGap(33))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnCalculateBill)
							.addGap(18)
							.addComponent(lblTotalAmount_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(125))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInvoiceInfo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblInvoiceNo)
								.addComponent(invoiceNoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblInvoiceDate)
								.addComponent(invoiceDateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCustomerDetails, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCustomerNo)
								.addComponent(CustomerNoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCustomerName)
								.addComponent(CustomerNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPaymentInfo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPaymentMode)
								.addComponent(PaymentcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPayment)
								.addComponent(PaymentText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPaymentDate)
								.addComponent(PaymentDtText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnReset_1)
									.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblContactNo)
								.addComponent(ContactNoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblProductDetails, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProductCode)
								.addComponent(productCodetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnReset)
								.addComponent(btnGo)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(lblNewLabel)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(ProductCodeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProductName)
								.addComponent(btnAddToCart))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(PriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnRemove))
								.addComponent(lblPrice))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(QuantityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblQuantity))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(AmountText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAmount)
										.addComponent(btnCalculate))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(VATText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblVat)))
								.addComponent(btnUpdate))))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalAmount_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalculateBill))
					.addGap(41))
		);
		
		
		getContentPane().setLayout(groupLayout);
		setVisible(true);
		
	}
}

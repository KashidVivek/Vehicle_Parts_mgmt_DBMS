package userInterface;

public class T{
	  private String name ;
	  private int pdt_no;
	  private int quantity;
	  private int amt;
	  
	 public T(int pdt_no,String name,int amt,int quantity)
	    {
		 this.amt=amt;
		 this.name=name;
		 this.pdt_no=pdt_no;
		 this.quantity=quantity;
	    }
	    
	    public String getname()
	    {
	        return name;
	    }
	    
	    public int getpdt_no()
	    {
	        return pdt_no;
	    }
	    
	    public int getquantity()
	    {
	        return quantity;
	    }
	    
	    public int getamt()
	    {
	        return amt;
	    }
}

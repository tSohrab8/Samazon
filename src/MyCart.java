import java.util.ArrayList;

public class MyCart {
	
	ArrayList<Integer> productid;
	ArrayList<Integer> quantity;
	
	public MyCart(){
		
		productid = new ArrayList<Integer>();
		quantity = new ArrayList<Integer>();
		
	}
	
	public void addProduct(int p, int q){
		
		int index = productid.indexOf(p);
		int prevQ;
		
		if (index == -1){
			productid.add(p);
			quantity.add(q);
		}
		else{
			prevQ = quantity.get(index);
			quantity.set(index, q + prevQ);
		}
	}
	
	public String printProducts(){
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < productid.size();i++){
			s.append("\nProductid : " + productid.get(i) + " Quantity: " + quantity.get(i));
		}
		return s.toString();
	}
	
	public void clearProducts(){
		productid = new ArrayList<Integer>();
		quantity = new ArrayList<Integer>();
	}
	
	

}

package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		// TODO
		this.orderItemList = new ArrayList<OrderItem>(1);
		this.orderNumber = Order.getTotalOrderCount();
		Order.totalOrderCount +=1;

	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		// Loop the orderItemList to find if item of any orderItem equals to the given item
		// if there is orderItem with given item, increase that orderItem itemAmount with amount
		// and return that orderItem

		// else create new orderItem with given item and amount, then return the new orderItem
		boolean found = false;
		for(int i = 0; i < this.orderItemList.size() ; i++) {
			if(item.getName() == this.orderItemList.get(i).getItem().getName()) {
				this.orderItemList.get(i).increaseItemAmount(amount);
				found = true;
				break;
			}	
		}
		if(!found) {
			OrderItem k = new OrderItem(item,amount);
			this.orderItemList.add(k);
			return k;
		}
		
		return null;
	}

	public int calculateOrderTotalPrice() {
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int sum = 0;
		for(int i = 0; i < this.orderItemList.size() ; i++) {
			sum+= this.orderItemList.get(i).calculateTotalPrice();
		}
		return sum;
		
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}

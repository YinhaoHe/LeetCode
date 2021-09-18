https://leetcode.com/discuss/interview-question/1136298/Shopping-Cart-Billing-OA-Mar-2021&#8205;&#8205;&#8205;&#8204;&#8205;&#8204;&#8205;&#8204;&#8204;&#8205;&#8205;&#8204;&#8205;&#8204;&#8204;&#8204;&#8204;&#8204;&#8205;

import java.util.*;
public class ShoppingCartBilling {
	static class Pair {
		int type;
		double d;
		Pair(int type, double d) {
			this.type=type;
			this.d=d;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<List<String>> products = new ArrayList<>();
		List<List<String>> discounts = new ArrayList<>();
		products.add(new ArrayList<>(List.of("10", "sale", "jan-sale")));
		products.add(new ArrayList<>(List.of("200", "sale", "EMPTY")));
		products.add(new ArrayList<>(List.of("20", "d1", "EMPTY")));
		discounts.add(new ArrayList<>(List.of("sale", "0", "10")));
		discounts.add(new ArrayList<>(List.of("jan-sale", "1", "10")));
		System.out.println(FindLowestPrice(products, discounts));
		sc.close();
	}
	public static int FindLowestPrice(List<List<String>> products, List<List<String>> discounts) {
		int ans=0;
		HashMap<String, Pair> map = new HashMap<>();
		for(List<String> list: discounts) {
			map.put(list.get(0), new Pair(Integer.parseInt(list.get(1)), Double.parseDouble(list.get(2))));
		}
		for(List<String> list: products) {
			double retail = Double.parseDouble(list.get(0));
			double price = retail;
			for(int i=1;i<list.size();i++) {
				if(list.get(i).equals("EMPTY")) {
					continue;
				}
				double price1=retail;
				Pair discount = map.get(list.get(i));
				if(discount.type==0) {
					price1=Math.round(discount.d);
				} else if(discount.type==1) {
					price1=Math.round(price1-(price1*(discount.d/(double)100)));
				} else {
					price1=Math.round(price1-discount.d);
				}
				price=Math.min(price, price1);
			}
			ans+=(int)price;
		}
		return ans;
	}
}
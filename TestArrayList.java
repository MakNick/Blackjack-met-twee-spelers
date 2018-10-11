package WeekOpdrachtBlackjackSpeler;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {


		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		
		for(int i = 0; i < 1; i++){ 
			list2.add(list1.get(0));
			list1.remove(0);
		}
		
		
		
		System.out.println(list1);
		System.out.println(list2);

	}

}

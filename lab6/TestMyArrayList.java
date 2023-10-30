package lab6;

import java.util.Arrays;
import java.util.Comparator;

public class TestMyArrayList {
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		// method Size
//		System.out.println(list.size());
//		// method isEmpty
//		System.out.println(list.isEmpty());
//		// method Get and Add
		for (int i = 3; i > -1; i--) {
			list.add(i);
		}
//		list.add(4, 4);
//		System.out.println(list.get(4));
//		// method removeByIndex
//		System.out.println(list.remove(3));
//		System.out.println(list.get(2));
//		// method clear
////		list.clear();
////		System.out.println(list.size());
//		// method lastIndexOf
//		list.add(0, 2);
//		System.out.println(list.lastIndexOf(2));
//		// method toArray
//		System.out.println(Arrays.toString(list.toArray()));
//		// method contains
//		System.out.println(list.contains(3));
//		// method indexOf
//		System.out.println(list.indexOf(0));
//		// method removeByElement
//		System.out.println(list.remove(list.get(0)));
//		System.out.println(Arrays.toString(list.toArray()));
//		System.out.println(list.remove(Integer.valueOf(5)));
		System.out.println(Arrays.toString(list.toArray()));
		list.sort(Comparator.naturalOrder());
		System.out.println(Arrays.toString(list.toArray()));
	}
}

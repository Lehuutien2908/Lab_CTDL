package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestMyPredicates {
	public static void main(String[] args) {
		Predicate<Integer> e = new Even();

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		MyPredicates.remove(list1, e);
		System.out.println(list1);

		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		MyPredicates.retain(list2, e);
		System.out.println(list2);

		List<Integer> list3 = new ArrayList<>();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		System.out.println(MyPredicates.collect(list3, e));

		List<Integer> list4 = new ArrayList<>();
		list4.add(1);// index = 0
		list4.add(2);// 1
		list4.add(3);// 2
		list4.add(4);// 3
		list4.add(5);// 4
		System.out.println(MyPredicates.find(list4, e));
	}
}

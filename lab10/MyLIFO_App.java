package lab10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
	public static <E> void reverse(E[] arr) {
		Stack<E> stack = new Stack<>();
		for (E e : arr) {
			stack.push(e);
		}
		for(int i = 0; i < arr.length; i++) {
			arr[i] = stack.pop();
		}
		System.out.println("Method 1: " + Arrays.toString(arr));
	}

	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		for (char c : input.toCharArray()) {
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			} else if (c == '}' || c == ')' || c == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				char check = stack.pop();
				if ((c == '}' && check != '{') || (c == ')' && check != '(') || (c == ']' && check != '[')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static int evaluateExpression(String expression) {

		return 0;
	}

	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E element = input.poll();
			input.add(element);
			input.add(element);
		}
		System.out.println("Method 4: " + input);
	}

	public static <E> void mirror(Queue<E> input) {
		Stack<E> stack = new Stack<>();
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E element = input.poll();
			stack.push(element);
			input.add(element);
		}
		while (!stack.isEmpty()) {
			input.add(stack.pop());
		}
		System.out.println("Method 5: " + input);
	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5 };
		String str = "()(())[]{(())}";
		Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3));
		Queue<Character> newQueue = new LinkedList<>(Arrays.asList('a', 'b', 'c'));

		MyLIFO_App.reverse(arr);
		System.out.println("IsCorrect method: " + MyLIFO_App.isCorrect(str));
		MyLIFO_App.stutter(queue);
		MyLIFO_App.mirror(newQueue);
	}
}

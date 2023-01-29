import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// PROGRAMMER: COREY TAYLOR
public class DynamicStack<E> {

	// INSTANCE VARIABLES
	private DynamicArray<E> stack;

	// CONSTRUCTOR
	public DynamicStack() {
		stack = new DynamicArray<E>();
	}

	@SuppressWarnings("unchecked")
	public DynamicStack(String filename) throws IOException {
		stack = new DynamicArray<>();
		Scanner inputFile = new Scanner(new File(filename));
		while (inputFile.hasNext()) {
			stack.addToEnd((E) inputFile.next());
		}
		inputFile.close();
	}

	// INSTANCE METHODS
	public void push(E element) {
		stack.addToEnd(element);
	}

	public boolean empty() {
		if (stack.getNumberOfElements() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public E peek() {
		if (empty()) {
			throw new RuntimeException("Caused by Dynamic Stack Peek Method");
		} else {
			return stack.get(stack.getNumberOfElements() - 1);
		}
	}

	public E pop() {
		if (empty()) {
			throw new RuntimeException("Caused by Dynamic Stack Pop Method");
		} else {
			return stack.remove(stack.getNumberOfElements() - 1);
		}
	}

	public void saveToFile(String filename) throws FileNotFoundException {
		PrintWriter outputFile = new PrintWriter(filename);
		for (int index = 0; index < (stack.getNumberOfElements()); index++) {
			outputFile.println(stack.get(index));
		}
		outputFile.close();
	}
}

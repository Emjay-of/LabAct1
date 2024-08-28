package libsystem;

public class DynamicArray<T> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 5;

    public DynamicArray() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Adds an element to the end of the array
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Inserts an element at a specified index, shifting elements as needed
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("You're trying to insert a book in invalid index: " + index + "!");
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Removes the element at the specified index, shifting elements as needed
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("You're trying to remove a book in invalid index: " + index + "!");
        }
        int numElements = size - index - 1;
        if (numElements > 0) {
            System.arraycopy(elements, index + 1, elements, index, numElements);
        }
        elements[--size] = null; // Clear the last element
    }

    // Returns the element at the specified index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Book cannot be found at index: " + index);
        }
        return (T) elements[index];
    }

    // Returns the number of elements in the array
    public int size() {
        return size;
    }

    // Returns true if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Ensure the array has enough capacity
    private void ensureCapacity() {
        if (size >= elements.length) {
            int newCapacity = elements.length * 2;
            elements = java.util.Arrays.copyOf(elements, newCapacity);
        }
    }
}

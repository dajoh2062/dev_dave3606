package a_exam;


class ExpandableList<T> {
    int size = 0;
    int capacity;
    Object[] expandableArray;

    public ExpandableList(int intendedCapacity) {
        this.capacity = intendedCapacity;
        this.expandableArray = new Object[capacity];
    }

    public void addElement(T x) {
        if (size == capacity) {
            Object[] newArray = new Object[capacity * 2];

            for (int i = 0; i < size; i++) {
                newArray[i] = expandableArray[i];
            }

            expandableArray = newArray;
            capacity = capacity * 2;
        }

        expandableArray[size] = x;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) expandableArray[index];
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(expandableArray[i] + " ");
        }
        System.out.println();
    }
}
public class task_2_10_ExpandableList {
    public static void main (String[] args){

    }
}


package week5;

class expandableList{
    private int size;
    private int[] data;


    public expandableList(int startSize){
        data = new int [startSize];
        size = 0;
    }
    public void add(int value) {
        if (size == data.length) {
            // double the capacity
            int[] newData = new int[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size] = value;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return data[index];
    }

    public int size() {
        return size;
    }



   

}


public class task1b{

    

    public static void main (String[] args){



    }
}

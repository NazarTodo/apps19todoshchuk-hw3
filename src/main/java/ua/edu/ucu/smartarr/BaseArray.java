package ua.edu.ucu.smartarr;


import java.util.Arrays;


// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] arr;

    public BaseArray(Object[] arr) {

        this.arr = arr;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[this.arr.length];
        int j = 0;
        for (int i = 0; i < newArr.length; i++) {

            if (this.arr[i] != null) {

                newArr[j] = this.arr[i];

                j += 1;
            }


        }


        this.arr = Arrays.copyOf(newArr, j);
        return this.arr;
    }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        int counter = 0;
        for (Object o : this.arr) {
            if (o != null) {

                counter += 1;
            }
        }
        return counter;
    }


}



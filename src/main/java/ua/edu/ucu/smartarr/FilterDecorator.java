package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate pr;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.pr = pr;
        array = filter();
    }

    private Object[] filter() {
        Object[] newArray = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        for (int j = 0; j < newArray.length; j++) {

            if (!pr.test(newArray[j])) {
                newArray[j] = null;
            }

        }
        Object[] newArr = Arrays.copyOf(newArray, newArray.length);
        int j = 0;
        for (int i = 0; i < newArr.length; i++) {

            if (newArr[i] != null) {

                newArr[j] = newArray[i];

                j += 1;
            }


        }

        newArr = Arrays.copyOf(newArr, j);
        return newArr;
    }

    @Override
    public Object[] toArray() {
        if (Arrays.equals(array, smartArray.toArray())) {
            return array;
        } else {
            array = filter();
            return array;
        }
    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription() + " + FilterDecorator";
    }

    @Override
    public int size() {
        return array.length;
    }

}

package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator cmp;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.cmp = cmp;
        array = sorting();

    }

    private Object[] sorting() {
        Object[] newArr = Arrays.copyOf(smartArray.toArray(), smartArray.size());

        Arrays.sort(newArr, cmp);
        return newArr;
    }

    @Override
    public Object[] toArray() {
        if (Arrays.equals(array, smartArray.toArray())) {
            return array;
        } else {
            array = sorting();
            return array;
        }
    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription() + " + SortDecorator";
    }

    @Override
    public int size() {
        return array.length;
    }


}

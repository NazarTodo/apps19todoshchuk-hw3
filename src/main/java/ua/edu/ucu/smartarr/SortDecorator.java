package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator cmp;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.cmp = cmp;
        sorting();

    }

    private void sorting() {
        Object[] newArr = this.smartArray.toArray();
        Arrays.sort(newArr, cmp);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription() + " + SortDecorator";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }


}

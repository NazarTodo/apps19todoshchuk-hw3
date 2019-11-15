package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate pr;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.pr = pr;
        filter();
    }

    private void filter() {
        Object[] newArray = smartArray.toArray();
        for (int j = 0; j < newArray.length; j++) {

            if (!pr.test(newArray[j])) {
                newArray[j] = null;
            }

        }
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription() + " + FilterDecorator";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }

}

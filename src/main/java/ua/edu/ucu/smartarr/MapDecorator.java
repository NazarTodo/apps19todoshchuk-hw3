package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
        map();
    }

    private void map() {
        Object[] newArr = this.smartArray.toArray();
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = func.apply(newArr[i]);
        }
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "MapDecorator";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}

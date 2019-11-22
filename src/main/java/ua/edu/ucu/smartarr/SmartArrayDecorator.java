package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    SmartArray smartArray;
    Object[] array;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
        array = smartArray.toArray();
    }

}

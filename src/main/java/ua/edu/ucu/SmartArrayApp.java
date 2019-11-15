package ua.edu.ucu;


import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;


public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        final int YEAR = 2;
        final int GPA = 4;

        SmartArray arr = new BaseArray(students);
        arr = new DistinctDecorator(arr);
        arr = new FilterDecorator(arr, new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == YEAR
                        && ((Student) t).getGPA() >= GPA;
            }
        });
        arr = new SortDecorator(arr, new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname().compareTo(
                        ((Student) o2).getSurname());
            }
        });
        arr = new MapDecorator(arr, new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname() + " "
                        + ((Student) t).getName();
            }
        });


        Object[] result = arr.toArray();

        return Arrays.copyOf(result, result.length, String[].class);

    }
}

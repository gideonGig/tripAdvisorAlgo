package generics;

import java.util.Comparator;

import streams.StreamT;

public class EmployeeComparator implements Comparator<StreamT.Employee> {

    @Override
    public int compare(StreamT.Employee o1, StreamT.Employee o2) {
       return o1.getSalary().compareTo(o2.getSalary());
    }

}
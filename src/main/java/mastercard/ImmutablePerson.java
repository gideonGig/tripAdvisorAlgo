package mastercard;

import java.util.ArrayList;
import java.util.List;

public final class ImmutablePerson {

    private final int age;
    private final String name;
    private final List<Integer> salaries;

    public ImmutablePerson(int age, String name, List<Integer> salaries) {
        this.age = age;
        this.name = name;
        this.salaries = new ArrayList<>(salaries);
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }
    

    public List<Integer> getSalaries() {
        return new ArrayList<>(salaries);
    }
    
}

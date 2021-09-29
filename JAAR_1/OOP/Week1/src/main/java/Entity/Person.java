package Entity;

public class Person {
    private int age;

    // next oldest sibling of a person is the oldest sibling of that person that is younger than that person
    private Person nextOldestSibling = null;
    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getNextOldestSibling() {
        return nextOldestSibling;
    }

    public void setNextOldestSibling(Person nextOldestSibling) {
        this.nextOldestSibling = nextOldestSibling;
    }
}

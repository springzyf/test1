package mytest;

public class Person {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

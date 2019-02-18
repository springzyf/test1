package mytest;

public class PersonTempVO {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int hashCode() {
        int hash = 0;
        hash += (age != null ? age.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PersonTempVO) {
            PersonTempVO p = (PersonTempVO) obj;
            return this.age != null && this.age.equals(p.getAge());
        }
        return false;
    }

}

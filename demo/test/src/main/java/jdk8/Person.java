package jdk8;

public interface Person {

    void run();

    default void breathe(){
        System.out.println("呼吸新鲜空气");
    }
}

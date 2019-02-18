package jdk8;

@FunctionalInterface
public interface FunctionalInterfaceTest {
    int test1(int a ,int b);

    default void test2(){
        System.out.println("test2");
    }
}

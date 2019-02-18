package springaop;

public class CanLogin implements Subject {
    @Override
    public void login() {
        System.out.println("正在登陆...");
    }
}

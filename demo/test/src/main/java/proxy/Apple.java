package proxy;

public class Apple implements Sell{
    @Override
    public void sell() {
        System.out.println("卖苹果拉！");
    }
}

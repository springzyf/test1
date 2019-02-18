package adapet;


public class WindowImpl extends WindowAdapet {
    @Override
    public void open() {
        System.out.println("打开窗口");
    }

    @Override
    public void close() {
        System.out.println("关闭窗口");
    }
}

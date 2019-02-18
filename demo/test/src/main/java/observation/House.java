package observation;

import java.util.Observable;

public class House extends Observable {
    private float price;


    public float getPrice() {
        return price;
    }

    public House() {
    }

    public void setPrice(float price) {
        this.setChanged();//设置变化点
        this.notifyObservers(price);//通知所有观察者
        this.price = price;
    }

    public House(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "House{" +
                "price=" + price +
                '}';
    }
}

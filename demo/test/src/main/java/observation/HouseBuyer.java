package observation;

import java.util.Observable;
import java.util.Observer;

public class HouseBuyer implements Observer {

    private String name;

    public HouseBuyer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HouseBuyer() {
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Float){
            System.out.println(this.name + "观察后，发现，房价变更为："+Float.parseFloat(arg.toString()));
        }
    }
}

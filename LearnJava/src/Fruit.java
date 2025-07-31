public class Fruit implements ItemStuff{
    private String name;
    private int quantity;
    private  String type;

    public void setType(String type) {
        this.type = type;
    }

    public Fruit(String name, int quantity, String type) {
        this.name=name;
        this.quantity=quantity;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='"+ getName() + '\'' +
                ", quantity=" +getQuantity()+
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void displayInfo() {

    }
}


public class Weapon extends Item{
    private int damage;
    private String type;

    public Weapon(String name, int quantity, int damage, String type) {
        this.damage = damage;
        this.type = type;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }
//polymorphism
    @Override
    public String displayInfo() {
        return "Weapon{ " +
                "name=" +getName() +
                ", quantity=" +getQuantity() +
                ", damage=" + getDamage() +
                ", type='" + getType() + '\'' +
                '}';
    }

}

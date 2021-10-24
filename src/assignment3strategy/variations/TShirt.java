package assignment3strategy.variations;

public class TShirt {

    private static int latestID = 1;
    private int id;
    private Color color;
    private Size size;
    private Fabric fabric;
    private double price;

    public TShirt(Color color, Size size, Fabric fabric) {
        this.id = latestID++;
        this.color = color;
        this.size = size;
        this.fabric = fabric;
        calculatePrice();//ypologizei kai settarei thn timh analoga me ta color,size,fabric
    }

    private void calculatePrice() {//arxiki timh 20 + analoga tis times twn fields
        price = (20 + (double) (this.getColor().ordinal() * 0.5)
                + (double) (this.getSize().ordinal() * 0.5)
                + (double) (this.getFabric().ordinal() * 0.5));
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TShirt{id=").append(id);
        sb.append(", color=").append(color);
        sb.append(", size=").append(size);
        sb.append(", fabric=").append(fabric);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}

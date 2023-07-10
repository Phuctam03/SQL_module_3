package pratice.applicationproduct.model;

public class Product {
    private  int id ;
    private  String nameProduct;
    private  double price;
    private String describeProduct;
    private  String manufacturers;

    public  Product(){}

    public Product(int id, String nameProduct, double price, String describeProduct, String manufacturers) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.describeProduct = describeProduct;
        this.manufacturers = manufacturers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }
}

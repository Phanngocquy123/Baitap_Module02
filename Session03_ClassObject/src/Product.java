public class Product {
    private String id;
    private String name;
    private Double price;
    private Double discount;
    private Double salePrice;

    public Product() {
    }

    public Product(String id, String name, Double price, Double discount, Double salePrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.salePrice = salePrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDiscount() {
        return discount;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public void calculateSalePrice(){
        this.salePrice = price - (price/100*discount);
    }
}

package model;

public class Product {
    private Integer id ;
    private String name ;
    private String price ;
    private String quantity ;
    private Integer color ;
    private Integer categoryName ;

    public Product() {
    }

    public Product(String name, String price, String quantity, Integer color, Integer categoryName) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.categoryName = categoryName;
    }

    public Product(Integer id, String name, String price, String quantity, Integer color, Integer categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Integer categoryName) {
        this.categoryName = categoryName;
    }
}

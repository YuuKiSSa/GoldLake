package sg.edu.nus.goldlake.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String name;
    private double retailPrice;

    @Column(length = 50)
    private String description;

    @Column(length = 10)
    private String category;

    @Column(length = 10)
    private String supplierId;

    public Product(){
        super();
    }

    public Product(String name, double retailPrice, String description, String category, String supplierId) {
        super();
        this.name = name;
        this.retailPrice = retailPrice;
        this.description = description;
        this.category = category;
        this.supplierId = supplierId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getRetailPrice() {
        return retailPrice;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public String getSupplierId() {
        return supplierId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
}

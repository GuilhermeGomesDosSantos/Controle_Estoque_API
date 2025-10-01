package controleEstoqueAPI.Controle.Estoque.domain.Product;

import controleEstoqueAPI.Controle.Estoque.domain.Weight.Weight;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Product")
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer amount;
    private double price;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String brand;
    @Embedded
    private Weight weight;

    private LocalDate data_Created;
    private LocalDate last_Update;

    public Product(){}
    public Product(registerProductDTO data){
        this.name = data.name();
        this.amount = data.amount();
        this.price = data.price();
        this.category = data.category();
        this.brand = data.brand();
        this.weight = new Weight(data.weight());
        this.data_Created = LocalDate.now();
        this.last_Update = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public Weight getWeight() {
        return weight;
    }

    public LocalDate getData_Created() {
        return data_Created;
    }

    public LocalDate getLast_Update() {
        return last_Update;
    }
}

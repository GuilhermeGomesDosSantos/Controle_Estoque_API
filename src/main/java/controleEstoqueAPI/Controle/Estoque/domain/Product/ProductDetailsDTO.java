package controleEstoqueAPI.Controle.Estoque.domain.Product;

import controleEstoqueAPI.Controle.Estoque.domain.Weight.Weight;

import java.time.LocalDate;

public record ProductDetailsDTO(Long id, String name, Integer amount, double price, Category category, String brand, Weight weight, LocalDate createdAt, LocalDate lastUpdate) {
    public ProductDetailsDTO(Product product){
        this(product.getId(), product.getName(), product.getAmount(), product.getPrice(), product.getCategory(), product.getBrand(), product.getWeight(), product.getData_Created(), product.getLast_Update());
    }
}

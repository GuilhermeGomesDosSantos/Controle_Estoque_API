package controleEstoqueAPI.Controle.Estoque.domain.Product;

import controleEstoqueAPI.Controle.Estoque.domain.Weight.ProductDetailsWeight;
import jakarta.validation.constraints.NotNull;

public record UpdateProductDTO(
        @NotNull
        Long id,
        String name,
        Integer amount,
        Double price,
        Category category,
        String brand,
        ProductDetailsWeight weight
) {
}

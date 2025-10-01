package controleEstoqueAPI.Controle.Estoque.domain.Weight;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class Weight {
    private BigDecimal value_;
    private String unit;

    public Weight(){}

    public Weight(ProductDetailsWeight productDetailsWeight){
        this.value_ = productDetailsWeight.value_();
        this.unit = productDetailsWeight.unit();
    }

    public BigDecimal getValue() {
        return value_;
    }

    public String getUnit() {
        return unit;
    }
}

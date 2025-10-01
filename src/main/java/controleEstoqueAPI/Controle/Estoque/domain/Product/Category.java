package controleEstoqueAPI.Controle.Estoque.domain.Product;

public enum Category {
    HORTIFRUTI("Hortifruti"),
    BEBIDAS("Bebidas"),
    PADARIA("Padaria"),
    AÇOUGUE("Açougue"),
    FRIOS("frios"),
    LATICÍNIOS("laticínios"),
    LIMPEZA("limpeza"),
    HIGIENE_PESSOAL("higiene pessoal"),
    CONGELADOS("congelados"),
    PETSHOP("pet shop"),
    UTILIDADES("utilidades"),
    MERCEARIA("mercearia");

    private String categoria;

    Category(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria(){
        return categoria;
    }
}

package controleEstoqueAPI.Controle.Estoque.Usuario;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String role;

    public Usuario(){}

    public Usuario (userDTO userDTO){
        this.login = userDTO.login();
        this.password = userDTO.password();
        this.role = userDTO.role();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

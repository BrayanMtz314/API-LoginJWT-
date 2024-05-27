package brayan.demojwt.User;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuario", uniqueConstraints = {@UniqueConstraint(columnNames = ("username"))})
public class User implements UserDetails {

    @Id
    @GeneratedValue
    Integer id;
    @Column(name = "username", nullable = false)
    String username;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "materno")
    String materno;
    @Column(name = "paterno")
    String paterno;
    @Column(name = "matricula")
    int matricula;
    @Column(name = "dependencia")
    int dependencia;
    @Column(name = "password")
    String password;
    @Enumerated(EnumType.STRING)
    Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

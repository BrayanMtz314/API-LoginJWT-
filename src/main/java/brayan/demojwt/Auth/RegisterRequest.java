package brayan.demojwt.Auth;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String correo;
    String password;
    String nombre;
    String materno;
    String paterno;
    int matricula;
    int rolId;
    int dependenciaID;
}

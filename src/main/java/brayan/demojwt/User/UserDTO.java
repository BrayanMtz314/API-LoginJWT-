package brayan.demojwt.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    int id;
    String username;
    String nombre;
    String materno;
    String paterno;
    int matricula;
    int dependenciaId;
}

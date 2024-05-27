package brayan.demojwt.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User usuario) {
        UserDTO dto = new UserDTO();
        dto.setId(usuario.getId());
        dto.setFirstname(usuario.getFirstname());
        dto.setLastname(usuario.getLastname());
        dto.setUsername(usuario.getUsername());
        dto.setCountry(usuario.getCountry());
        return dto;
    }
}

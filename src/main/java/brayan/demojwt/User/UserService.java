package brayan.demojwt.User;

import jakarta.transaction.Transactional; // Revisa si usas la correcta
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

//    @Transactional
//    public UserResponse updateUser(UserRequest userRequest){
//        User user = User.builder()
//                .id(userRequest.getId()) // Suponiendo que UserRequest tiene un getter
//                .nombre(userRequest.getNombre())
//                .materno(userRequest.getMaterno())
//                .paterno(userRequest.getPaterno())
//                .dependenciaId(userRequest.getDependenciaId())
//                .matricula(userRequest.getMatricula())
//                .role(Role.USER)
//                .build();
//        userRepository.updateUser(user.getId(), user.getFirstname(), user.getLastname(), user.getCountry());
//        return new UserResponse("El usuario se registró satisfactoriamente");
//    }

    public UserDTO getUser(Integer id){
        User user = userRepository.findById(id).orElse(null);

        if(user != null){
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .nombre(user.getNombre())
                    .paterno(user.getPaterno()) // Corregido
                    .materno(user.getMaterno())
                    .matricula(user.getMatricula())
                    .dependenciaId(user.getDependencia())
                    .build();
            return userDTO;
        }
        return null;
    }
    public UserDTO getUseByUsername(String username){
        User user = userRepository.findByUsername(username).orElse(null);
        if(user != null){
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .nombre(user.getNombre())
                    .paterno(user.getPaterno()) // Corregido
                    .materno(user.getMaterno())
                    .matricula(user.getMatricula())
                    .dependenciaId(user.getDependencia())
                    .build();
            return userDTO;
        }
        return null;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .nombre(user.getNombre())
                        .materno(user.getMaterno())
                        .paterno(user.getPaterno())
                        .dependenciaId(user.getDependencia())
                        .matricula(user.getMatricula())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public void insertarUsuario(User user) {
        userRepository.insertarUsuario(
                user.getNombre(),
                user.getPaterno(),
                user.getMaterno(),
                user.getMatricula(),
                user.getUsername(),
                user.getRole().toString(),
                user.getDependencia(),
                user.getPassword()
        );
    }



}

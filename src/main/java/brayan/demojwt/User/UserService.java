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

    @Transactional
    public UserResponse updateUser(UserRequest userRequest){
        User user = User.builder()
                .id(userRequest.getId()) // Suponiendo que UserRequest tiene un getter
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .country(userRequest.getCountry())
                .role(Role.USER)
                .build();
        userRepository.updateUser(user.getId(), user.getFirstname(), user.getLastname(), user.getCountry());
        return new UserResponse("El usuario se registró satisfactoriamente");
    }

    public UserDTO getUser(Integer id){
        User user = userRepository.findById(id).orElse(null);

        if(user != null){
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname()) // Corregido
                    .country(user.getCountry())
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
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname()) // Corregido
                    .country(user.getCountry())
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
                        .firstname(user.getFirstname()
)                       .lastname(user.getLastname())
                        .country(user.getCountry())
                        .build())
                .collect(Collectors.toList());
    }


}

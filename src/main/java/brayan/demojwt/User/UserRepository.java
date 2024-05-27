package brayan.demojwt.User;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

//    @Modifying()
//    @Query("update User u set u.firstname=:firstname, u.lastname=:lastname, u.country=:country where u.id=:id")
//    void updateUser(@Param(value = "id") Integer id, @Param(value = "firstname") String firstname, @Param(value = "lastname") String lastname, @Param(value = "country") String country);

    @Modifying
    @Query(value = "EXEC InsertarUsuario @nombre= :nombre, @paterno= :paterno,@materno= :materno,@matricula= :matricula,@username= :username,@role= :role,@dependencia= :dependencia,@password= :password", nativeQuery = true)
    void insertarUsuario(
            @Param("nombre") String nombre,
            @Param("paterno") String paterno,
            @Param("materno") String materno,
            @Param("matricula") int matricula,
            @Param("username") String username,
            @Param("role") String role,
            @Param("dependencia") int dependencia,
            @Param("password") String password
    );

//    @Query(value = "EXEC ObtenerUsuarioConRol @username = :username", nativeQuery = true)
//    Optional<User> findUserByUsernameWithRole(@Param("username") String username);

}

package mx.ulsa.josiaslpsw.repository;

import mx.ulsa.josiaslpsw.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByEmail(String email);
}

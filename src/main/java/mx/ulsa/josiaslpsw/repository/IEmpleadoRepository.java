package mx.ulsa.josiaslpsw.repository;

import mx.ulsa.josiaslpsw.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado,Long> {
}

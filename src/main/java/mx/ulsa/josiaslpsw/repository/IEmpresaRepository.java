package mx.ulsa.josiaslpsw.repository;

import mx.ulsa.josiaslpsw.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa,Long> {
}

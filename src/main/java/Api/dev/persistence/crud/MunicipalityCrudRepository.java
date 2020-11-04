package Api.dev.persistence.crud;

import Api.dev.entities.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityCrudRepository extends JpaRepository<Municipality, Integer> {
}

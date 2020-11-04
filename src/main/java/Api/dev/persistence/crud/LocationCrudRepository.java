package Api.dev.persistence.crud;

import Api.dev.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationCrudRepository extends JpaRepository<Location, Integer> {
}

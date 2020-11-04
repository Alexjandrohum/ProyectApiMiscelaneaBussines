package Api.dev.persistence.crud;

import Api.dev.entities.Polity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolityCrudRepository extends JpaRepository<Polity, Integer> {
}

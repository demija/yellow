package ba.gabela.yellow.database.repository;

import ba.gabela.yellow.database.model.Market.Relational.MarketDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<MarketDTO, String> {
}

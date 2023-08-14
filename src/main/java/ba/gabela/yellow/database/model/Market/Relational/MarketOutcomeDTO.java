package ba.gabela.yellow.database.model.Market.Relational;

import ba.gabela.yellow.database.model.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "market_outcome")
@Getter
@Setter
public class MarketOutcomeDTO {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusEnum status;
}

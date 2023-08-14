package ba.gabela.yellow.database.model.Event.Relational;

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
@Table(name = "event_market_outcome")
@Getter
@Setter
public class EventMarketOutcomeDTO {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "outcome_id")
    private String outcomeId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "odds")
    private Double odds;
}

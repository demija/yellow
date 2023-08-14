package ba.gabela.yellow.database.model.Event.Relational;

import ba.gabela.yellow.database.model.StatusEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event_market")
@Getter
@Setter
public class EventMarketDTO {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "market_id")
    private String marketId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "outcomes")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_market_id", referencedColumnName = "id")
    private List<EventMarketOutcomeDTO> outcomes = new ArrayList<>();
}

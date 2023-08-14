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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event")
@Getter
@Setter
public class EventDTO {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "starts_at")
    private LocalDateTime startsAt;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "markets")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private List<EventMarketDTO> markets = new ArrayList<>();
}

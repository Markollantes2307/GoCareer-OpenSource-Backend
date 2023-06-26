package goodstart.gocareer.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "careers")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name", length = 40, nullable = false)
    private String Name;
    @Column(name = "description", length = 100, nullable = false)
    private String Description;
    @Column(name = "payment", nullable = false)
    private Float Payment;
}

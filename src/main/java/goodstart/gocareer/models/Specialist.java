package goodstart.gocareer.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "psychologists")
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name", length = 40, nullable = false)
    private String Name;
    @Column(name="specialty",length = 30, nullable = false)
    private String Specialty;

    @ManyToOne
    @JoinColumn(name = "date_id",nullable = false,foreignKey = @ForeignKey(name = "FK_DATE_ID"))
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date date;
}

package goodstart.gocareer.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "alt1", length = 20, nullable = false)
    private String Alternative1;
    @Column(name = "alt2", length = 20, nullable = false)
    private String Alternative2;
    @Column(name = "alt3", length = 20, nullable = false)
    private String Alternative3;
    @Column(name = "alt4", length = 20, nullable = false)
    private String Alternative4;
    @Column(name = "score",nullable = false)
    private Integer Score;

    @ManyToOne
    @JoinColumn(name = "test_id",nullable = false,foreignKey = @ForeignKey(name = "FK_TEST_ID"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Test test;
}

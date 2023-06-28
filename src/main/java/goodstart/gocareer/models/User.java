package goodstart.gocareer.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name", length = 40, nullable = false)
    private String Name;
    @Column(name = "email", length = 40, nullable = false)
    private String Email;
    @Column(name = "username", length = 20, nullable = false)
    private String Username;
    @Column(name = "password", length = 10, nullable = false)
    private String Password;
    @Column(name = "phone", length = 9, nullable = false)
    private Long Phone;
    @Column(name = "birthdate",nullable = false)
    private LocalDate Birthdate;
    @Column(name = "resume", length = 200, nullable = false)
    private String Resume;

    @ManyToOne
    @JoinColumn(name = "date_id",nullable = false,foreignKey = @ForeignKey(name = "FK_DATE_ID"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "career_id",nullable = false,foreignKey = @ForeignKey(name = "FK_CAREER_ID"))
    private Career career;
}

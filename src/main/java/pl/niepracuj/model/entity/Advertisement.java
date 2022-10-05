package pl.niepracuj.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "advertisement")
@NoArgsConstructor
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Instant publishDate;
    private Instant expireDate;
    private Long salaryFrom;
    private Long salaryTo;
    private String description;


    @ManyToOne //wiele ogłoszeń może być z jednej firmy
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne
    private Technology technology;

    @ManyToOne
    private Seniority seniority;

    @ManyToOne
    private City city;

    //łączenie kolumn, wygenerowanie tabeli pośredniczącej pomiędzy advertisement a skill
    @ManyToMany
    @JoinTable(
            name = "adv_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "adv_id")
    )
    Set<Skill> skills;


}

package pl.niepracuj.model.entity;

import lombok.*;
import pl.niepracuj.model.enums.TechnologyEnum;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "technologies")
@NoArgsConstructor
@AllArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) //zamiana nazwy technologii na enuma. Wartości słownikowe
    private TechnologyEnum name;

}

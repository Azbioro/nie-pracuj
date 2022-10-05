package pl.niepracuj.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.niepracuj.model.enums.TechnologyEnum;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "technologies")
@NoArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) //zamiana nazwy technologii na enuma. Wartości słownikowe
    private TechnologyEnum name;


}

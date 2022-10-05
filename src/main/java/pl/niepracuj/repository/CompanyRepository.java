package pl.niepracuj.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.niepracuj.model.entity.Advertisement;
import pl.niepracuj.model.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
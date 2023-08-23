package br.com.quinze.repository;

import br.com.quinze.model.CombinationNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombinationNumberRepository extends JpaRepository<CombinationNumber, Long> {
    //List<CombinationNumber> findByIdAndData(Long id, LocalDateTime data);
}

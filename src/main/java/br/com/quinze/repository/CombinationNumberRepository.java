package br.com.quinze.repository;

import br.com.quinze.model.CombinationNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface CombinationNumberRepository extends JpaRepository<CombinationNumber, Long> {

    @Override
    List<CombinationNumber> findAll();
}

package edu.ci.jpa.repository;

import edu.ci.jpa.entity.Bateau;
import edu.ci.jpa.entity.Commandant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @création 23/06/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.repository
 */

@Repository
public interface CommandantRepository extends JpaRepository<Commandant, Long> {

}

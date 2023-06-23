package edu.ci.jpa.repository;

import edu.ci.jpa.entity.Bateau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @création 23/06/2023
 * @projet jpa
 * @auteur tsyta.diallo
 * @package edu.ci.jpa.repository
 */

@Repository
public interface BateauRepository extends JpaRepository<Bateau, Long> {
}

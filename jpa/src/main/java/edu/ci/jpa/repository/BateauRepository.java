package edu.ci.jpa.repository;

import edu.ci.jpa.entity.Bateau;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.ObjectProvider;
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
public interface BateauRepository extends JpaRepository<Bateau, Long> {

    @Query(value = "select b from Bateau b where b.commandant.name=:name")
    Optional<Bateau> findByName(String name);
    @Transactional
    @Modifying
    @Query(value = "update Bateau b set b.capacite=:capacite, b.equipage=:equipage where b.id=:id")
    void updateBatau(Long id, Integer capacite, Integer equipage);
    @Query(value = "select b.* from bateaux b, commandants c where c.id_bateau=b.id and c.name=:name", nativeQuery = true)
    Optional<Bateau> findByNameNative(String name);
}

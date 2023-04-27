package com.testNDS.NDS.karyawan;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface KaryawanRepository extends CrudRepository<Karyawan, Long> {
    @Query(value = "select * from karyawan where nama like %:keyword% or no_hp like %:keyword% or tanggal_masuk >= :startDate AND tanggal_masuk <= :endDate", nativeQuery = true)
    List<Karyawan> findByKeyword(@Param("keyword") String keyword, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}

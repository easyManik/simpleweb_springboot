package com.testNDS.NDS;

import com.testNDS.NDS.karyawan.Karyawan;
import com.testNDS.NDS.karyawan.KaryawanRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class KaryawanRepositoryTest {
    @Autowired private KaryawanRepository repo;

    @Test
    public void testAddNew(){
        Karyawan karyawan = new Karyawan();
        karyawan.setNoHp("081234567890");
        karyawan.setNama("Easy Manik");
        karyawan.setLimitReimb("12");
        karyawan.setTanggalMasuk(Date.valueOf("2023-04-17"));
        karyawan.setCreatedDate(Date.valueOf("2023-04-17"));
        karyawan.setUpdatedDate(Date.valueOf("2023-04-17"));

        Karyawan saveKaryawan = repo.save(karyawan);

        Assertions.assertThat(saveKaryawan).isNotNull() ;
        Assertions.assertThat(saveKaryawan.getKode()).isGreaterThan(0);


    }

    @Test
    public void testListAll(){
        Iterable<Karyawan> karyawans = repo.findAll();
        org.assertj.core.api.Assertions.assertThat(karyawans).hasSizeGreaterThan(0);

        for(Karyawan karyawan:karyawans){
            System.out.println(karyawan);
        }
    }

    @Test
    public void testUpdate(){
        String karyawanKode = "1";
        Optional<Karyawan> optionalKaryawan = repo.findById(UUID.fromString(karyawanKode));
        Karyawan karyawan = optionalKaryawan.get();
        karyawan.setNama("easy");
        repo.save(karyawan);

        Karyawan updatedKaryawan = repo.findById(UUID.fromString(karyawanKode)).get();
        Assertions.assertThat(updatedKaryawan.getNama()).isEqualTo("easy");
    }

    @Test
    public void testGet(){
        String karyawanKode = "1";
        Optional<Karyawan> optionalKaryawan = repo.findById(UUID.fromString(karyawanKode));
        Assertions.assertThat(optionalKaryawan).isPresent();
        System.out.println(optionalKaryawan.get());
    }

    @Test
    public void testDelete(){
        String karyawanKode= "1";
        repo.deleteById(UUID.fromString(karyawanKode));
        Optional<Karyawan> optionalKaryawan = repo.findById(UUID.fromString(karyawanKode));
        Assertions.assertThat(optionalKaryawan).isNotPresent();

    }
}

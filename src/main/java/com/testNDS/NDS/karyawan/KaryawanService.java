package com.testNDS.NDS.karyawan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.tokens.Token;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KaryawanService {
    @Autowired private KaryawanRepository repo;

    public List<Karyawan> listAll(){
        return (List<Karyawan>) repo.findAll();
    }

    public void save(Karyawan karyawan) {
        repo.save(karyawan);
    }

    public Karyawan get(Long kode) throws NotFoundException {
        Optional<Karyawan> result = repo.findById(kode);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException("No Kode Found" + kode);
    }

    public void delete(Long kode){
        repo.deleteById(kode);
    }

    public List<Karyawan> getAll(){
        List<Karyawan> list = (List<Karyawan>) repo.findAll();
        return list;
    }

    public List<Karyawan> getByKeyword(String keyword, LocalDateTime startDate, LocalDateTime endDate){
        return repo.findByKeyword(keyword, startDate, endDate);
    }

}

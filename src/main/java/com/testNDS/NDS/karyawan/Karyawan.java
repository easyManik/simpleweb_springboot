package com.testNDS.NDS.karyawan;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "karyawan")
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long kode;
    @Column(nullable = false, length = 45, unique = true)
    private String nama;
    @Column(nullable = false, name = "tanggal_masuk")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMasuk;
    @Column(length = 15, nullable = false, name = "no_hp")
    private String noHp;
    @Column(length = 20, nullable = false, name = "limit_reimb")
    private String limitReimb;
    @Column(nullable = false, name = "created_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
    @Column(nullable = false, name = "updated_name")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedDate;

    public Long getKode() {
        return kode;
    }

    public void setKode(Long kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getLimitReimb() {
        return limitReimb;
    }

    public void setLimitReimb(String limitReimb) {
        this.limitReimb = limitReimb;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Karyawan{" +
                "kode=" + kode +
                ", nama='" + nama + '\'' +
                ", tanggalMasuk=" + tanggalMasuk +
                ", noHp='" + noHp + '\'' +
                ", limitReimb='" + limitReimb + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}

package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Air {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String co; // 일산화탄소농도(ppm)
    private String so2; // 아황산가스농도(ppm)
    private String msrrgn_nm; // 권역명
    private String idex_mvl; // 통합대기환경지수
    private String o3; // 오존(ppm)
    private String no2; // 이산화질소농도(ppm)
    private String idex_nm; // 통합대기환경등급
    private String pm10; // 미세먼지(㎍/㎥)
    private String msrdt; // 측정일시
    private String arplt_main; // 지수결정물질
    private String pm25; // 초미세먼지농도(㎍/㎥)
    private String msrste_nm; // 측정소명

    @Builder
    public Air(Integer id, String co, String so2, String msrrgn_nm, String idex_mvl, String o3, String no2,
            String idex_nm, String pm10, String msrdt, String arplt_main, String pm25, String msrste_nm) {
        this.id = id;
        this.co = co;
        this.so2 = so2;
        this.msrrgn_nm = msrrgn_nm;
        this.idex_mvl = idex_mvl;
        this.o3 = o3;
        this.no2 = no2;
        this.idex_nm = idex_nm;
        this.pm10 = pm10;
        this.msrdt = msrdt;
        this.arplt_main = arplt_main;
        this.pm25 = pm25;
        this.msrste_nm = msrste_nm;
    }
}
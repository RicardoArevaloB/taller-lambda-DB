package com.skeletonhexa.domain.entities;

public class Estadisticas {
    private int id;
    private int equipo_id;
    private String pj;
    private String pg;
    private String pe;
    private String pp;
    private String gf;
    private String gc;
    private String tp;
    public Estadisticas(int id, int equipo_id, String pj, String pg, String pe, String pp, String gf, String gc,
            String tp) {
        this.id = id;
        this.equipo_id = equipo_id;
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gf = gf;
        this.gc = gc;
        this.tp = tp;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEquipo_id() {
        return equipo_id;
    }
    public void setEquipo_id(int equipo_id) {
        this.equipo_id = equipo_id;
    }
    public String getPj() {
        return pj;
    }
    public void setPj(String pj) {
        this.pj = pj;
    }
    public String getPg() {
        return pg;
    }
    public void setPg(String pg) {
        this.pg = pg;
    }
    public String getPe() {
        return pe;
    }
    public void setPe(String pe) {
        this.pe = pe;
    }
    public String getPp() {
        return pp;
    }
    public void setPp(String pp) {
        this.pp = pp;
    }
    public String getGf() {
        return gf;
    }
    public void setGf(String gf) {
        this.gf = gf;
    }
    public String getGc() {
        return gc;
    }
    public void setGc(String gc) {
        this.gc = gc;
    }
    public String getTp() {
        return tp;
    }
    public void setTp(String tp) {
        this.tp = tp;
    }

    

}

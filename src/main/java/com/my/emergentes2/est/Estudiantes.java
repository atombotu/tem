package com.my.emergentes2.est;

public class Estudiantes {

    private int id;
    private String Nombre;
    private int p1;
    private int p2;
    private int p3;
   

    public Estudiantes() {
        this.id = 0;
        this.Nombre = "";
        this.p1 = 0;
        this.p2 = 0;
        this.p3 = 0;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getP3() {
        return p3;
    }

    public void setP3(int p3) {
        this.p3 = p3;
    }

}

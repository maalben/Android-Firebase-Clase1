package com.enterprise.clase1;

public class Clase {

    private String id, seccion, area, tema;

    public Clase(String id, String seccion, String area, String tema) {
        this.id = id;
        this.seccion = seccion;
        this.area = area;
        this.tema = tema;
    }

    public String getId() {
        return id;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getArea() {
        return area;
    }

    public String getTema() {
        return tema;
    }
}

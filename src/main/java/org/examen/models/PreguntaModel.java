package org.examen.models;

public class PreguntaModel {
    private String id;
    private String asignatura_id;
    private String enunciado;
    private String a;
    private String b;
    private String c;
    private String d;
    private String solucion;

    public PreguntaModel(String id, String asignatura_id, String enunciado, String a, String b, String c, String d, String solucion) {
        this.id = id;
        this.asignatura_id = asignatura_id;
        this.enunciado = enunciado;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.solucion = solucion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsignatura_id() {
        return asignatura_id;
    }

    public void setAsignatura_id(String asignatura_id) {
        this.asignatura_id = asignatura_id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
}

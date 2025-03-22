package entidades;

import interfaces.IMedalla;

public class Medalla implements IMedalla {

    private String name;
    private String descripcion;

    public Medalla(String name, String descripcion) {
        this.name = name;
        this.descripcion = descripcion;
    }

    @Override
    public String getNameMedalla() {
        return this.name;
    }

    @Override
    public void setNameMedalla(String nameMedalla) {
        this.name = nameMedalla;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Medalla{" +
                "name='" + this.name + '\'' +
                ", descripcion='" + this.descripcion + '\'' +
                '}';
    }
}

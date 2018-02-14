package com.jrogerio.ciudadesrecycler;

/**
 * Created by jrogerio on 14/02/18.
 */

public class Ciudad {
    private String nombre;
    private int habitantes;
    private String urlPhoto;
    private String provincia;

    public Ciudad(String nombre, int habitantes, String urlPhoto, String provincia) {
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.urlPhoto = urlPhoto;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ciudad ciudad = (Ciudad) o;

        if (habitantes != ciudad.habitantes) return false;
        if (nombre != null ? !nombre.equals(ciudad.nombre) : ciudad.nombre != null) return false;
        if (urlPhoto != null ? !urlPhoto.equals(ciudad.urlPhoto) : ciudad.urlPhoto != null)
            return false;
        return provincia != null ? provincia.equals(ciudad.provincia) : ciudad.provincia == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + habitantes;
        result = 31 * result + (urlPhoto != null ? urlPhoto.hashCode() : 0);
        result = 31 * result + (provincia != null ? provincia.hashCode() : 0);
        return result;
    }
}

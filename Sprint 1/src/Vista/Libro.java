/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author MILTON
 */
public class Libro {


    private int id;
    private String isbn;
    private String titulo;
    private int cant_paginas;
    private float precio;
    private String fecha_lanzamiento;
    private String resumen;
    private String primeras_paginas;
    private int autor_id;
    private int idioma_id;

    public Libro(int id, String isbn, String titulo, int cant_paginas, float precio, String fecha_lanzamiento, String resumen, String primeras_paginas, int autor_id, int idioma_id) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.cant_paginas = cant_paginas;
        this.precio = precio;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.resumen = resumen;
        this.primeras_paginas = primeras_paginas;
        this.autor_id = autor_id;
        this.idioma_id = idioma_id;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCant_paginas() {
        return cant_paginas;
    }

    public void setCant_paginas(int cant_paginas) {
        this.cant_paginas = cant_paginas;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(String fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getPrimeras_paginas() {
        return primeras_paginas;
    }

    public void setPrimeras_paginas(String primeras_paginas) {
        this.primeras_paginas = primeras_paginas;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    public int getIdioma_id() {
        return idioma_id;
    }

    public void setIdioma_id(int idioma_id) {
        this.idioma_id = idioma_id;
    }
    
    
    
}

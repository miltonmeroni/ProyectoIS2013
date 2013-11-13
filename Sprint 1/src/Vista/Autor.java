/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author MILTON
 */
public class Autor{
    private int id;
    private String nombre;
    private String apellido;
    private int pais_id;
    private String fecha_nacimiento;
    private String sexo;
    private String acerca_de;

    public Autor(int id, String nombre, String apellido, int pais_id, String fecha_nacimiento, String sexo, String acerca_de) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais_id = pais_id;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.acerca_de = acerca_de;
    }   
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAcerca_de() {
        return acerca_de;
    }

    public void setAcerca_de(String acerca_de) {
        this.acerca_de = acerca_de;
    }
}

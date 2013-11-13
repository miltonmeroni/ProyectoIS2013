/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;


import Vista.Autor;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Vista.Libro;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author MILTON
 */
public class Operaciones extends Conexion{
    
    public boolean insertar(String sql){
        boolean valor = true;
        conectar();
        
        try {
            consulta.executeUpdate(sql);
        }catch(SQLException e) {
                valor = false;
                JOptionPane.showMessageDialog(null, e.getMessage());
            }      
        finally{  
            try{    
                 consulta.close();  
                 conexion.close();  
             }catch (Exception e){                 
                 e.printStackTrace();  
             }  
        }
        return valor;
    }
    
    public ResultSet consultar(String sql){
        conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);

        } catch(SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
            }
        return resultado;
    }
    
     public void modificarLibro(Libro libro){
        try{        
        this.conectar();     
        int cantidad = consulta.executeUpdate("update libros "
                    + "set isbn='"+libro.getIsbn()+"'"
                    + "," + "titulo='"+libro.getTitulo()+"'"
                    + "," + "cant_paginas="+libro.getCant_paginas()
                    + "," + "precio=" +libro.getPrecio()
                    + "," + "fecha_lanzamiento='"+libro.getFecha_lanzamiento()+"'"
                    + "," + "resumen='"+libro.getResumen()+"'"
                    + "," + "primeras_paginas='"+libro.getPrimeras_paginas()+"'"
                    + "," + "autor_id=" + libro.getAutor_id()
                    + "," + "idioma_id=" + libro.getIdioma_id()
                    + " where id="+libro.getId()); 
                    
        
         if (cantidad==1) {           
            JOptionPane.showMessageDialog(null,"Se modifico con éxito el libro");
          }else {
            JOptionPane.showMessageDialog(null,"No se pudo modificar el libro"+"update libros "
                    + "set isbn='"+libro.getIsbn()+"'"
                    + "," + "titulo='"+libro.getTitulo()+"'"
                    + "," + "cant_paginas="+libro.getCant_paginas()
                    + "," + "precio=" +libro.getPrecio()
                    + "," + "fecha_lanzamiento='"+libro.getFecha_lanzamiento()+"'"
                    + "," + "resumen='"+libro.getResumen()+"'"
                    + "," + "primeras_paginas='"+libro.getPrimeras_paginas()+"'"
                    + "," + "autor_id=" + libro.getAutor_id()
                    + "," + "idioma_id=" + libro.getIdioma_id()
                    + " where id="+libro.getId());
          }
          conexion.close();
        }catch(SQLException ex){
          System.out.println("MAL");
          //setTitle(ex.toString()); hay que agregar algo aca ! ! !  ! !******
        }
    }            
    
    public void eliminarLibro(int id){
        try {
          conectar();
          int cantidad = consulta.executeUpdate("delete from libros where id="+id);
          if (cantidad==1) {           
            JOptionPane.showMessageDialog(null,"Se elimino");
          } else {
            JOptionPane.showMessageDialog(null,"No existe el ID ingresado");
          }
          conexion.close();
        } catch(SQLException ex){
          //setTitle(ex.toString()); hay que agregar algo aca ! ! !  ! !******
        }        
    
    }
    
    public void guardarLibro(Libro libro){
        insertar("insert into libros (isbn,titulo,cant_paginas,precio,fecha_lanzamiento,resumen,primeras_paginas,autor_id,idioma_id) values('"+libro.getIsbn()                    
                    +"','"+libro.getTitulo()
                    +"','"+libro.getCant_paginas()
                    +"','"+libro.getPrecio()+"','"+libro.getFecha_lanzamiento()
                    +"','"+libro.getResumen()+"','"+libro.getPrimeras_paginas()
                    +"','"+libro.getAutor_id()+"','"+libro.getIdioma_id()+"')");
    } 
    
    public void guardarAutor(Autor autor){
        insertar("insert into autores (nombre,apellido,pais_id,fecha_nacimiento,sexo,acerca_de) values('"+autor.getNombre()
                    +"','"+autor.getApellido()
                    +"','"+autor.getPais_id()
                    +"','"+autor.getFecha_nacimiento()+"','"+autor.getSexo()
                    +"','"+autor.getAcerca_de()+"')");
    
    }
    
    public void guardarPais(String pais){
        insertar("insert into paises (nombre) values('"+pais+"')");    
    }
    
    public void guardarIdioma(String idioma){
        insertar("insert into idiomas (nombre) values('"+idioma+"')");    
    }
    
    public void cargarAutores(DefaultComboBoxModel modeloCombo){        
        try{
        conectar();
        ResultSet rs = consulta.executeQuery("SELECT * FROM autores");
            while (rs.next()){          
                Object nombre = rs.getObject("nombre");
                Object apellido = rs.getObject("apellido");
                modeloCombo.addElement(nombre.toString()+"  "+apellido.toString());
            }
            rs.close();                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al cargar autores");
        }
    }
    
    public void cargarIdioma(DefaultComboBoxModel modeloCombo){        
        try{
        conectar();
        ResultSet rs = consulta.executeQuery("SELECT * FROM idiomas");
            while (rs.next()){                                                          
                modeloCombo.addElement(rs.getObject("nombre"));
            }
            rs.close();                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al cargar idiomas");
        }        
    }
    
    public void cargarPais(DefaultComboBoxModel modeloCombo){
        try{
            conectar();
            ResultSet rs = consulta.executeQuery("SELECT * FROM paises");
            while (rs.next()){                                                          
                modeloCombo.addElement(rs.getObject("nombre"));
            }
            rs.close();                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al cargar paises");
        }        
    
    }

    public int buscoIdAutor(String seleccionAutor){
       int res = 0;
       try{
        conectar();
        String delimitadores= "  ";
        String[] palabrasSeparadas = seleccionAutor.split(delimitadores);
        //System.out.println(palabrasSeparadas[0]+" "+palabrasSeparadas[1]);
        ResultSet rs = consulta.executeQuery("SELECT * FROM autores where nombre='"+palabrasSeparadas[0]+"' AND apellido='"+palabrasSeparadas[1]+"'");    
        res = (int) rs.getObject("id");
        rs.close();                                        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al buscar ID autor");            
        }            
        return res;        
    }
    
     public String buscoNombreAutor(int idAutor){
       String resultado ="";
       String res ="";
       String otroString="";
       try{
        conectar();
        //System.out.println(palabrasSeparadas[0]+" "+palabrasSeparadas[1]);
        ResultSet rs = consulta.executeQuery("SELECT * FROM autores where id="+idAutor);    
        res = (String) rs.getObject("nombre");
        otroString = (String) rs.getObject("apellido");
        rs.close();                                        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al buscar Nombre del autor");            
        }            
        return resultado = res+"  "+otroString;
        
    }
    
    public int buscoIdPais(String seleccionPais){
       int res = 0;
       try{
        conectar();        
        ResultSet rs = consulta.executeQuery("SELECT * FROM paises where nombre='"+seleccionPais+"'");    
        res = (int) rs.getObject("id");
        rs.close();                                        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al buscar ID pais");            
        }            
        return res;    
    }
    
    public int buscoIdIdioma(String seleccionIdioma) {
       int res = 0;
       try{
        conectar();        
        ResultSet rs = consulta.executeQuery("SELECT * FROM idiomas where nombre='"+seleccionIdioma+"'");    
        res = (int) rs.getObject("id");
        rs.close();                                        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al buscar ID idioma");            
        }            
        return res;
    }
    
       public String buscoIdioma (int idIdioma){
       String resultado ="";;
       try{
        conectar();
        ResultSet rs = consulta.executeQuery("SELECT * FROM idiomas where id="+idIdioma);    
        resultado = (String) rs.getObject("nombre");
        rs.close();                                        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al buscar el Idioma");            
        }            
        return resultado;
    }
    
}

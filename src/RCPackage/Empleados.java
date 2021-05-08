package RCPackage;

public class Empleados {
   private int idempleado;
   private String nombre; 
   private String apellidos;   
    

   public Empleados() {}
   public Empleados(String fname, String lname) {
      this.nombre = fname;
      this.apellidos = lname;
      
   }
   
   public int getId() {
      return idempleado;
   }
   
   public void setId( int id ) {
      this.idempleado = id;
   }
   
   public String getNombre() {
      return nombre;
   }
   
   public void setNombre( String nombre ) {
      this.nombre = nombre;
   }
   
   public String getApellidos() {
      return apellidos;
   }
   
   public void setApellidos( String apellidos ) {
      this.apellidos = apellidos;
   }
   
}
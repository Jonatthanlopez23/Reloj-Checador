package RCPackage;

public class Registros {

   private int idregistros;
   private int idempleado;
   private String hora;
   private String tiporegistro; 

    public Registros(){
        
    }
    public int getId() {
        return idregistros;
     }
     
     public void setId( int id ) {
        this.idregistros = id;
     }
     public int getIdEmpleado() {
        return idempleado;
     }
     
     public void setIdEmpleado( int id ) {
        this.idempleado = id;
     }
     public String gethora() {
        return hora;
     }
     
     public void setHora( String hora ) {
        this.hora = hora;
     }   
     public String getTiporegistro() {
        return tiporegistro;
     }
     
     public void setTiporegistro( String tiporegistro ) {
        this.tiporegistro = tiporegistro;
     }    
}

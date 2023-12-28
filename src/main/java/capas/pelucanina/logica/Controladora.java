package capas.pelucanina.logica;

import capas.pelucanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {

     ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
    public void guardar(String nombreMascota, String raza, String color, String observa, String alergico, String atesp, 
            String nombreDuenio, String celuDuenio, String direccion) {
        
            Duenio duenio = new Duenio();
            
            duenio.setNombre(nombreDuenio);
            duenio.setCelular(celuDuenio);
            duenio.setDireccion(direccion);
            
            
            Mascota mascota = new Mascota();
            
            mascota.setNombre(nombreMascota);
            mascota.setRaza(raza);
            mascota.setColor(color);
            mascota.setAlergico(alergico);
            mascota.setAtencionEspecial(atesp);
            mascota.setObservaciones(observa);
            mascota.setDuenio(duenio);
            
            

           controlPersis.guardar(duenio,mascota);
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMascota, String raza, String color, 
            String observa, String alergico, String atesp, String nombreDuenio, 
            String celuDuenio, String direccion) {
        
        masco.setNombre(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observa);
        masco.setAlergico(alergico);        
        masco.setAtencionEspecial(atesp);
        
        controlPersis.modificarMascota(masco);
        
        Duenio duenio = this.buscarDuenio(masco.getDuenio().getId());
        duenio.setNombre(nombreDuenio);
        duenio.setCelular(celuDuenio);
        duenio.setDireccion(direccion);
        
        this.modificarDuenio(duenio);
        
                
    } 

    private Duenio buscarDuenio(int id) {
        return controlPersis.traerDuenio(id);
}

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
}
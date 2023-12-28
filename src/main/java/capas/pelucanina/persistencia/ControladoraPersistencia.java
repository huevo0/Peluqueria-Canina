package capas.pelucanina.persistencia;

import capas.pelucanina.logica.Duenio;
import capas.pelucanina.logica.Mascota;
import capas.pelucanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {

    DuenioJpaController duenioJpa = new DuenioJpaController();
        MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota mascota) {
            duenioJpa.create(duenio);
            mascotaJpa.create(mascota);
    }

    public List<Mascota> traerMascotas() {
                       
        return mascotaJpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
       
        try {
            mascotaJpa.destroy(num_cliente);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public Mascota traerMascota(int num_cliente) {
            return mascotaJpa.findMascota(num_cliente);
    }

    public Duenio traerDuenio(int id) {
       return duenioJpa.findDuenio(id);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

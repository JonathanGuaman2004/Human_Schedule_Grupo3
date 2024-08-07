package Business.BusinessLogic;

import DataAccess.DAO.SistemaSeguimientoYAsistencia_DAO;
import DataAccess.DTO.SistemaSeguimientoYAsistencia_DTO;
import javafx.scene.control.Label;

/**
 * La clase SistemaSeguimientoYAsistenciaBL sera la clase mediante el cual podemos acceder a los metdos del CRUD a usar
 */
public class SistemaSeguimientoYAsistenciaBL {
    private SistemaSeguimientoYAsistencia_DAO registroDiarioDao =new SistemaSeguimientoYAsistencia_DAO();

    public SistemaSeguimientoYAsistenciaBL() {
    }

    /**
     * El medoto create pemritirá crear un objeto para que despues pueda ser subido a la base de datos
     * @param registroDiarioDto: el objeto de tipo SistemaSeguimientoYAsistencia_DTO
     * @param infoP: es el label donde se mostrara la información respecto a la creacion del registro
     * @return: Devolvera un booleano al ejecutar el metodo de la clase SistemaSeguimientoYAsistencia_DTO para realizar su creacion
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean create(SistemaSeguimientoYAsistencia_DTO registroDiarioDto , Label infoP)throws Exception{
        return registroDiarioDao.create(registroDiarioDto,infoP);
    }

    /**
     * El medoto update pemritirá crear un objeto para que despues puedan ser actualizados sus datos y ser subido a la base de datos
     * @param registroDiarioDto: el objeto de tipo SistemaSeguimientoYAsistencia_DTO
     * @param infoP: es el label donde se mostrara la información respecto a la actualizacion del registro
     * @return: Devolvera un booleano al ejecutar el metodo de la clase SistemaSeguimientoYAsistencia_DTO para realizar su actualizacion
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean update(SistemaSeguimientoYAsistencia_DTO registroDiarioDto , Label infoP)throws Exception{
        return registroDiarioDao.update(registroDiarioDto,infoP);
    }
}

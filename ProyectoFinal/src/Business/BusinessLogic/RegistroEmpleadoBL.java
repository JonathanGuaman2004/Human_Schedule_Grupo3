package Business.BusinessLogic;

import DataAccess.DAO.RegistroEmpleado_DAO;
import DataAccess.DTO.RegistroEmpleado_DTO;
import javafx.scene.control.Label;

/**
 * La clase RegistroEmpleadoBL sera la clase mediante el cual podemos acceder a los metdos del CRUD a usar
 */
public class RegistroEmpleadoBL {
    private RegistroEmpleado_DAO empleadoDAO = new RegistroEmpleado_DAO();

    public RegistroEmpleadoBL() {
    }
    /**
     * El metodo create pemritirá crear un objeto para que despues pueda ser subido a la base de datos
     * @param empleadoDTO: el objeto de tipo empleado
     * @param infoP: es el label donde se mostrara la información respecto a la creación del registro
     * @return: Devolvera un booleano al ejecutar el metodo de la clase RegistroEmpleado_DAO para realizar su creación
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean create(RegistroEmpleado_DTO empleadoDTO, Label infoP)throws Exception{
        return empleadoDAO.create(empleadoDTO,infoP);
    }
    /**
     * El metodo readBy permitirá buscar un objeto para que despues pueda ser devuelto y mostrarlo
     * @param entero: Ingresa el ID  de persona que se desea buscar
     * @param infoP: es el label donde se mostrara la información respecto a la busqueda del registro
     * @return: Devolvera un booleano al ejecutar el metodo de la clase RegistroEmpleado_DAO para realizar su respevtiva busqueda
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public RegistroEmpleado_DTO readBy(int entero, Label infoP)throws Exception{
        return empleadoDAO.readBy(entero,infoP);
    }
    /**
     * El metodo update pemritirá crear un objeto para que despues puedan ser actualizados sus datos y ser subido a la base de datos
     * @param empleadoDTO: el objeto de tipo empleado a actualizar
     * @param infoP: es el label donde se mostrara la información respecto a la actualizacion del registro
     * @return: Devolvera el objeto RegistroEmpleado_DTO que se crara con el metodo de la clase RegistroEmpleado_DAO para realizar su respectiva busqueda y actualizacion
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean update(RegistroEmpleado_DTO empleadoDTO, Label infoP)throws Exception{
        return empleadoDAO.update(empleadoDTO,infoP);
    }
    /**
     * El metodo delete pemritirá cambiar un objeto para que en su estado cambie y no se elimine
     * @param empleadoDTO: el objeto de tipo empleado a ¨eliminar¨
     * @param infoP: es el label donde se mostrara la información respecto a ¨borrado del registro¨ del registro
     * @return: Retornara un booleani para saber si se ejecuto la actualizacion de estado
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean delete(RegistroEmpleado_DTO empleadoDTO, Label infoP)throws Exception{
        return empleadoDAO.delete(empleadoDTO,infoP);
    }
    
}

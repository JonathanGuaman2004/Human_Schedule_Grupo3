package Business.BusinessLogic;

import DataAccess.DAO.SistemaControlAcceso_DAO;
import DataAccess.DTO.SistemaControlAcceso_DTO;
import javafx.scene.control.Label;

/**
 * La clase SistemaControlAccesoBL sera la clase mediante el cual podemos acceder a los metdos del CRUD a usar
 */
public class SistemaControlAccesoBL {
    private SistemaControlAcceso_DAO sistemaControlDAO = new SistemaControlAcceso_DAO();
    /**
     * El medoto create pemritirá crear un objeto para que despues pueda ser subido a la base de datos
     * @param sistemaControlDTO: el objeto de tipo sistemaControlDTO
     * @param info: es el label donde se mostrara la información respecto a la creación del registro
     * @return: Devolvera un booleano al ejecutar el metodo de la clase SistemaControlAcceso_DAO para realizar su creación
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean create(SistemaControlAcceso_DTO sistemaControlDTO, Label info)throws Exception{
        return sistemaControlDAO.create(sistemaControlDTO,info);
    }
    
    /**
     * El medoto update pemritirá crear un objeto para que despues puedan ser actualizados sus datos y ser subido a la base de datos
     * @param sistemaControlDTO: el objeto de tipo sistemaControlDTO
     * @param info: es el label donde se mostrara la información respecto a la actualizacion del registro
     * @return: Devolvera un booleano al ejecutar el metodo de la clase SistemaControlAcceso_DAO para realizar su actualizacion
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean update(SistemaControlAcceso_DTO sistemaControlDTO, Label info)throws Exception{
        return sistemaControlDAO.update(sistemaControlDTO,info);
    }
    
    /**
     * El medoto readBy permitirá buscar un objeto para que despues pueda ser devuelto y mostrarlo
     * @param id: numero de id para buscar
     * @param mes: el mes que se buscará
     * @param anio: el anio por el cual se busara
     * @param info: es el label donde se mostrara la información respecto a la busqueda del registro
     * @return: Devolvera un objeto SistemaControlAcceso_DTO que nos indicará sus datos
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public SistemaControlAcceso_DTO readBy(int id,int mes, int anio, Label info)throws Exception{
        return sistemaControlDAO.readByIdMesAnio(id, mes, anio, info);
    }
}

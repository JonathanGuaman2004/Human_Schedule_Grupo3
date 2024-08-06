package BusinessLogic;

import DataAccess.DAO.SistemaControlAcceso_DAO;
import DataAccess.DTO.RegistroEmpleado_DTO;
import DataAccess.DTO.SistemaControlAcceso_DTO;
import DataAccess.DTO.SistemaSeguimientoYAsistencia_DTO;
import javafx.scene.control.Label;

public class SistemaControlAccesoBL {
    private SistemaControlAcceso_DAO sistemaControlDAO = new SistemaControlAcceso_DAO();
    
    public boolean create(SistemaControlAcceso_DTO sistemaControlDTO, Label info)throws Exception{
        return sistemaControlDAO.create(sistemaControlDTO,info);
    }
    
    public boolean update(SistemaControlAcceso_DTO sistemaControlDTO, Label info)throws Exception{
        return sistemaControlDAO.update(sistemaControlDTO,info);
    }

    public SistemaControlAcceso_DTO readBy(int id,int mes, int anio, Label info)throws Exception{
        return sistemaControlDAO.readByIdMesAnio(id, mes, anio, info);
    }
}

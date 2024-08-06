package BusinessLogic;

import DataAccess.DAO.RegistroEmpleado_DAO;
import DataAccess.DTO.RegistroEmpleado_DTO;
import javafx.scene.control.Label;

public class RegistroEmpleadoBL {
    private RegistroEmpleado_DAO empleadoDAO = new RegistroEmpleado_DAO();
    
    public RegistroEmpleadoBL() {
    }

    public boolean create(RegistroEmpleado_DTO empleadoDTO, Label infoP)throws Exception{
        return empleadoDAO.create(empleadoDTO,infoP);
    }
    
    public RegistroEmpleado_DTO readBy(int entero, Label infoP)throws Exception{
        return empleadoDAO.readBy(entero,infoP);
    }

    public boolean update(RegistroEmpleado_DTO empleadoDTO, Label infoP)throws Exception{
        return empleadoDAO.update(empleadoDTO,infoP);
    }

    public boolean delete(RegistroEmpleado_DTO empleadoDTO, Label infoP)throws Exception{
        return empleadoDAO.delete(empleadoDTO,infoP);
    }
    
}

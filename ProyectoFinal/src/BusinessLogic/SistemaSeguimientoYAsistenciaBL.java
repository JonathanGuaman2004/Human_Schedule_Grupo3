package BusinessLogic;

import DataAccess.DAO.SistemaSeguimientoYAsistencia_DAO;
import DataAccess.DTO.SistemaSeguimientoYAsistencia_DTO;
import javafx.scene.control.Label;

public class SistemaSeguimientoYAsistenciaBL {
    private SistemaSeguimientoYAsistencia_DAO registroDiarioDao =new SistemaSeguimientoYAsistencia_DAO();

    public SistemaSeguimientoYAsistenciaBL() {
    }

    public boolean create(SistemaSeguimientoYAsistencia_DTO registroDiarioDto , Label infoP)throws Exception{
        return registroDiarioDao.create(registroDiarioDto,infoP);
    }
    public boolean update(SistemaSeguimientoYAsistencia_DTO registroDiarioDto , Label infoP)throws Exception{
        return registroDiarioDao.update(registroDiarioDto,infoP);
    }
}

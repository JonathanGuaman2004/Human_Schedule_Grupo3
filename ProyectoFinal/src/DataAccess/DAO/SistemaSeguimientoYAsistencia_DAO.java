package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import DataAccess.IDAO;
import DataAccess.SQLiteDataHelper;
import DataAccess.DTO.RegistroEmpleado_DTO;
import DataAccess.DTO.SistemaSeguimientoYAsistencia_DTO;
import FrameWork.GroupThreeException;
import javafx.scene.control.Label;

/**
 * La clase SistemaSeguimientoYAsistencia_DAO sera la clase mediante el cual podemos acceder a la base de datos, posee los ¨query¨ que mandarla las ordenes del CRUD a la base de datos de los empleados que asistieron en forma diaria
 */
public class SistemaSeguimientoYAsistencia_DAO extends SQLiteDataHelper implements IDAO<SistemaSeguimientoYAsistencia_DTO>{
    
    @Override
    public boolean create(SistemaSeguimientoYAsistencia_DTO entity, Label info) throws Exception {
        String query = "INSERT INTO RegistroDiario "
                        +"(IDPersonas"
                        +",HoraEntrada"
                        +",MinutoEntrada"
                        +",NumeroDia"
                        +",NumeroMes"
                        +",NumeroAnio"
                        +",EstadoEnt) VALUES (?,?,?,?,?,?,?)";
        RegistroEmpleado_DTO entityDos;
        RegistroEmpleado_DAO entityTres=new RegistroEmpleado_DAO();
        entityDos=entityTres.readBy(entity.getiDPersonas(), info);
        if (entityDos.getEstado().equals("A")){
            try {
                Connection conn = openConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1,entity.getiDPersonas());
                    pstmt.setInt(2,entity.getHoraAlMomento());
                    pstmt.setInt(3,entity.getMinutoAlMomento());
                    pstmt.setInt(4,entity.getNumeroDia());
                    pstmt.setInt(5,entity.getNumeroMes());
                    pstmt.setInt(6,entity.getNumeroAnio());
                    pstmt.setString(7,entity.getEstadoEntrada(entityDos.getiDHorario()));
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                return false;
            }
        }else{
            info.setText("Usted NO ES un trabajador ACTIVO");
            info.setStyle("-fx-text-fill: #E53935");
            return false;
        }
    }
    
    /**
     * este metodo permitira buscar a cierta persona de acuerdo ail, dia, mes, anio
     * @param id: ide de la persona
     * @param dia: el dia actual
     * @param mes: mes actual
     * @param info: es el label donde se mostrara la informacion respecto a la busqueda del registro
     * @return retorna un objeto de tipo SistemaSeguimientoYAsistencia_DTO que permitira obserbar sus datos
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public SistemaSeguimientoYAsistencia_DTO readByDiaMes(int id,Integer dia,Integer mes, Label info) throws Exception {
        SistemaSeguimientoYAsistencia_DTO rE = new SistemaSeguimientoYAsistencia_DTO();
        String query = "SELECT "
                        +"HoraEntrada"
                        +",MinutoEntrada "
                        +",HoraSalida "
                        +",MinutoSalida "
                        +"FROM RegistroDiario "
                        +" WHERE IDPersonas = "+id
                        +" AND NumeroDia    = "+dia
                        +" AND NumeroMes    = "+mes;
        try {
            Connection conn = openConnection();
            Statement pstmt = conn.createStatement();
            ResultSet rs = pstmt.executeQuery(query);
            while(rs.next()){
                rE= new SistemaSeguimientoYAsistencia_DTO(
                    rs.getInt(1)
                  , rs.getInt(2)
                  , rs.getInt(3)
                  , rs.getInt(4));
            }
        } catch (SQLException e) {
        }
        return rE;
    }
    
    @Override
    public boolean update(SistemaSeguimientoYAsistencia_DTO entity, Label info) throws Exception {
        String query = "UPDATE RegistroDiario SET "
                        +"HoraSalida        = ?"
                        +",MinutoSalida     = ?"
                        +",EstadoSal        = ?"
                        +" WHERE IDPersonas = ?"
                        +"AND NumeroDia     = ?"
                        +"AND NumeroMes     = ?";
        RegistroEmpleado_DAO entityTres=new RegistroEmpleado_DAO();
        RegistroEmpleado_DTO entityDos = entityTres.readBy(entity.getiDPersonas(), info);
        if (entityDos.getEstado().equals("A")){
            try {
                Connection conn = openConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1,entity.getHoraAlMomento());
                    pstmt.setInt(2,entity.getMinutoAlMomento());
                    pstmt.setString(3,entity.getEstadoSalida(entityDos.getiDHorario()));
                    pstmt.setInt(4,entity.getiDPersonas());
                    pstmt.setInt(5,entity.getNumeroDia());
                    pstmt.setInt(6,entity.getNumeroMes());
                pstmt.executeUpdate();
                return true;
            }catch (SQLException e){
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"create()");
            }
        }
        return false;
    }
    
    @Override
    public boolean delete(SistemaSeguimientoYAsistencia_DTO entity, Label info) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    @Override
    public List<SistemaSeguimientoYAsistencia_DTO> readAll() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }

    @Override
    public SistemaSeguimientoYAsistencia_DTO readBy(int id, Label info) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'readBy'");
    }
}

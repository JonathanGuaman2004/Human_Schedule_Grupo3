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
import DataAccess.DTO.SistemaControlAcceso_DTO;
import DataAccess.DTO.SistemaSeguimientoYAsistencia_DTO;
import FrameWork.GroupThreeException;
import javafx.scene.control.Label;

/**
 * La clase SistemaControlAcceso_DAO sera la clase mediante el cual podemos acceder a la base de datos, posee los ¨query¨ que mandarla las ordenes del CRUD a la base de datos de los empleados que asistieron en forma mensual
 */
public class SistemaControlAcceso_DAO extends SQLiteDataHelper implements IDAO<SistemaControlAcceso_DTO>{

    @Override
    public List<SistemaControlAcceso_DTO> readAll() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }

    @Override
    public boolean create(SistemaControlAcceso_DTO entity, Label info) throws Exception {
        String query = "INSERT INTO RegistroMensual "
                        +"(IDPersonas"
                        +",NumeroMes"
                        +",NumeroAnio"
                        +",NumeroAtrasos"
                        +",NumeroSalidaAntes"
                        +",HorasFaltantes"
                        +",HorasExtra"
                        +",HorasExtraOrdinarias"
                        +",DecimoTercerS"
                        +",DecimoCuartoS"
                        +",NumeroHorasLaborables) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        RegistroEmpleado_DTO entityDos;
        RegistroEmpleado_DAO entityTres=new RegistroEmpleado_DAO();
        SistemaSeguimientoYAsistencia_DTO entityCuatro = new SistemaSeguimientoYAsistencia_DTO();
        SistemaSeguimientoYAsistencia_DAO entityCinco = new SistemaSeguimientoYAsistencia_DAO();
        entityDos=entityTres.readBy(entity.getiDPersonas(), info);
        entityCuatro=entityCinco.readByDiaMes(entity.getiDPersonas(),entityCuatro.getNumeroDia(), entityCuatro.getNumeroMes(), info);
        if (entityDos.getEstado().equals("A")){
            try {
                Connection conn = openConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1,entity.getiDPersonas());
                    pstmt.setInt(2,entity.getNumeroMes());
                    pstmt.setInt(3,entity.getNumeroAnio());
                    pstmt.setInt(4,entity.getNumeroAtrasos(entityCuatro,entityDos.getiDHorario()));
                    pstmt.setInt(5,entity.getNumeroSalidaAntes(entityCuatro,entityDos.getiDHorario()));
                    pstmt.setInt(6,entity.getHorasFaltantes(entityCuatro,entityDos.getiDHorario()));
                    pstmt.setInt(7,entity.getHorasExtra(entityCuatro,entityDos.getiDHorario()));
                    pstmt.setInt(8,entity.getHorasExtraOrdinariasNull());
                    pstmt.setString(9,entityDos.getPagoDecimoTercero());
                    pstmt.setString(10,entityDos.getPagoDecimoCuarto());
                    pstmt.setInt(11,entity.getNumeroHorasLaborables(entity.getNumeroAnio(),entity.getNumeroMes())-9+entity.getHorasFaltantes(entityCuatro,entityDos.getiDHorario()));
                    pstmt.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        }else{
            return false;
        }
    }
    
    /**
     * Este metodo es una variante del metodo readBy el caul tambien se utiliza para buscar datos en la base de datos, sin embargo añandiendo el id, el mes, el anio
     * @param id: id de la persona a buscar
     * @param mes: mes en el que buscar
     * @param anio: anio en el que buscar
     * @param info: es el label donde se mostrara la informacion respecto a la busqueda del registro
     * @return: retornara un objeto de tipo SistemaControlAcceso_DTO que permitira despues poder mostrar los datos obtenidos de la busqueda
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public SistemaControlAcceso_DTO readByIdMesAnio(int id,int mes, int anio, Label info) throws Exception {
        SistemaControlAcceso_DTO rE = new SistemaControlAcceso_DTO();
        String query = "SELECT "
                        +"NumeroAtrasos "
                        +",NumeroSalidaAntes "
                        +",HorasFaltantes "
                        +",HorasExtra "
                        +",HorasExtraOrdinarias "
                        +",NumeroHorasLaborables "
                        +" FROM RegistroMensual "
                        +" WHERE IDPersonas = "+id
                        +" AND NumeroMes    = "+mes
                        +" AND NumeroAnio    = "+anio;
        try {
            Connection conn = openConnection();
            Statement pstmt = conn.createStatement();
            ResultSet rs = pstmt.executeQuery(query);
            while(rs.next()){
                rE= new SistemaControlAcceso_DTO(
                    rs.getInt(1)
                  , rs.getInt(2)
                  , rs.getInt(3)
                  , rs.getInt(4)
                  , rs.getInt(5)
                  , rs.getInt(6));
            }
        } catch (SQLException e) {
            throw new GroupThreeException(e.getMessage(),getClass().getName(),"readByIdMesAnios()");
        }
        return rE;
    }

    @Override
    public boolean update(SistemaControlAcceso_DTO entity, Label info) throws Exception {
        String query = "UPDATE RegistroMensual SET "
                        +"NumeroAtrasos         = NumeroAtrasos + ?"
                        +",NumeroSalidaAntes    = NumeroSalidaAntes +?"
                        +",HorasFaltantes       = HorasFaltantes + ?"
                        +",HorasExtra           = HorasExtra +?"
                        +",HorasExtraOrdinarias = HorasExtraOrdinarias +?"
                        +",NumeroHorasLaborables= NumeroHorasLaborables -?"
                        +" WHERE IDPersonas     = ?"
                        +"AND NumeroMes         = ?"
                        +"AND NumeroAnio        = ?";
        RegistroEmpleado_DTO entityDos;
        RegistroEmpleado_DAO entityTres=new RegistroEmpleado_DAO();
        SistemaSeguimientoYAsistencia_DTO entityCuatro = new SistemaSeguimientoYAsistencia_DTO();
        SistemaSeguimientoYAsistencia_DAO entityCinco = new SistemaSeguimientoYAsistencia_DAO();
        entityDos=entityTres.readBy(entity.getiDPersonas(), info);
        entityCuatro=entityCinco.readByDiaMes(entity.getiDPersonas(),entityCuatro.getNumeroDia(), entityCuatro.getNumeroMes(), info);
        try {
                Connection conn = openConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1,entity.getNumeroAtrasos(entityCuatro,entityDos.getiDHorario()));
                    pstmt.setInt(2,entity.getNumeroSalidaAntes(entityCuatro,entityDos.getiDHorario()));
                    pstmt.setInt(3,entity.getHorasFaltantes(entityCuatro,entityDos.getiDHorario()));
                    pstmt.setInt(4,entity.getHorasExtra(entityCuatro,entityDos.getiDHorario()));
                    pstmt.setInt(5,entity.getHorasExtraOrdinariasNull());
                    pstmt.setInt(6,9-entity.getHorasFaltantes(entityCuatro,entityDos.getiDHorario()));
                    pstmt.setInt(7,entity.getiDPersonas());
                    pstmt.setInt(8,entity.getNumeroMes());
                    pstmt.setInt(9,entity.getNumeroAnio());
                    pstmt.executeUpdate();
                return true;
            }catch (SQLException e){
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"create()");
            }
    }

    @Override
    public boolean delete(SistemaControlAcceso_DTO entity, Label info) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public SistemaControlAcceso_DTO readBy(int id, Label info) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'readBy'");
    }
}

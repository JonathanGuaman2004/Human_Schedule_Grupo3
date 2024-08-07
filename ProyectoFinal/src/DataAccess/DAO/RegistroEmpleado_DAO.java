package DataAccess.DAO;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DataAccess.IDAO;
import DataAccess.SQLiteDataHelper;
import DataAccess.DTO.RegistroEmpleado_DTO;
import FrameWork.GroupThreeException;
import javafx.scene.control.Label;

/**
 * La clase RegistroEmpleado_DAO sera la clase mediante el cual podemos acceder a la base de datos, posee los ¨query¨ que mandarla las ordenes del CRUD a la base de datos de los empleados registrados
 */
public class RegistroEmpleado_DAO extends SQLiteDataHelper implements IDAO<RegistroEmpleado_DTO>{

    @Override
    public List<RegistroEmpleado_DTO> readAll() throws Exception {
        List<RegistroEmpleado_DTO> lst = new ArrayList<>();
        String query = "SELECT IDPersonas"
                        +",IDPersonaTipo"
                        +",Nombre"
                        +",SegundoNombre"
                        +",Apellido"
                        +",SegundoApellido"
                        +",Edad"
                        +",IDGenero"
                        +",Correo"
                        +",Celular"
                        +",Telefono"
                        +",Estado"
                        +",PagoDecimoTercero"
                        +",PagoDecimoCuarto"
                        +",IDMesVacacion"
                        +",Modificador"
                        +",IDHorario"
                        +",Sueldo"
                        +"FROM RegistroPersonas"
                        +"WHERE Estado = 'A'";
            try {
                Connection conn = openConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    RegistroEmpleado_DTO sTodo = new RegistroEmpleado_DTO(
                    rs.getInt(1)
                    , rs.getInt(2)
                    , rs.getString(3)
                    , rs.getString(4)
                    , rs.getString(5)
                    , rs.getString(6)
                    , rs.getString(7)
                    , rs.getInt(8)
                    , rs.getInt(9)
                    , rs.getString(10)
                    , rs.getString(11)
                    , rs.getString(12)
                    , rs.getString(13)
                    , rs.getString(14)
                    , rs.getString(15)
                    , rs.getInt(16)
                    , rs.getString(17)
                    , rs.getInt(18)
                    , rs.getInt(19)
                    , rs.getDouble(20));
                    lst.add(sTodo);
                }
            } catch (SQLException e) {
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"readAll()");
            }
            return lst;
    }

    @Override
    public boolean create(RegistroEmpleado_DTO entity,Label info) throws Exception {
        String query = "INSERT INTO RegistroPersonas "
                     +"(IDPersonas"
                     +",IDPersonaTipo"
                     +",Nombre"
                     +",SegundoNombre"
                     +",Apellido"
                     +",SegundoApellido"
                     +",Cedula"
                     +",Edad"
                     +",IDGenero"
                     +",Correo"
                     +",Celular"
                     +",Telefono"
                     +",Estado"
                     +",PagoDecimoTercero"
                     +",PagoDecimoCuarto"
                     +",IDMesVacacion"
                     +",Modificador"
                     +",IDHorario"
                     +",Sueldo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            RegistroEmpleado_DTO entityDos;
            entityDos=readBy(entity.getModificador(), info);
            if (entityDos.getEstado().equals("A")){
                try {
                    Connection conn = openConnection();
                    PreparedStatement pstmt = conn.prepareStatement(query);
                        pstmt.setInt(1,    entity.getiDPersonas());
                        pstmt.setInt(2,    entity.getiDPersonaTipo());
                        pstmt.setString(3, entity.getNombre());
                        pstmt.setString(4, entity.getSegundoNombre());
                        pstmt.setString(5, entity.getApellido());
                        pstmt.setString(6, entity.getSegundoApellido());
                        pstmt.setString(7, entity.getCedula());
                        pstmt.setInt(8,    entity.getEdad());
                        pstmt.setInt(9,    entity.getiDGenero());
                        pstmt.setString(10,entity.getCorreo());
                        pstmt.setString(11,entity.getCelular());
                        pstmt.setString(12,entity.getTelefono());
                        pstmt.setString(13,entity.getEstado());
                        pstmt.setString(14,entity.getPagoDecimoTercero());
                        pstmt.setString(15,entity.getPagoDecimoCuarto());
                        pstmt.setInt(16,   entity.getiDMesVacacion());
                        pstmt.setInt(17,   entity.getModificador());
                        pstmt.setInt(18,   entity.getiDHorario());
                        pstmt.setDouble(19,   entity.getSueldo());
                    pstmt.executeUpdate();
                    info.setText("Registro Exitoso");
                    info.setStyle("-fx-text-fill: #66FF66");
                    return true;
                } catch (SQLException e) {
                    info.setText("Asegurese que sus datos estan correctos, si el mensaje persiste contacte con un administrador");
                    info.setStyle("-fx-text-fill: #E53935");
                    throw new GroupThreeException(e.getMessage(),getClass().getName(),"create()");
                }
            }else{
                info.setText("Se requiere que la persona que lo autorice se encuentre activo");
                info.setStyle("-fx-text-fill: #E53935");
            }
            return false;
    }

    @Override
    public boolean update(RegistroEmpleado_DTO entity,Label info) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE RegistroPersonas SET "
            +"IDPersonaTipo     = ?"
            +",Nombre           = ?"
            +",SegundoNombre    = ?"
            +",Apellido         = ?"
            +",SegundoApellido  = ?"
            +",Cedula           = ?"
            +",Edad             = ?"
            +",IDGenero         = ?"
            +",Correo           = ?"
            +",Celular          = ?"
            +",Telefono         = ?"
            +",Estado           = ?"
            +",PagoDecimoTercero= ?"
            +",PagoDecimoCuarto = ?"
            +",FechaModificacion= ?"
            +",Modificador      = ?"
            +",Sueldo           = ?"
            +" WHERE IDPersonas = ?";
            RegistroEmpleado_DTO entityDos;
            entityDos=readBy(entity.getModificador(), info);
            if (entityDos.getEstado().equals("A")){
                try {
                    Connection conn = openConnection();
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(   1, entity.getiDPersonaTipo());
                    pstmt.setString(2, entity.getNombre());
                    pstmt.setString(3, entity.getSegundoNombre());
                    pstmt.setString(4, entity.getApellido());
                    pstmt.setString(5, entity.getSegundoApellido());
                    pstmt.setString(6, entity.getCedula());
                    pstmt.setInt(   7, entity.getEdad());
                    pstmt.setInt(   8, entity.getiDGenero());
                    pstmt.setString(9, entity.getCorreo());
                    pstmt.setString(10, entity.getCelular());
                    pstmt.setString(11, entity.getTelefono());
                    pstmt.setString(12, entity.getEstado());
                    pstmt.setString(13, entity.getPagoDecimoTercero());
                    pstmt.setString(14, entity.getPagoDecimoCuarto());
                    pstmt.setString(15, dtf.format(now).toString());
                    pstmt.setInt(   16, entity.getModificador());
                    pstmt.setDouble(17, entity.getSueldo());
                    pstmt.setInt(   18, entity.getiDPersonas());
                    pstmt.executeUpdate();
                    info.setText("Actualización Exitosa");
                    info.setStyle("-fx-text-fill: #66FF66");
                    return true;
                } catch (SQLException e) {
                    info.setText("Asegurese que sus datos estan correctos, si el mensaje persiste contacte con un administrador");
                    info.setStyle("-fx-text-fill: #E53935");
                    throw new GroupThreeException(e.getMessage(),getClass().getName(),"update()");
                }
            }else{
                info.setText("Se requiere que la persona que lo autorice se encuentre activo");
                info.setStyle("-fx-text-fill: #E53935");
            }
            return false;
        
    }

    @Override
    public boolean delete(RegistroEmpleado_DTO entity,Label info) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE RegistroPersonas SET "
                            +"Estado            = ?"
                            +",FechaModificacion= ?"
                            +",Modificador      = ?"
                            +"WHERE IDPersonas  = ?";
        RegistroEmpleado_DTO entityDos;
        entityDos=readBy(entity.getModificador(), info);
        if (entityDos.getEstado().equals("A")){
            try {
                Connection conn = openConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, entity.getEstado());
                pstmt.setString(2, dtf.format(now).toString());
                pstmt.setInt(3, entity.getModificador());
                pstmt.setInt(4, entity.getiDPersonas());
                pstmt.executeUpdate();
                info.setText("Actualización Exitosa (solo se cambió el estado)");
                info.setStyle("-fx-text-fill: #66FF66");
                return true;
            } catch (SQLException e) {
                info.setText("Asegurese que sus datos estan correctos, si el mensaje persiste contacte con un administrador");
                info.setStyle("-fx-text-fill: #E53935");
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"delete()");
            }
        }else{
            info.setText("Se requiere que la persona que lo autorice se encuentre activo");
            info.setStyle("-fx-text-fill: #E53935");
        }
        return false;
    }

    @Override
    public RegistroEmpleado_DTO readBy(int id,Label info) throws Exception {
        RegistroEmpleado_DTO rE = new RegistroEmpleado_DTO();
        String query = "SELECT "
                        +"Nombre"
                        +",SegundoNombre "
                        +",Apellido "
                        +",SegundoApellido "
                        +",Cedula "
                        +",Edad "
                        +",IDGenero "
                        +",Correo "
                        +",Celular "
                        +",Telefono "
                        +",Estado "
                        +",PagoDecimoTercero "
                        +",PagoDecimoCuarto "
                        +",IDMesVacacion "
                        +",IDHorario "
                        +",Sueldo "
                        +"FROM RegistroPersonas "
                        +"WHERE IDPersonas = "+id;
        try {
            Connection conn = openConnection();
            Statement pstmt = conn.createStatement();
            ResultSet rs = pstmt.executeQuery(query);
            while(rs.next()){
                rE= new RegistroEmpleado_DTO(
                    rs.getString(1)
                  , rs.getString(2)
                  , rs.getString(3)
                  , rs.getString(4)
                  , rs.getString(5)
                  , rs.getInt(6)
                  , rs.getInt(7)
                  , rs.getString(8)
                  , rs.getString(9)
                  , rs.getString(10)
                  , rs.getString(11)
                  , rs.getString(12)
                  , rs.getString(13)
                  , rs.getInt(14)
                  , rs.getInt(15)
                  , rs.getDouble(16));
            }
            info.setText("Registro Encontrado");
            info.setStyle("-fx-text-fill: #66FF66");
        } catch (SQLException e) {
            throw new GroupThreeException(e.getMessage(),getClass().getName(),"readBy()");
        }
        return rE;
    }
    
}

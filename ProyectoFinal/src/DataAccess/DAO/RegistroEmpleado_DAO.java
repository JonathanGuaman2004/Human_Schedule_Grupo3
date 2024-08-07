package DataAccess.DAO;

import java.sql.Statement;
import java.time.LocalDate;
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
                    rs.getInt(1)        //IDPersonas
                    , rs.getInt(2)      //IDPersonaTipo
                    , rs.getString(3)   //Nombre
                    , rs.getString(4)   //SegundoNombre
                    , rs.getString(5)   //Apellido
                    , rs.getString(6)   //SegundoApellido
                    , rs.getString(7)   //Cedula
                    , rs.getInt(8)      //Edad
                    , rs.getInt(9)      //IDGenero
                    , rs.getString(10)  //Correo
                    , rs.getString(11)  //Celular
                    , rs.getString(12)  //Telefono
                    , rs.getString(13)  //Estado
                    , rs.getString(14)  //PagoDecimoTercero
                    , rs.getString(15)  //PagoDecimoCuarto
                    , rs.getInt(16)     //IDMesVacacion
                    , rs.getString(17)  //rs.getInt(15)MesVacacion
                    , rs.getInt(18)     //Modificador
                    , rs.getInt(19)     //IDHorario)
                    , rs.getDouble(20));//Sueldo)
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
        /*1*/ +"(IDPersonas"
        /*2*/ +",IDPersonaTipo"
        /*3*/ +",Nombre"
        /*4*/ +",SegundoNombre"
        /*5*/ +",Apellido"
        /*6*/ +",SegundoApellido"
        /*7*/ +",Cedula"
        /*8*/ +",Edad"
        /*9*/ +",IDGenero"
        /*10*/+",Correo"
        /*11*/+",Celular"
        /*12*/+",Telefono"
        /*13*/+",Estado"
        /*14*/+",PagoDecimoTercero"
        /*15*/+",PagoDecimoCuarto"
        /*16*/+",IDMesVacacion"
        /*17*/+",Modificador"
        /*18*/+",IDHorario"
        /*19*/+",Sueldo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//hasta aqui bien
            /* */
            RegistroEmpleado_DTO entityDos;
            entityDos=readBy(entity.getModificador(), info);
            if (entityDos.getEstado().equals("A")){
                try {
                    Connection conn = openConnection();
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    /*1*/ pstmt.setInt(1,    entity.getiDPersonas());
                    /*2*/ pstmt.setInt(2,    entity.getiDPersonaTipo());
                    /*3*/ pstmt.setString(3, entity.getNombre());
                    /*4*/ pstmt.setString(4, entity.getSegundoNombre());
                    /*5*/ pstmt.setString(5, entity.getApellido());
                    /*6*/ pstmt.setString(6, entity.getSegundoApellido());
                    /*7*/ pstmt.setString(7, entity.getCedula());
                    /*8*/ pstmt.setInt(8,    entity.getEdad());
                    /*9*/ pstmt.setInt(9,    entity.getiDGenero());
                    /*10*/pstmt.setString(10,entity.getCorreo());
                    /*11*/pstmt.setString(11,entity.getCelular());
                    /*12*/pstmt.setString(12,entity.getTelefono());
                    /*13*/pstmt.setString(13,entity.getEstado());
                    /*14*/pstmt.setString(14,entity.getPagoDecimoTercero());
                    /*15*/pstmt.setString(15,entity.getPagoDecimoCuarto());
                    /*16*/pstmt.setInt(16,   entity.getiDMesVacacion());
                    /*17*/pstmt.setInt(17,   entity.getModificador());
                    /*18*/pstmt.setInt(18,   entity.getiDHorario());
                    /*19*/pstmt.setDouble(19,   entity.getSueldo());
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
            +"IDPersonaTipo     = ?"/*1*/
            +",Nombre           = ?"/*2*/
            +",SegundoNombre    = ?"/*3*/
            +",Apellido         = ?"/*4*/
            +",SegundoApellido  = ?"/*5*/
            +",Cedula           = ?"/*6*/
            +",Edad             = ?"/*7*/
            +",IDGenero         = ?"/*8*/
            +",Correo           = ?"/*9*/
            +",Celular          = ?"/*10*/
            +",Telefono         = ?"/*11*/
            +",Estado           = ?"/*12*/
            +",PagoDecimoTercero= ?"/*13*/
            +",PagoDecimoCuarto = ?"/*14*/
            +",FechaModificacion= ?"/*15*/
            +",Modificador      = ?"/*16*/
            +",Sueldo           = ?"/*17*/
            +" WHERE IDPersonas = ?"/*18*/;
            /* */
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
            /* */
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
                        //+ 100909;
        try {
            Connection conn = openConnection();
            Statement pstmt = conn.createStatement();
            ResultSet rs = pstmt.executeQuery(query);
            while(rs.next()){
                rE= new RegistroEmpleado_DTO(
                    rs.getString(1)   //Nombre
                  , rs.getString(2)   //SegundoNombre
                  , rs.getString(3)   //Apellido
                  , rs.getString(4)   //SegundoApellido
                  , rs.getString(5)   //Cedula
                  , rs.getInt(6)      //Edad
                  , rs.getInt(7)      //IDGenero
                  , rs.getString(8)  //Correo
                  , rs.getString(9)  //Celular
                  , rs.getString(10)  //Telefono
                  , rs.getString(11)  //Estado
                  , rs.getString(12)  //PagoDecimoTercero
                  , rs.getString(13)  //PagoDecimoCuarto
                  , rs.getInt(14)     //rs.getInt(15)MesVacacion
                  , rs.getInt(15)     //IDHorario)
                  , rs.getDouble(16));//Sueldo)
            }
            info.setText("Registro Encontrado");
            info.setStyle("-fx-text-fill: #66FF66");
        } catch (SQLException e) {
            throw new GroupThreeException(e.getMessage(),getClass().getName(),"readBy()");
        }
        return rE;
    }
    
    public Integer getRowCount () throws Exception{
        String query = "SELECT COUNT(*) TotalRegistros"
                     + "FROM RegistroPersonas         "
                     + "WHERE Estado = 'A'            ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new GroupThreeException(e.getMessage(),getClass().getName(),"getRowCount()");
        }
        return 0;
    }
}

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

public class SistemaControlAcceso_DAO extends SQLiteDataHelper implements IDAO<SistemaControlAcceso_DTO>{

    @Override
    public List<SistemaControlAcceso_DTO> readAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }

    @Override
    public boolean create(SistemaControlAcceso_DTO entity, Label info) throws Exception {
        String query = "INSERT INTO RegistroMensual "
        /*1*/ +"(IDPersonas"
        /*2*/ +",NumeroMes"
        /*3*/ +",NumeroAnio"
        /*4*/ +",NumeroAtrasos"
        /*5*/ +",NumeroSalidaAntes"
        /*6*/ +",HorasFaltantes"
        /*7*/ +",HorasExtra"
        /*8*/ +",HorasExtraOrdinarias"
        /*9*/ +",DecimoTercerS"
       /*10*/ +",DecimoCuartoS"
       /*11*/ +",NumeroHorasLaborables) VALUES (?,?,?,?,?,?,?,?,?,?,?)";//hasta aqui bien
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
                /*1*/ pstmt.setInt(1,entity.getiDPersonas());
                /*2*/ pstmt.setInt(2,entity.getNumeroMes());
                /*3*/ pstmt.setInt(3,entity.getNumeroAnio());
                /*4*/ pstmt.setInt(4,entity.getNumeroAtrasos(entityCuatro,entityDos.getiDHorario()));//asdadasd
                /*5*/ pstmt.setInt(5,entity.getNumeroSalidaAntes(entityCuatro,entityDos.getiDHorario()));
                /*5*/ pstmt.setInt(6,entity.getHorasFaltantes(entityCuatro,entityDos.getiDHorario()));
                /*6*/ pstmt.setInt(7,entity.getHorasExtra(entityCuatro,entityDos.getiDHorario()));
                /*7*/ pstmt.setInt(8,entity.getHorasExtraOrdinariasNull());
                /*8*/ pstmt.setString(9,entityDos.getPagoDecimoTercero());
                /*9*/ pstmt.setString(10,entityDos.getPagoDecimoCuarto());
               /*10*/ pstmt.setInt(11,entity.getNumeroHorasLaborables(entity.getNumeroAnio(),entity.getNumeroMes())-9+entity.getHorasFaltantes(entityCuatro,entityDos.getiDHorario()));
                pstmt.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        }else{
            return false;
        }
    }
    
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
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(SistemaControlAcceso_DTO entity, Label info) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public SistemaControlAcceso_DTO readBy(int id, Label info) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readBy'");
    }


}

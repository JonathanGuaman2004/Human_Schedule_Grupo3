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
public class SistemaSeguimientoYAsistencia_DAO extends SQLiteDataHelper implements IDAO<SistemaSeguimientoYAsistencia_DTO>{
    
    @Override
    public boolean create(SistemaSeguimientoYAsistencia_DTO entity, Label info) throws Exception {
        String query = "INSERT INTO RegistroDiario "
        /*1*/ +"(IDPersonas"
        /*2*/ +",HoraEntrada"
        /*3*/ +",MinutoEntrada"
        ///*4*/ +",HoraSalida"
        ///*5*/ +",MinutoSalida"
        /*6*/ +",NumeroDia"
        /*7*/ +",NumeroMes"
        /*8*/ +",NumeroAnio"
        /*9*/+",EstadoEnt) VALUES (?,?,?,?,?,?,?)";//hasta aqui bien
        RegistroEmpleado_DTO entityDos;
        RegistroEmpleado_DAO entityTres=new RegistroEmpleado_DAO();
        entityDos=entityTres.readBy(entity.getiDPersonas(), info);
        if (entityDos.getEstado().equals("A")){
            try {
                Connection conn = openConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                /*1*/ pstmt.setInt(1,entity.getiDPersonas());
                /*2*/ pstmt.setInt(2,entity.getHoraAlMomento());
                /*3*/ pstmt.setInt(3,entity.getMinutoAlMomento());
                ///*4*/ pstmt.setInt(4,entity.getHoraSalida());
                ///*5*/ pstmt.setInt(5,entity.getMinutoSalida());
                /*6*/ pstmt.setInt(4,entity.getNumeroDia());
                /*7*/ pstmt.setInt(5,entity.getNumeroMes());
                /*8*/ pstmt.setInt(6,entity.getNumeroAnio());
                /*9*/ pstmt.setString(7,entity.getEstadoEntrada(entityDos.getiDHorario()));
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
                        +"HoraSalida        = ?"/*1*/
                        +",MinutoSalida     = ?"/*2*/
                        +",EstadoSal        = ?"/*3*/
                        +" WHERE IDPersonas = ?"/*4*/
                        +"AND NumeroDia     = ?"/*5*/
                        +"AND NumeroMes     = ?";/*6*/
                        //+"AND HoraSalida    = NULL"/*7*/;
        RegistroEmpleado_DAO entityTres=new RegistroEmpleado_DAO();
        RegistroEmpleado_DTO entityDos = entityTres.readBy(entity.getiDPersonas(), info);
        if (entityDos.getEstado().equals("A")){
            try {
                Connection conn = openConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                /*1*/ pstmt.setInt(1,entity.getHoraAlMomento());
                /*2*/ pstmt.setInt(2,entity.getMinutoAlMomento());
                /*3*/ pstmt.setString(3,entity.getEstadoSalida(entityDos.getiDHorario()));
                /*4*/ pstmt.setInt(4,entity.getiDPersonas());
                /*5*/ pstmt.setInt(5,entity.getNumeroDia());
                /*6*/ pstmt.setInt(6,entity.getNumeroMes());
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readBy'");
    }
}

package DataAccess;

import java.util.List;

import javafx.scene.control.Label;

public interface IDAO<T> {
    public List<T> readAll()          throws Exception; //Leer todos
    public boolean create(T entity,Label info)   throws Exception; //crear
    public boolean update(T entity,Label info)   throws Exception; //actualizar
    public boolean delete(T entity,Label info) throws Exception; //borrar (cambiar de estado)

    public T readBy(int id,Label info)       throws Exception; //Leer uno
}

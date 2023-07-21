package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionRepository {
    Position findbyId(int id ) throws SQLException, ClassNotFoundException;
    List<Position> findALL();

}

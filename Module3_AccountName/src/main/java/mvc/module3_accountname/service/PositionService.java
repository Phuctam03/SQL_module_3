package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionService {
    Position findbyId(int id ) throws SQLException, ClassNotFoundException;
    List<Position> findALL();
}

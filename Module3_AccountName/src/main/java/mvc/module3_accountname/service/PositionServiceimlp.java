package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Position;
import mvc.module3_accountname.repository.PositionRepository;
import mvc.module3_accountname.repository.PositionRepositoryImlp;

import java.sql.SQLException;
import java.util.List;

public class PositionServiceimlp implements  PositionService{
    private PositionRepository positionRepository = new PositionRepositoryImlp();
    @Override
    public Position findbyId(int id) throws SQLException, ClassNotFoundException {
        return  positionRepository.findbyId(id);
    }

    @Override
    public List<Position> findALL() {
        return  positionRepository.findALL();
    }
}

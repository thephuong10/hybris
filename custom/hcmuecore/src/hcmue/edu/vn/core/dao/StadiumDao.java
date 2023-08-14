package hcmue.edu.vn.core.dao;

import hcmue.edu.vn.core.model.StadiumModel;

import java.util.List;

public interface StadiumDao {
    List<StadiumModel> findAllStadiums();

    List<StadiumModel>findStadiumIsOpen(String status);

    StadiumModel findStadiumByCode(String id);

    List<StadiumModel> findStadiumByDate(String dateRS);

    StadiumModel save(StadiumModel model);

}

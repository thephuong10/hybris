package hcmue.edu.vn.core.service;

import hcmue.edu.vn.core.enums.StadiumType;
import hcmue.edu.vn.core.model.StadiumModel;

import java.util.List;

public interface StadiumService {
    List<StadiumModel> getStadiums();
    List<StadiumModel> getStadiumsIsOpen(String status);

    StadiumModel getStadiumByCode(String id);

    List<StadiumModel> getStadiumsByDate(String dateRS);

    StadiumModel save(StadiumModel model);
}

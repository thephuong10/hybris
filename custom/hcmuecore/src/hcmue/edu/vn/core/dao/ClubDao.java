package hcmue.edu.vn.core.dao;

import hcmue.edu.vn.core.model.ClubModel;

import java.util.List;

public interface ClubDao {

    ClubModel findByCode(String code);

    List<ClubModel>findAll();
}

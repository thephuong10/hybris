package hcmue.edu.vn.core.service;

import hcmue.edu.vn.core.model.ClubModel;

import java.util.List;

public interface ClubService {

    ClubModel getByCode(String code);

    List<ClubModel>getAll();

}

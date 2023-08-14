package hcmue.edu.vn.core.service.impl;

import hcmue.edu.vn.core.dao.ClubDao;
import hcmue.edu.vn.core.model.ClubModel;
import hcmue.edu.vn.core.service.ClubService;

import javax.annotation.Resource;
import java.util.List;

public class DefaultClubService implements ClubService {

    @Resource
    private ClubDao clubDao;


    @Override
    public ClubModel getByCode(String code) {
        return clubDao.findByCode(code);
    }

    @Override
    public List<ClubModel> getAll() {
        return clubDao.findAll();
    }
}

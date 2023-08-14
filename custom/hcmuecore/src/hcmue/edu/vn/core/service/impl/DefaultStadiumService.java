package hcmue.edu.vn.core.service.impl;

import hcmue.edu.vn.core.dao.ClubDao;
import hcmue.edu.vn.core.dao.StadiumDao;
import hcmue.edu.vn.core.model.StadiumModel;
import hcmue.edu.vn.core.service.StadiumService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public class DefaultStadiumService implements StadiumService {
    @Resource
    private StadiumDao stadiumDao;

    @Resource
    private ClubDao clubDao;


    @Override
    public List<StadiumModel> getStadiums() {
        return stadiumDao.findAllStadiums();
    }

    @Override
    public List<StadiumModel> getStadiumsIsOpen(String status) {
        return stadiumDao.findStadiumIsOpen(status);
    }

    @Override
    public StadiumModel getStadiumByCode(String id) {
        return stadiumDao.findStadiumByCode(id);
    }

    @Override
    public List<StadiumModel> getStadiumsByDate(String dateRS) {
        return stadiumDao.findStadiumByDate(dateRS);
    }

    @Override
    public StadiumModel save(StadiumModel model) {

        String clubCode = Optional
                .ofNullable(model.getOwnered())
                .map(c -> c.getCode())
                .orElse(null);
        if(clubCode != null) {

            model.setOwnered(Optional
                    .ofNullable(clubDao.findByCode(clubCode))
                    .map(c -> c)
                    .orElse(null)
            );

            if(model.getOwnered() != null) {

                return stadiumDao.save(model);
            }

        }
        return null;
    }

}

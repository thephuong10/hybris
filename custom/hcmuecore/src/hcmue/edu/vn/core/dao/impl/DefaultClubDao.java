package hcmue.edu.vn.core.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import hcmue.edu.vn.core.dao.ClubDao;
import hcmue.edu.vn.core.model.ClubModel;
import hcmue.edu.vn.core.model.StadiumModel;

import javax.annotation.Resource;
import java.util.List;

public class DefaultClubDao implements ClubDao {

    @Resource
    private FlexibleSearchService flexibleSearchService;


    @Override
    public ClubModel findByCode(String code) {

        final String queryString =
                "SELECT {" + ClubModel.PK + "} " + "FROM {" + ClubModel._TYPECODE + "}"
         + "WHERE {code} = '" + code + "'";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        final List<ClubModel> clubModels = flexibleSearchService.<ClubModel>search(query).getResult();

        if(clubModels.isEmpty()) {
            return null;
        }

        return clubModels.get(0);
    }

    @Override
    public List<ClubModel> findAll() {
        final String queryString =
                "SELECT {" + ClubModel.PK + "} " + "FROM {" + ClubModel._TYPECODE + "}";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        return flexibleSearchService.<ClubModel>search(query).getResult();

    }
}

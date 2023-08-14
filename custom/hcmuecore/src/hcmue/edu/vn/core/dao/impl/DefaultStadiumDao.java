package hcmue.edu.vn.core.dao.impl;

import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import hcmue.edu.vn.core.dao.StadiumDao;
import hcmue.edu.vn.core.enums.StadiumType;
import hcmue.edu.vn.core.model.StadiumModel;

import javax.annotation.Resource;
import java.util.List;

public class DefaultStadiumDao implements StadiumDao {
    @Resource
    private FlexibleSearchService flexibleSearchService;

    @Resource
    private ModelService modelService;

    @Override
    public List<StadiumModel> findAllStadiums() {
        final String queryString =
                "SELECT {" + StadiumModel.PK + "} " + "FROM {" + StadiumModel._TYPECODE + "}";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        return flexibleSearchService.<StadiumModel> search(query).getResult();
    }

    //find stadium is open
    @Override
    public List<StadiumModel>findStadiumIsOpen(String status) {
        final String queryString =
                "SELECT {" + StadiumModel.PK + "} " + "FROM {" + StadiumModel._TYPECODE + " AS s JOIN "
                        + StadiumType._TYPECODE + " AS st ON {" + "s." + StadiumModel.STATUS
                        + "} = {st.pk} } "
                        + "WHERE {st.code} = '" + status + "'";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        final List<StadiumModel> stadiumModels = flexibleSearchService.<StadiumModel>search(query).getResult();

        if(stadiumModels.isEmpty()) {
            return null;
        }

        return stadiumModels;

    }

    @Override
    public StadiumModel findStadiumByCode(String code) {
        final String queryString =
                "SELECT {" + StadiumModel.PK + "} " + "FROM {" + StadiumModel._TYPECODE + "} " +
                        "WHERE {" + StadiumModel.CODE + "} = '" + code.trim() + "'";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        final List<StadiumModel> stadiumModels = flexibleSearchService.<StadiumModel>search(query).getResult();

        if(stadiumModels.isEmpty()) {
            return null;
        }

        return stadiumModels.get(0);


    }

    @Override
    public List<StadiumModel> findStadiumByDate(String dateRS) {
        final String queryString =
                "SELECT {" + StadiumModel.PK + "} "//
                        + "FROM {" + StadiumModel._TYPECODE + "} "
                        + "WHERE to_char({modifiedtime},'dd/mm/yyyy') = '" + dateRS + "'";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        final List<StadiumModel> stadiumModels = flexibleSearchService.<StadiumModel>search(query).getResult();
        if (stadiumModels.isEmpty()) {
            return null;
        }
        return stadiumModels;
    }

    @Override
    public StadiumModel save(StadiumModel model) {

        modelService.save(model);

        return model;
    }

}

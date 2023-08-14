package hcmue.edu.vn.facades.stadium.impl;


import de.hybris.platform.hcmue.edu.vn.data.StadiumData;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import hcmue.edu.vn.core.model.StadiumModel;
import hcmue.edu.vn.core.service.StadiumService;
import hcmue.edu.vn.facades.exception.EntitySaveOrUpdateException;
import hcmue.edu.vn.facades.stadium.StadiumFacade;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DefaultStadiumFacade implements StadiumFacade {

    @Resource
    private StadiumService stadiumService;


    @Resource
    private Converter<StadiumModel,StadiumData>stadiumConverter;


    @Resource
    private Converter<StadiumData,StadiumModel>stadiumReverseConverter;

    @Override
    public List<StadiumData> getAllStadiums() {

        final List<StadiumModel> stadiumModels = stadiumService.getStadiums();
        final List<StadiumData> stadiumFacadeData = new ArrayList<StadiumData>();
        for (final StadiumModel model : stadiumModels) {
            stadiumFacadeData.add(stadiumConverter.convert(model));
        }

        return stadiumFacadeData;
    }

    @Override
    public List<StadiumData> getStadiumsIsOpen(String status) {
        final List<StadiumModel> stadiumModels = stadiumService.getStadiumsIsOpen(status);
        final List<StadiumData> stadiumFacadeData = new ArrayList<StadiumData>();
        for (final StadiumModel model : stadiumModels) {
            stadiumFacadeData.add(stadiumConverter.convert(model));
        }

        return stadiumFacadeData;
    }

    @Override
    public StadiumData getStadiumByCode(String code) {
        return Optional
                .ofNullable(stadiumService.getStadiumByCode(code))
                .map(model -> stadiumConverter.convert(model))
                .orElse(null);
    }

    @Override
    public StadiumData save(StadiumData data) {

        return Optional.ofNullable(stadiumService.save(stadiumReverseConverter.convert(data)))
                .map(s->stadiumConverter.convert(s))
                .orElseThrow(()->new EntitySaveOrUpdateException("Create stadium failed!"));
    }


}

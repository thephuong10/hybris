package hcmue.edu.vn.facades.club.impl;

import de.hybris.platform.hcmue.edu.vn.data.ClubData;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import hcmue.edu.vn.core.model.ClubModel;
import hcmue.edu.vn.core.service.ClubService;
import hcmue.edu.vn.facades.training.ClubFacade;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultClubFacade implements ClubFacade {


    @Resource
    private ClubService clubService;

    @Resource
    private Converter<ClubModel,ClubData>clubConverter;

    @Resource
    private Converter<ClubData,ClubModel>clubReverseConverter;

    @Override
    public List<ClubData> getAll() {
        return clubService.getAll()
                .stream()
                .map(c -> clubConverter.convert(c))
                .collect(Collectors.toList());
    }
}

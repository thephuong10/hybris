package hcmue.edu.vn.facades.stadium;

import de.hybris.platform.hcmue.edu.vn.data.StadiumData;

import java.util.List;

public interface StadiumFacade {

    List<StadiumData> getAllStadiums();

    List<StadiumData> getStadiumsIsOpen(String code);

    StadiumData getStadiumByCode(String code);

    StadiumData save(StadiumData data);

}

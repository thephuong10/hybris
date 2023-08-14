package hcmue.edu.vn.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.hcmue.edu.vn.data.ClubData;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import hcmue.edu.vn.core.model.ClubModel;

public class ClubReversePopulator implements Populator<ClubData, ClubModel> {
    @Override
    public void populate(ClubData source, ClubModel target) throws ConversionException {
        target.setCode(source.getCode());
        target.setName(source.getName());
    }
}

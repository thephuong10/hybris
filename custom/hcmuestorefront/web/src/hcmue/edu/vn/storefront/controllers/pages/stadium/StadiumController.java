package hcmue.edu.vn.storefront.controllers.pages.stadium;

import de.hybris.platform.hcmue.edu.vn.data.StadiumData;
import hcmue.edu.vn.core.enums.StadiumType;
import hcmue.edu.vn.core.requestData.StadiumRequestData;
import hcmue.edu.vn.facades.exception.EntitySaveOrUpdateException;
import hcmue.edu.vn.facades.club.ClubFacade;
import hcmue.edu.vn.facades.stadium.StadiumFacade;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;


@Controller
public class StadiumController {

    private static final Logger LOG =
            Logger.getLogger(StadiumController.class.getName());

    @Resource
    private StadiumFacade stadiumFacade;

    @Resource
    private ClubFacade clubFacade;

    //get all stadium
    @RequestMapping(value = {"/stadiums","/stadiums/"})
    public String showStadiums(final Model model) {
        List<StadiumData> stadiums = stadiumFacade.getAllStadiums();
        model.addAttribute("stadiums", stadiums);
        return "AllStadiumListing";
    }

    @RequestMapping(value = {"/stadiums/opening","/stadiums/opening/"})
    public String showStadiumsIsOpen(final Model model) {
        final List<StadiumData> stadiums = stadiumFacade.getStadiumsIsOpen(StadiumType.OPEN.getCode());
        model.addAttribute("stadiums", stadiums);
        return "StadiumIsOpen";
    }

    @RequestMapping(value = {"/stadiums/{code}","stadiums/{code}/"})
    public String showStadiumsDetail(final Model model, @PathVariable(name = "code") String code) {

        final StadiumData stadium = stadiumFacade.getStadiumByCode(code);

        model.addAttribute("stadium", stadium);

        return "StadiumById";
    }

    @RequestMapping(value = "/stadiums/form",method = RequestMethod.GET)
    public String stadiumForm(final Model model)
    {

        model.addAttribute("stadiumRequestData",new StadiumRequestData());
        model.addAttribute("clubs",clubFacade.getAll());

        return "FormStadium";
    }


    @RequestMapping(value = "/stadiums/addStadium",method = RequestMethod.POST)
    public String Save(final Model model,
                       @Validated @ModelAttribute("stadiumRequestData") StadiumRequestData stadiumRequestData,
                       BindingResult bindingResult)
    {

        String message = "";

        if(bindingResult.hasErrors()){

            message = "One of the above fields has been left blank or invalid !";

            return "redirect:./form?message=" + message;
        }

        try {

            StadiumData stadium = new StadiumData();

            stadium.setName(stadiumRequestData.getName());
            stadium.setCode(stadiumRequestData.getCode());
            stadium.setCapacity(stadiumRequestData.getCapacity().toString());
            stadium.setOwner(stadiumRequestData.getClubCode());

            stadium = stadiumFacade.save(stadium);

            return "redirect:./" + stadium.getCode();

        } catch (EntitySaveOrUpdateException e) {

            message = e.getMessage();

        } catch (Exception e){

            message = "Server Error";
        }

        return "redirect:./form?message=" + message;
    }

}

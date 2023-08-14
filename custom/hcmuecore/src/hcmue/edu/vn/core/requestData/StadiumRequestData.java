package hcmue.edu.vn.core.requestData;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class StadiumRequestData {

    @NotEmpty(message = "This field cannot be left blank !")
    @Length(min = 1, message = "Minimum length is 1")
    private String code;

    @NotEmpty(message = "This field cannot be left blank !")
    @Length(min = 1, message = "Minimum length is 1")
    private String clubCode;

    @NotEmpty(message = "This field cannot be left blank !")
    @Length(min = 1, message = "Minimum length is 1")
    private String name;


    @NotNull(message = "This field cannot be left blank !")
    @Min(value = 10,message = "Minimum quantity is 10")
    @Digits(fraction = 0, integer = 10, message = "")
    private Integer capacity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StadiumRequestData() {

    }

    public String getClubCode() {
        return clubCode;
    }

    public void setClubCode(String clubCode) {
        this.clubCode = clubCode;
    }
}

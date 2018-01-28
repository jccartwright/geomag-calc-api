package gov.noaa.ncei.geomag

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Max

@Validated
class Declination {
    //input values
    ModelType model = ModelType.WMM   //default to WMM
    Date date = new Date()            //default to today

    @NotNull
    Double longitude
    @NotNull
    Double latitude

    //calculated values
    Double declination
    Double rate
    //String actualModel

}

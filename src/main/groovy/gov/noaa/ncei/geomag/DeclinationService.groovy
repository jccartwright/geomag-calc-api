package gov.noaa.ncei.geomag

import org.springframework.stereotype.Service
import groovy.util.logging.Log4j

@Log4j
@Service
class DeclinationService {

    Declination calculateDeclination(Declination input) {

        //
        //TODO model calculation goes here
        //
        Declination d = new Declination()
        d.model = input.model
        d.longitude = input.longitude
        d.latitude = input.latitude
        d.date = input.date

        return d
    }
}

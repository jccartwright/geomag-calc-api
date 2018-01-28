package gov.noaa.ncei.geomag

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid;


@RestController
class DeclinationController {
    @Autowired
    private DeclinationService declinationService

    @RequestMapping(value = "/declination", method=RequestMethod.POST)
    Declination getDeclination(@RequestBody @Valid Declination input, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("missing required field")
        }

        //TODO replace w/ custom validator on domain class
        if (input.longitude < -180 || input.longitude > 180 || input.latitude < -90 || input.latitude > 90) {
            throw new IllegalArgumentException("invalid longitude or latitude values")
        }

        return declinationService.calculateDeclination(input)
    }


    @ExceptionHandler([IllegalArgumentException.class])
    ResponseEntity<?> handleException(Exception e) {
        def responseBody = [
            "timestamp": new Date().time,
            "status": HttpStatus.BAD_REQUEST.value(),
            "error": "Bad Request",
            "exception": e.class,
            "message": e.message,
            "path": "/declination"
        ]
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST)
    }
}



package gov.noaa.ncei.geomag

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class LongitudeValidator implements ConstraintValidator<LongitudeValidator, Double> {
    void initialize(LongitudeConstraint longitude) { }

    boolean isValid(Double longitude, ConstraintValidatorContext cxt) {
        return (longitude != null && longitude >= -180.0 && longitude <= 180.0)
    }

}

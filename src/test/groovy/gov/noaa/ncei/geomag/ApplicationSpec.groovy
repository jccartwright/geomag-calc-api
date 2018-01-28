package gov.noaa.ncei.geomag

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import org.springframework.context.ApplicationContext

@SpringBootTest
class ApplicationSpec extends Specification {

    @Autowired
    ApplicationContext context

    def 'smoke test'() {
        expect:
        context
    }

}


import static org.junit.Assert.assertEquals;
import com.weatherCheck.Builder.AtmosphereBuilder;
import org.junit.Test;
import com.weatherCheck.Domain.Atmosphere;

/**
 * Created by MaxPower on 05/10/2016.
 */
public class AtmosphereTest {

    @Test
    public void AtmosphereAttributesShouldBe10(){
        Atmosphere atmosphere = AtmosphereBuilder.anAtmosphere()
                .withHumidity(10)
                .withPressure(10)
                .withVisibility(10)
                .build();

        float hum = atmosphere.getHumidity();
        float vis = atmosphere.getVisibility();
        float pres = atmosphere.getHumidity();

        assertEquals(10, (long)hum);
        assertEquals(10, (long)vis);
        assertEquals(10, (long)pres);
    }


}

package unity.test.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;

@Service
public class PlayerMoveService {

    public double nextDouble(final double min, final double max) {
        DecimalFormat df = new DecimalFormat("#.##");
        double resultValue = min + ((max - min) * new Random().nextDouble());
        double getDouble = Double.parseDouble(df.format(resultValue));
        return getDouble;
    }
}

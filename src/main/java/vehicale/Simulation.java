package vehicale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vehicale.model.Vehicle;
import vehicale.strategy.BlockTravel;
import vehicale.model.Car;

public class Simulation {
    private static final Logger logger
            = LoggerFactory.getLogger(Simulation.class);
    public static void main(String[] args){
        logger.info("Short drive simulation without exception");
        Vehicle car = new Car("Code","BMW","NoName",2019,2);
        car.setStrategy(new BlockTravel(car));
        car.executeStrategy();

    }
}

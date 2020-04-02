package vehicle.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vehicle.model.Vehicle;

public class BlockTravel implements TravelStrategy {

  private static final Logger logger
      = LoggerFactory.getLogger(BlockTravel.class);

  private Vehicle vehicle;

  public BlockTravel(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  @Override
  public void drive() {
    logger.info("Drive around square block");
    vehicle.start();
    vehicle.moveForward();
    for (int i = 0; i < 4; i++) {
      vehicle.turnRight();
      vehicle.moveForward();
    }
    vehicle.parking();
    vehicle.stop();
    vehicle.moveReverse();
    vehicle.stop();
    vehicle.parking();
    vehicle.finish();
  }
}

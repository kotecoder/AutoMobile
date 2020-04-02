package vehicale.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vehicale.model.components.CarPart;
import vehicale.state.State;
import vehicale.state.State.CarState;
import vehicale.strategy.TravelStrategy;


public class Car extends Vehicle {

  static final int DEFAULT_DOORS_NUMBER = 4;
  private static final Logger logger
      = LoggerFactory.getLogger(Car.class);
  private int numberOfDoors;
  private State carState;
  private TravelStrategy strategy;

  public Car(String vinCode, String brand, String model, int year) {
    super(vinCode, brand, model, year);
    this.numberOfDoors = DEFAULT_DOORS_NUMBER;
  }

  public Car(String vinCode, String brand, String model, int year, int numberOfDoors) {
    super(vinCode, brand, model, year);
    this.numberOfDoors = numberOfDoors;
  }

  @Override
  public void setStrategy(TravelStrategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public void executeStrategy() {
    this.strategy.drive();
  }

  public State getCarState() {
    return carState;
  }

  public void setCarState(State carState) {
    this.carState = carState;
  }

  @Override
  public String toString() {
    return "Car{" +
        "carState=" + getCarState() +
        '}';
  }

  private void changeCarState(State carState) {
    setCarState(carState);
    String message = toString();
    logger.info(message);
  }

  private CarPart getCarPart(String carPart) {
    return getMapParts().get(carPart);
  }

  public void insertKey() {
    getCarPart(IGNITION).change(State.IgnitionState.KEY_IN);
  }

  public void turnKeyRight() {
    getCarPart(IGNITION).change(State.IgnitionState.KEY_TURNED);
    getCarPart(ENGINE).change(State.EngineState.ON);
  }

  public void turnKeyLeft() {
    getCarPart(IGNITION).change(State.IgnitionState.KEY_TURNED);
    getCarPart(ENGINE).change(State.EngineState.OFF);
  }

  public void removeKey() {
    getCarPart(IGNITION).change(State.IgnitionState.KEY_OUT);
  }

  public void putCarInDrive() {
    getCarPart(GEAR_BOX).change(State.GearBoxState.DRIVE);
  }

  public void putCarInPark() {
    getCarPart(GEAR_BOX).change(State.GearBoxState.PARK);
  }

  public void putCarInReverse() {
    getCarPart(GEAR_BOX).change(State.GearBoxState.REVERSE);
  }

  public void putCarInNeitral() {
    getCarPart(GEAR_BOX).change(State.GearBoxState.NEITRAL);
  }

  public void pressGasPedal() {
    getCarPart(GAS_PEDAL).change(State.PedalState.PRESSED);
  }

  public void releaseGasPedal() {
    getCarPart(GAS_PEDAL).change(State.PedalState.REALESED);
  }

  public void pressBreakPedal() {
    getCarPart(BREAK_PEDAL).change(State.PedalState.PRESSED);
  }

  public void releaseBreakPedal() {
    getCarPart(BREAK_PEDAL).change(State.PedalState.REALESED);
  }

  public void steerLeft() {
    getCarPart(WHEEL).change(State.WheelsState.LEFT);
  }

  public void steerRight() {
    getCarPart(WHEEL).change(State.WheelsState.RIGHT);
  }

  public void steerStraight() {

    getCarPart(WHEEL).change(State.WheelsState.MOVE);
  }

  public void finish() {
    turnKeyLeft();
    removeKey();
    changeCarState(State.CarState.OFF);

  }

  public void parking() {
    if (!State.CarState.STOP.equals(getCarState())) {
      logger.error("Error: You just tried to put the car in park while it was moving!");
    }
    pressBreakPedal();
    changeCarState(State.CarState.STOP);
    putCarInPark();
    releaseBreakPedal();
    changeCarState(State.CarState.PARKED);

  }

  public void moveReverse() {
    putCarInReverse();
    pressGasPedal();
    releaseGasPedal();
    changeCarState(CarState.MOVING_REVERSE);
  }

  public void stop() {
    releaseGasPedal();
    pressBreakPedal();
    putCarInNeitral();
    changeCarState(State.CarState.STOP);
  }

  public void turnRight() {
    if (getCarState().equals(State.CarState.MOVING_FORWARD)) {
      steerRight();
      changeCarState(State.CarState.MOVING_RIGHT);
    }

  }

  public void moveForward() {
    if (getCarState().equals(State.CarState.ON)) {
      putCarInDrive();
      pressGasPedal();
      steerStraight();
      changeCarState(State.CarState.MOVING_FORWARD);

    }
  }

  public void start() {
    insertKey();
    turnKeyRight();
    changeCarState(State.CarState.ON);

  }
}

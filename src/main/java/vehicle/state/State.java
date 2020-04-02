package vehicle.state;

public interface State {

  enum CarState implements State {
    OFF, ON, MOVING_FORWARD, MOVING_REVERSE, MOVING_RIGHT, MOVING_LEFT, READY, STOP, PARKED

  }

  enum EngineState implements State {
    ON, OFF
  }

  enum GearBoxState implements State {
    DRIVE, REVERSE, PARK, NEITRAL
  }

  enum IgnitionState implements State {
    KEY_IN, KEY_OUT, KEY_TURNED
  }

  enum PedalState implements State {
    PRESSED, RELEASED
  }

  enum WheelsState implements State {
    MOVE, STOP, RIGHT, LEFT
  }
}


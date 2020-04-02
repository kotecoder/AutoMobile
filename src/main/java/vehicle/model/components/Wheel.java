package vehicle.model.components;

import vehicle.state.State;

public class Wheel extends CarPart {

  public Wheel() {
    setState(State.WheelsState.STOP);
  }

  @Override
  public String toString() {
    return "Wheel{" +
        "state=" + getState() +
        '}';
  }

}

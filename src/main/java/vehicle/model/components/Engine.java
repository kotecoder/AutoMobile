package vehicle.model.components;

import vehicle.state.State;

public class Engine extends CarPart {

  public Engine() {
    setState(State.EngineState.OFF);
  }

  @Override
  public String toString() {
    return "Engine{" +
        "state=" + getState() +
        '}';
  }
}

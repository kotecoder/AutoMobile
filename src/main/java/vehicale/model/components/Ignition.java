package vehicale.model.components;

import vehicale.state.State;

public class Ignition extends CarPart {

  public Ignition() {
    setState(State.IgnitionState.KEY_OUT);
  }

  @Override
  public String toString() {
    return "Ignition{" +
        "state=" + getState() +
        '}';
  }
}

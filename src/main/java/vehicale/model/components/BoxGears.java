package vehicale.model.components;

import vehicale.state.State;

public class BoxGears extends CarPart {

  public BoxGears() {
    setState(State.GearBoxState.PARK);
  }

  @Override
  public String toString() {
    return "BoxGears{" +
        "state=" + getState() +
        '}';
  }
}

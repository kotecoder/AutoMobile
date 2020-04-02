package vehicle.model.components.pedal;

import vehicle.model.components.CarPart;
import vehicle.state.State;

public abstract class Pedal extends CarPart {

    public Pedal( ) {
        setState(State.PedalState.RELEASED);
    }

    public void pressPedal(){
        change(State.PedalState.PRESSED);
    }

    public void releasePedal(){
        change(State.PedalState.RELEASED);
    }


}

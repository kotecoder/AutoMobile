package vehicale.model.components.pedal;

import vehicale.model.components.CarPart;
import vehicale.state.State;

public abstract class Pedal extends CarPart {

    public Pedal( ) {
        setState(State.PedalState.REALESED);
    }

    public void pressPedal(){
        change(State.PedalState.PRESSED);
    }

    public void releasePedal(){
        change(State.PedalState.REALESED);
    }


}

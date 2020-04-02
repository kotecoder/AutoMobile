package vehicle.model.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vehicle.state.State;

public abstract class CarPart {
    private static final Logger logger
            = LoggerFactory.getLogger(CarPart.class);

    State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void change(State carState){
        setState(carState);
        String message = toString();
        logger.info(message);
    }
}

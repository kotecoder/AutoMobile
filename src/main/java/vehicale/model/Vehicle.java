package vehicale.model;

import vehicale.model.components.CarPart;
import vehicale.model.components.Engine;
import vehicale.model.components.Ignition;
import vehicale.model.components.Wheel;
import vehicale.model.components.BoxGears;
import vehicale.model.components.pedal.BreakPedal;
import vehicale.model.components.pedal.GasPedal;

import java.util.*;
import vehicale.strategy.TravelStrategy;

public abstract class Vehicle implements Moveable{

  static final String ENGINE = "Engine";
  static final String IGNITION = "Ignition";
  static final String GEAR_BOX = "GearBox";
  static final String WHEEL = "Wheel";
  static final String BREAK_PEDAL = "BreakPedal";
  static final String GAS_PEDAL = "GasPedal";

  private final String vinCode;
  private final String brand;
  private final String model;
  private final int year;

  public  abstract void setStrategy(TravelStrategy strategy);
  public  abstract void executeStrategy();
  private Map<String, CarPart> mapParts = new HashMap<>();

  public String getVinCode() {
    return vinCode;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  public Map<String, CarPart> getMapParts() {
    return mapParts;
  }

  public void setMapParts(Map<String, CarPart> mapParts) {
    this.mapParts = mapParts;
  }

  protected Vehicle(String vinCode, String brand, String model, int year) {
    this.vinCode = vinCode;
    this.brand = brand;
    this.model = model;
    this.year = year;
    mapParts.put(ENGINE, new Engine());
    mapParts.put(GEAR_BOX, new BoxGears());
    mapParts.put(GAS_PEDAL, new GasPedal());
    mapParts.put(BREAK_PEDAL, new BreakPedal());
    mapParts.put(WHEEL, new Wheel());
    mapParts.put(IGNITION, new Ignition());
  }
}

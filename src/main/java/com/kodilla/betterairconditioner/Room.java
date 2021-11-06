package com.kodilla.betterairconditioner;

public class Room implements Tick
{
    AirConditioner airConditioner;

    double volume;
    double currentTemperature;

    public Room(double volume, double startTemp, boolean conditionerOn, AirConditioner airConditioner)
    {
        this.volume = volume;
        this.currentTemperature = startTemp;
        this.airConditioner = airConditioner;
        this.airConditioner.isOn = conditionerOn;
    }

    @Override
    public void tick()
    {
        currentTemperature += airConditioner.getDeltaTemp(1, volume, currentTemperature);
    }
}

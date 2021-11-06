package com.kodilla.betterairconditioner;

public class ProAirConditioner extends AirConditioner
{
    public ProAirConditioner(double targetTemperature)
    {
        super(2, targetTemperature);
    }


    @Override
    public double getDeltaTemp(double deltaTime, double volume, double currentTemperature)
    {
        return (isOn && currentTemperature > targetTemperature) ? -performance * deltaTime : 0;
    }
}

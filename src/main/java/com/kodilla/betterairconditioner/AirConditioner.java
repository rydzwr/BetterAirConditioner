package com.kodilla.betterairconditioner;

public abstract class AirConditioner
{
    public boolean isOn;
    double targetTemperature;
    protected double performance;

    public AirConditioner(double performance, double targetTemperature)
    {
        this.performance = performance;
        this.targetTemperature = targetTemperature;
    }

    double getDeltaTemp(double deltaTime, double volume, double currentTemperature)
    {
        return (isOn && currentTemperature > targetTemperature) ? -(performance / volume) * deltaTime : 0;
    }
}
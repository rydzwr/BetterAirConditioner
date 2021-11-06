package com.kodilla.betterairconditioner;

import java.util.ArrayList;
import java.util.Random;

public class Building implements Tick
{
    ArrayList<Room> rooms;

    public Building(int roomsCount)
    {
        rooms = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < roomsCount; i++)
        {
            double volume = random.nextDouble() * 5 + 1;
            double startTemp = random.nextDouble() * 45 + 5;
            boolean isOn = random.nextBoolean();
            double targetTemp = startTemp - random.nextDouble() * 20 + 5;

            AirConditioner airConditioner;
            if (random.nextBoolean())
                airConditioner = new BasicAirConditioner(targetTemp);
            else
                airConditioner = new ProAirConditioner(targetTemp);

            Room room = new Room(volume, startTemp, isOn, airConditioner);
            rooms.add(room);
        }
    }

    @Override
    public void tick()
    {
        for (Room room : rooms)
        {
            room.tick();
        }
    }

    @Override
    public String toString()
    {
        String out = "Temps: ";
        for (int i = 0; i < rooms.size(); i++)
        {
            out += "room " + (i + 1) + ": " + String.format("%.1f", rooms.get(i).currentTemperature) + "/" +
                    String.format("%.1f", rooms.get(i).airConditioner.targetTemperature) + " " +
                    ((rooms.get(i).airConditioner.isOn) ? "ON" : "OFF") + " ";
        }
        return out;
    }
}

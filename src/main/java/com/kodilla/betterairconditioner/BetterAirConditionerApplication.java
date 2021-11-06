package com.kodilla.betterairconditioner;

public class BetterAirConditionerApplication
{

    public static void main(String[] args)
    {
        Building building = new Building(10);

        while (true)
        {
            building.tick();
            System.out.println(building.toString());
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}

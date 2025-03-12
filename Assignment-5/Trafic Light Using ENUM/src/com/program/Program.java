package com.program;
enum TrafficLight {
    RED(25), GREEN(45), YELLOW(5);  

    private final int duration;

    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}

public class Program {
    public static void main(String[] args) {
        for(TrafficLight light : TrafficLight.values()){
            System.out.println(light+"light Duration: "+light.getDuration()+ "seconds");
        }
    }
}

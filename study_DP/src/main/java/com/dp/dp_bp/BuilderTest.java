package com.dp.dp_bp;

public class BuilderTest {

    public static void main(String[] args) {

        ComputerBuilder builder = new DellComputerBuilder();
        Director director = new Director(builder);
        director.construct();
        Computer computer = builder.build();
        System.out.println(computer.toString());


    }

}

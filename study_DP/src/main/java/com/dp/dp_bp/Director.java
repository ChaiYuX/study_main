package com.dp.dp_bp;

public class Director {

    private ComputerBuilder builder;

    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.setCpu("Intel Core 13 i9");
        builder.setHardDisk("1TB HDD");
        builder.setGraphicsCard("NVIDA GTX4080 Ti 16GB");
        builder.setMemoryBank("32GB DDR5 *2");
    }
}

package com.dp.dp_bp;

public class Computer {

    private String cpu;
    private String graphicsCard;
    private String hardDisk;
    private String memoryBank;

    public Computer(String cpu, String graphicsCard, String hardDisk, String memoryBank) {
        this.cpu = cpu;
        this.graphicsCard = graphicsCard;
        this.hardDisk = hardDisk;
        this.memoryBank = memoryBank;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", memoryBank='" + memoryBank + '\'' +
                '}';
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getMemoryBank() {
        return memoryBank;
    }

    public void setMemoryBank(String memoryBank) {
        this.memoryBank = memoryBank;
    }
}

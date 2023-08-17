package com.dp.dp_bp;

public class DellComputerBuilder implements ComputerBuilder{

    private String cpu;
    private String graphicsCard;
    private String hardDisk;
    private String memoryBank;

    @Override
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    @Override
    public void setMemoryBank(String memoryBank) {
        this.memoryBank = memoryBank;
    }

    @Override
    public Computer build() {
        return new Computer(cpu , graphicsCard , hardDisk , memoryBank);
    }
}

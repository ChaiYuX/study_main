package com.dp.dp_bp;

public interface ComputerBuilder {

    void setCpu(String cpu);
    void setGraphicsCard(String graphicsCard);
    void setHardDisk(String hardDisk);
    void setMemoryBank(String memoryBank);

    Computer build();

}

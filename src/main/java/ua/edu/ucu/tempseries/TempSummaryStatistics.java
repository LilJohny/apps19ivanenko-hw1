package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double maxTemp;
    private final double minTemp;
    private final double avgTemp;
    private final double devTemp;
    public TempSummaryStatistics(double avgTemp, double devTemp, double minTemp, double maxTemp){
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }
    
}

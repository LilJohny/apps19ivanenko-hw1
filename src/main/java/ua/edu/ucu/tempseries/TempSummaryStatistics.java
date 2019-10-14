package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    public final double maxTemp;
    public final double minTemp;
    public final double avgTemp;
    public final double devTemp;
    TempSummaryStatistics(double avg, double dev, double min, double max) {
        this.avgTemp = avg;
        this.devTemp = dev;
        this.minTemp = min;
        this.maxTemp = max;
    }
    
}

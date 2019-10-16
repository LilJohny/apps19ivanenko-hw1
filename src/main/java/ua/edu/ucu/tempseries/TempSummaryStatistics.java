package ua.edu.ucu.tempseries;


public class TempSummaryStatistics {
    private final double maxTemp;
    private final double minTemp;
    private final double avgTemp;
    private final double devTemp;

    TempSummaryStatistics(double avg, double dev, double min, double max) {
        this.avgTemp = avg;
        this.devTemp = dev;
        this.minTemp = min;
        this.maxTemp = max;
    }
    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }
}

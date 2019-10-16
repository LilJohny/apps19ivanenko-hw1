package ua.edu.ucu.tempseries;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TempSummaryStatistics that = (TempSummaryStatistics) o;
        return Double.compare(that.maxTemp, maxTemp) == 0
                && Double.compare(that.minTemp, minTemp) == 0
                && Double.compare(that.avgTemp, avgTemp) == 0
                && Double.compare(that.devTemp, devTemp) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxTemp, minTemp, avgTemp, devTemp);
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

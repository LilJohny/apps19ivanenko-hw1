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

    @Override
    public int hashCode(){
        return Double.valueOf(avgTemp+devTemp+minTemp+maxTemp).hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof TempSummaryStatistics) {
            TempSummaryStatistics other = ((TempSummaryStatistics) o);
            return this.hashCode() == other.hashCode();
        } else {
            return false;
        }
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

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
    public boolean equals(Object o) {
        if (o instanceof TempSummaryStatistics) {
            TempSummaryStatistics other = ((TempSummaryStatistics) o);
            boolean avgEq = this.getAvgTemp() == other.getAvgTemp();
            boolean devEq = this.getDevTemp() == other.getDevTemp();
            boolean minEq = this.getMinTemp() == other.getMinTemp();
            boolean maxEq = this.getMaxTemp() == other.getMaxTemp();
            return avgEq && devEq && minEq && maxEq;
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

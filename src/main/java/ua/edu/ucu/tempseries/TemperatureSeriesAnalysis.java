package ua.edu.ucu.tempseries;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = null;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
    }

    public double average() {
        double average = 0.0;
        for (double temperature : this.temperatureSeries) {
            average+=temperature;
        }
        return average/this.temperatureSeries.length;
    }

    public double deviation() {
        return 0;
    }

    public double min() {
        double min = this.temperatureSeries[0];
        for (int i = 1; i <this.temperatureSeries.length ; i++) {
            if (min >=this.temperatureSeries[i])
                min = this.temperatureSeries[i];
        }
        return min;
    }

    public double max() {
        double max = this.temperatureSeries[0];
        for (int i = 1; i < this.temperatureSeries.length; i++) {
            if (max <=this.temperatureSeries[i])
                max = this.temperatureSeries[i];
        }
        return max;
    }

    public double findTempClosestToZero() {
        return 0;
    }

    public double findTempClosestToValue(double tempValue) {
        return 0;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        return 0;
    }
}

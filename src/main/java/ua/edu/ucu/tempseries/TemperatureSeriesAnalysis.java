package ua.edu.ucu.tempseries;


import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private static final int DEFAULT_SERIES_SIZE = 50;
    private static final double MIN_POSSIBLE_TEMP = -273.0;
    private double[] series;
    private int length;
    private int capacity;

    public TemperatureSeriesAnalysis() {
        this.series = new double[DEFAULT_SERIES_SIZE];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.length = temperatureSeries.length;
        this.capacity = temperatureSeries.length;
        this.series = new double[length];
        for (double temp : temperatureSeries) {
            if (temp < MIN_POSSIBLE_TEMP) {
                throw new InputMismatchException("Temperature is out of range");
            }
        }
        System.arraycopy(temperatureSeries, 0, this.series, 0, length);

    }

    public double average() {
        double average = 0.0;
        if (this.series.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            for (double temperature : this.series) {
                average += temperature;
            }
            return average / this.series.length;
        }
    }

    public double deviation() {
        if (this.series.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            double standardDeviation = 0;
            double average = this.average();
            for (int i = 0; i < this.series.length; i++) {
                double distance = this.series[i] - average;
                standardDeviation += Math.pow(distance, 2.0)
                        / this.series.length;
            }
            standardDeviation = Math.sqrt(standardDeviation);
            return standardDeviation;
        }
    }

    public double min() {
        if (this.series.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            double min = this.series[0];
            for (int i = 1; i < this.series.length; i++) {
                if (min >= this.series[i]) {
                    min = this.series[i];
                }
            }
            return min;
        }
    }

    public double max() {
        if (this.series.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            double max = this.series[0];
            for (int i = 1; i < this.series.length; i++) {
                if (max <= this.series[i]) {
                    max = this.series[i];
                }
            }
            return max;
        }
    }

    public double findTempClosestToZero() {
        if (this.series.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            return this.findTempClosestToValue(0.0);
        }
    }

    public double findTempClosestToValue(double tempValue) {
        if (this.series.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            double closestTemp = this.series[0];
            double closestTempDistance = closestTemp - tempValue;
            for (int i = 1; i < this.length; i++) {
                double currentDistance = this.series[i] - tempValue;
                if (currentDistance < closestTempDistance) {
                    closestTemp = this.series[i];
                    closestTempDistance = currentDistance;
                }
            }
            return closestTemp;
        }

    }

    public double[] findTempsLessThen(double tempValue) {
        int arrSize = 0;
        for (double temp : this.series) {
            if (temp < tempValue) {
                arrSize += 1;
            }
        }
        double[] tempsLessThen = new double[arrSize];
        int i = 0;
        for (double temp : this.series) {
            if (temp < tempValue) {
                tempsLessThen[i] = temp;
                i += 1;
            }
        }
        return tempsLessThen;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int arrSize = 0;
        for (double temp : this.series) {
            if (temp > tempValue) {
                arrSize += 1;
            }
        }
        double[] tempsGreaterThen = new double[arrSize];
        int i = 0;
        for (double temp : this.series) {
            if (temp > tempValue) {
                tempsGreaterThen[i] = temp;
                i += 1;
            }
        }
        return tempsGreaterThen;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (this.series.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            double avg = this.average();
            double dev = this.deviation();
            double min = this.min();
            double max = this.max();
            return new TempSummaryStatistics(avg, dev, min, max);
        }
    }

    public int addTemps(double... temps) {
        if (capacity - length < temps.length) {
            double[] newSeries = new double[this.length * 2];
            double[] oldSeries = this.series;
            if (this.length >= 0) {
                System.arraycopy(oldSeries, 0, newSeries, 0, this.length);
            }
            this.series = newSeries;
        }
        int j = 0;
        for (int i = this.length; i < this.length + temps.length; i++) {
            this.series[i] = temps[j];
        }
        return this.series.length;
    }
}

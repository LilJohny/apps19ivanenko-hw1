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
        this.capacity = DEFAULT_SERIES_SIZE;
        this.length = 0;
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

    public void checkIllegalArgumentException() {
        if (this.series.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLength() {
        return length;
    }

    public double average() {
        checkIllegalArgumentException();
        double average = 0.0;

        for (double temperature : this.series) {
            average += temperature;
        }
        return average / this.series.length;

    }

    public double deviation() throws IllegalArgumentException {
        checkIllegalArgumentException();
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

    public double min() throws IllegalArgumentException {
        checkIllegalArgumentException();
        double min = this.series[0];
        for (int i = 1; i < this.series.length; i++) {
            if (min >= this.series[i]) {
                min = this.series[i];
            }
        }
        return min;

    }

    public double max() throws IllegalArgumentException {
        checkIllegalArgumentException();
        double max = this.series[0];
        for (int i = 1; i < this.series.length; i++) {
            if (max <= this.series[i]) {
                max = this.series[i];
            }
        }
        return max;

    }

    public double findTempClosestToZero() throws IllegalArgumentException {
        checkIllegalArgumentException();
        return this.findTempClosestToValue(0.0);

    }

    public double findTempClosestToValue(double tempValue) {
        checkIllegalArgumentException();
        double closestTemp = this.series[0];
        double closestTempDistance = Math.abs(closestTemp - tempValue);
        for (int i = 1; i < this.length; i++) {
            double currentDistance = Math.abs(this.series[i] - tempValue);
            if (currentDistance < closestTempDistance) {
                closestTemp = this.series[i];
                closestTempDistance = currentDistance;
            }
        }
        return closestTemp;


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
        checkIllegalArgumentException();
        double avg = this.average();
        double dev = this.deviation();
        double min = this.min();
        double max = this.max();
        return new TempSummaryStatistics(avg, dev, min, max);
    }


    public int addTemps(double... temps) {
        if (capacity - length < temps.length) {
            double[] newSeries = new double[this.length * 2];
            double[] oldSeries = this.series;
            if (this.length >= 0) {
                System.arraycopy(oldSeries, 0, newSeries, 0, this.length);
            }
            this.length = this.series.length + temps.length;
            this.series = newSeries;
        }
        int j = 0;
        for (int i = this.length; i < this.length + temps.length; i++) {
            this.series[i] = temps[j];
            j += 1;
        }
        this.capacity = this.series.length;

        return this.length;
    }
}

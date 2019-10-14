package ua.edu.ucu.tempseries;


public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private int length;
    private int capacity;
    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = null;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
        this.length = temperatureSeries.length;
        this.capacity = temperatureSeries.length;
    }

    public double average() {
        double average = 0.0;
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            for (double temperature : this.temperatureSeries) {
                average += temperature;
            }
            return average / this.temperatureSeries.length;
        }
    }

    public double deviation() {
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            double standard_deviation = 0;
            double average = this.average();
            for (int i = 0; i < this.temperatureSeries.length; i++) {
                standard_deviation += ((this.temperatureSeries[i] - average) * (this.temperatureSeries[i] - average)) / this.temperatureSeries.length;
            }
            standard_deviation = Math.sqrt(standard_deviation);
            return standard_deviation;
        }
    }

    public double min() {
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            double min = this.temperatureSeries[0];
            for (int i = 1; i < this.temperatureSeries.length; i++) {
                if (min >= this.temperatureSeries[i])
                    min = this.temperatureSeries[i];
            }
            return min;
        }
    }

    public double max() {
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            double max = this.temperatureSeries[0];
            for (int i = 1; i < this.temperatureSeries.length; i++) {
                if (max <= this.temperatureSeries[i])
                    max = this.temperatureSeries[i];
            }
            return max;
        }
    }

    public double findTempClosestToZero() {
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            return this.findTempClosestToValue(0.0);
        }
    }

    public double findTempClosestToValue(double tempValue) {
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            double closestTemp = this.temperatureSeries[0];
            double closestTempDistance = closestTemp - tempValue;
            for (int i = 1; i < this.temperatureSeries.length; i++) {
                if (this.temperatureSeries[i] - tempValue < closestTempDistance) {
                    closestTemp = this.temperatureSeries[i];
                    closestTempDistance = this.temperatureSeries[i] - tempValue;
                }
            }
            return closestTemp;
        }

    }

    public double[] findTempsLessThen(double tempValue) {
        int arrSize = 0;
        for (double temp : this.temperatureSeries) {
            if (temp < tempValue) {
                arrSize += 1;
            }
        }
        double[] tempsLessThen = new double[arrSize];
        int i = 0;
        for (double temp : this.temperatureSeries) {
            if (temp < tempValue) {
                tempsLessThen[i] = temp;
                i += 1;
            }
        }
        return tempsLessThen;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int arrSize = 0;
        for (double temp : this.temperatureSeries) {
            if (temp > tempValue) {
                arrSize += 1;
            }
        }
        double[] tempsGreaterThen = new double[arrSize];
        int i = 0;
        for (double temp : this.temperatureSeries) {
            if (temp > tempValue) {
                tempsGreaterThen[i] = temp;
                i += 1;
            }
        }
        return tempsGreaterThen;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        } else {
            return new TempSummaryStatistics(this.average(), this.deviation(), this.min(), this.max());
        }
    }

    public int addTemps(double... temps) {
        if(capacity - length < temps.length){
            double[] newSeries = new double [this.length*2];
            if (this.length >= 0) System.arraycopy(this.temperatureSeries, 0, newSeries, 0, this.length);
            this.temperatureSeries = newSeries;
        }
            int j = 0;
            for (int i = this.length; i < this.length+temps.length; i++) {
                this.temperatureSeries[i] = temps[j];
            }
        return this.temperatureSeries.length;
    }
}

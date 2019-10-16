package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {
    private double[] shortTemperatureSeries;
    private double[] emptyTemperatureSeries;
    private double[] oneElementTemperatureSeries;
    private double[] illegalTemperatureSeries;
    @Before
    public void setUp(){
        shortTemperatureSeries = new double[]{3.0, -5.0, 1.0, 5.0};
        emptyTemperatureSeries = new double[]{};
        oneElementTemperatureSeries = new double[]{-1.0};
        illegalTemperatureSeries = new double[]{3.0, -5.0, 1.0, 5.0, -279.0};
    }
    @Test
    public void testAverageWithOneElementArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(oneElementTemperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAverageFailure() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyTemperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }


    @Test
    public void testAverage() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(shortTemperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(shortTemperatureSeries);
        double expResult = -5.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinFailure() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyTemperatureSeries);
        double actualResult = seriesAnalysis.min();

    }

    @Test
    public void testMax() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(shortTemperatureSeries);
        double expResult = 5.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxFailure() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyTemperatureSeries);
        double actualResult = seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(shortTemperatureSeries);
        double expResult = 3.7416573867739413;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationFailure() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyTemperatureSeries);
        double actualResult = seriesAnalysis.deviation();

    }

    @Test
    public void testFindTempClosestToZero() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(shortTemperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroFailure() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(emptyTemperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToZero();

    }

    @Test
    public void testFindTempClosestToValue() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(shortTemperatureSeries);
        double expResult = 3.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(4.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueFailure() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToValue(4.0);
    }

    @Test
    public void testFindTempsLessThen() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(shortTemperatureSeries);
        double[] expResult = {-5.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(1.0);
        assertArrayEquals(actualResult, expResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThen() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(shortTemperatureSeries);
        double[] expResult = {3.0, 5.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1.0);
        assertArrayEquals(actualResult, expResult, 0.00001);
    }

    @Test
    public void testStatisticsMin() {
        double max = 1.0;
        double min = 2.0;
        double dev = 3.0;
        double avg = 4.0;
        TempSummaryStatistics statistics = new TempSummaryStatistics(avg, dev, min, max);
        assertEquals(min, statistics.getMinTemp(), 0.0001);
    }
    @Test
    public void testStatisticsMax() {
        double max = 1.0;
        double min = 2.0;
        double dev = 3.0;
        double avg = 4.0;
        TempSummaryStatistics statistics = new TempSummaryStatistics(avg, dev, min, max);
        assertEquals(max, statistics.getMaxTemp(), 0.0001);
    }
    @Test
    public void testStatisticsDev() {
        double max = 1.0;
        double min = 2.0;
        double dev = 3.0;
        double avg = 4.0;
        TempSummaryStatistics statistics = new TempSummaryStatistics(avg, dev, min, max);
        assertEquals(dev, statistics.getDevTemp(), 0.0001);
    }
    @Test
    public void testStatisticsAvg() {
        double max = 1.0;
        double min = 2.0;
        double dev = 3.0;
        double avg = 4.0;
        TempSummaryStatistics statistics = new TempSummaryStatistics(avg, dev, min, max);
        assertEquals(avg, statistics.getAvgTemp(), 0.0001);
    }
    @Test
    public void testAddTemps(){
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(shortTemperatureSeries);
        int expResult = 6;
        int actualResult = seriesAnalysis.addTemps(3.7, 9.3);
        assertEquals(expResult, actualResult);
    }
    @Test(expected = InputMismatchException.class)
    public void testCreationFilure(){
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(illegalTemperatureSeries);
    }
    public  void testCreationEmpty(){
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        assertEquals(50, seriesAnalysis.capacity);
        assertEquals(0, seriesAnalysis.length);
    }


}

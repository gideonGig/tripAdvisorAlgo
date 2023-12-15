package threadtutorials;

public class MinMaxMetrics {
    
    // Add all necessary member variables

    /**
     * Initializes all member variables#
     */

     private volatile long minNumber;
     private volatile long maxNumber;
    public MinMaxMetrics() {
        // Add code here
        minNumber = Long.MAX_VALUE;
        maxNumber = Long.MIN_VALUE;
    }

    /**
     * Adds a new sample to our metrics.
     */
    public synchronized void addSample(long newSample) {
        if (newSample > maxNumber) {
            maxNumber = newSample;
        }

        if (newSample < minNumber) {
            minNumber = newSample;
        }
    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        // Add code here
        return minNumber;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        // Add code here
        return maxNumber;
    }
}


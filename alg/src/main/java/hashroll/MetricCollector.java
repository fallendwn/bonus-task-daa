package hashroll;
import java.io.FileWriter;
import java.io.IOException;

public class MetricCollector {

    private long collisionCounter = 0;            // collision
    private long falsePositiveCounter = 0;        // hash matched, differest strings
    private long HashCalc = 0;                    // hash calculations
    private long matchesFound = 0;                // matches
    private long totalRuntimeNs = 0;              //total time

    private long startTime;

    // timer start
    public void start() {
        startTime = System.nanoTime();
    }

    // timer stop
    public void stop() {
        totalRuntimeNs = System.nanoTime() - startTime;
    }

    // metrics increase methods
    public void collision() {
        collisionCounter++;
    }

    public void falsePositive() {
        falsePositiveCounter++;
    }


    public void hashCalc() {
        HashCalc++;
    }

    public void matches() {
        matchesFound++;
    }

    // export csv
    public void exportCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {

            writer.append("Metrics\n");
            writer.append("Collisions,").append(String.valueOf(collisionCounter)).append("\n");
            writer.append("False Positives,").append(String.valueOf(falsePositiveCounter)).append("\n");
            writer.append("Hash calculation,").append(String.valueOf(HashCalc)).append("\n");
            writer.append("Matches Found,").append(String.valueOf(matchesFound)).append("\n");
            writer.append("Runtime (ns),").append(String.valueOf(totalRuntimeNs)).append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
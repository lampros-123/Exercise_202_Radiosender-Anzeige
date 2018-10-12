package bl;

/**
 *
 * @author Matthias
 */
public class Sender {
    private String name;
    private double frequency;
    private String band;

    public Sender(String name, double frequency, String band) {
        this.name = name;
        this.frequency = frequency;
        this.band = band;
    }

    public String getBand() {
        return band;
    }

    public double getFrequency() {
        return frequency;
    }

    public String getName() {
        return name;
    }
}

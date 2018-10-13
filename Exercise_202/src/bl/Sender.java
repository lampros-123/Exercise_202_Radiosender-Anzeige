package bl;

import java.io.Serializable;

/**
 *
 * @author Matthias
 */
public class Sender implements Serializable{
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

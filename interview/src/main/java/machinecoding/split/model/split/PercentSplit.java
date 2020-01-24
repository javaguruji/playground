package machinecoding.split.model.split;

import machinecoding.split.model.User;

/**
 * @author badrikant.soni
 */
public class PercentSplit extends Split {

    private double percentage;

    public PercentSplit(User user, double percentage) {
        super(user);
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}

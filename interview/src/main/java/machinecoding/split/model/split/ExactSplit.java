package machinecoding.split.model.split;

import machinecoding.split.model.User;

/**
 * @author badrikant.soni
 */
public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}

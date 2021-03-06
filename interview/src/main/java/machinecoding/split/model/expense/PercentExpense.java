package machinecoding.split.model.expense;

import machinecoding.split.model.User;
import machinecoding.split.model.split.PercentSplit;
import machinecoding.split.model.split.Split;

import java.util.List;

/**
 * @author badrikant.soni
 */
public class PercentExpense extends Expense {

    public PercentExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata metadata) {
        super(amount, paidBy, splits, metadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof PercentSplit)) {
                return false;
            }
        }

        double totalPercent = 100;
        double sumSplitPercent = 0;
        for (Split split : getSplits()) {
            PercentSplit exactSplit = (PercentSplit) split;
            sumSplitPercent += exactSplit.getPercentage();
        }

        if (totalPercent != sumSplitPercent) {
            return false;
        }

        return true;
    }
}

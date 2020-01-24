package machinecoding.split.model.expense;

import machinecoding.split.model.User;
import machinecoding.split.model.split.ExactSplit;
import machinecoding.split.model.split.Split;

import java.util.List;

/**
 * @author badrikant.soni
 */
public class ExactExpense extends Expense {

    public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata metadata) {
        super(amount, paidBy, splits, metadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit)) {
                return false;
            }
        }

        double totalAmount = getAmount();
        double sumSplitAmount = 0;
        for (Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }

        if (totalAmount != sumSplitAmount) {
            return false;
        }

        return true;
    }
}

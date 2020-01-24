package machinecoding.split.model.expense;

import machinecoding.split.model.User;
import machinecoding.split.model.split.EqualSplit;
import machinecoding.split.model.split.Split;

import java.util.List;

/**
 * @author badrikant.soni
 */
public class EqualExpense extends Expense {

    public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata metadata) {
        super(amount, paidBy, splits, metadata);
    }

    @Override
    public boolean validate() {

        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}

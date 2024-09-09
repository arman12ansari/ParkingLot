package service.strategy.billCalculationStrategy;

import models.enums.BillCalculationStrategyName;

/**
 * @author mdarmanansari
 */
public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillCalculationStrategy(BillCalculationStrategyName billCalculationStrategyName) {
        return switch (billCalculationStrategyName) {
            case HOURLY_BILL_CALCULATION_STRATEGY -> new SimpleBillCalculationStrategy();
            case SURGE_BILL_CALCULATION_STRATEGY -> new SurgeBillCalculationStrategy();
        };
    }
}

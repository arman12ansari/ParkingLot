package service.strategy.spotAllocationStrategy;

import models.enums.SpotAllocationStrategyName;

/**
 * @author mdarmanansari
 */
public class SpotAllocationStrategyFactory {
    public static SpotAllocationStrategy getSpotAllocationStrategy(SpotAllocationStrategyName spotAllocationStrategyName) {
        return switch (spotAllocationStrategyName) {
            case NEAREST_SPOT_ALLOCATION_STRATEGY -> new LinearSpotAllocationStrategy();
        };
    }
}

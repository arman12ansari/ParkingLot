package controller;

import models.ParkingLot;
import service.InitialisationService;

/**
 * @author mdarmanansari
 */
public class InitController {
    private InitialisationService initialisationService;

    public InitController(InitialisationService initialisationService) {
        this.initialisationService = initialisationService;
    }

    public ParkingLot init() {
        return initialisationService.init();
    }
}

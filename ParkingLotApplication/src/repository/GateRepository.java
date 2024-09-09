package repository;

import exception.GateNotFoundException;
import models.Gate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mdarmanansari
 */
public class GateRepository {
    private Map<Integer, Gate> gateMap;

    public GateRepository() {
        this.gateMap = new HashMap<>();
    }

    public Gate get(int gateId) {
        Gate gate = gateMap.get(gateId);

        if (gate == null) {
            throw new GateNotFoundException("Gate not found with id: " + gateId);
        }
        return gate;
    }

    public void put(Gate gate) {
        gateMap.put(gate.getId(), gate);
        System.out.println("Gate has been added successfully");
    }
}

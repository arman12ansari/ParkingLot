package models;

import models.enums.GateStatus;
import models.enums.GateType;

/**
 * @author mdarmanansari
 */
public class Gate extends BaseModel {
    private int gateNumber;
    private GateType gateType;
    private GateStatus status;
    private String operatorName;

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}

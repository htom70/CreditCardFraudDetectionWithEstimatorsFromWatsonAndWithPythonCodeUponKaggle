package user.rendszerhaz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fraud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String transactionId;
    protected int time;
    protected double v1;
    protected double v2;
    protected double v3;
    protected double v4;
    protected double v5;
    protected double v6;
    protected double v7;
    protected double v8;
    protected double v9;
    protected double v10;
    protected double v11;
    protected double v12;
    protected double v13;
    protected double v14;
    protected double v15;
    protected double v16;
    protected double v17;
    protected double v18;
    protected double v19;
    protected double v20;
    protected double v21;
    protected double v22;
    protected double v23;
    protected double v24;
    protected double v25;
    protected double v26;
    protected double v27;
    protected double v28;
    protected double amount;

    private int predictedValue;

    private int observedValue;

    private boolean isPredicted;

    private boolean isObserved;

    private double positiveProbability;

    private double negativeProbability;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getV1() {
        return v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public double getV2() {
        return v2;
    }

    public void setV2(double v2) {
        this.v2 = v2;
    }

    public double getV3() {
        return v3;
    }

    public void setV3(double v3) {
        this.v3 = v3;
    }

    public double getV4() {
        return v4;
    }

    public void setV4(double v4) {
        this.v4 = v4;
    }

    public double getV5() {
        return v5;
    }

    public void setV5(double v5) {
        this.v5 = v5;
    }

    public double getV6() {
        return v6;
    }

    public void setV6(double v6) {
        this.v6 = v6;
    }

    public double getV7() {
        return v7;
    }

    public void setV7(double v7) {
        this.v7 = v7;
    }

    public double getV8() {
        return v8;
    }

    public void setV8(double v8) {
        this.v8 = v8;
    }

    public double getV9() {
        return v9;
    }

    public void setV9(double v9) {
        this.v9 = v9;
    }

    public double getV10() {
        return v10;
    }

    public void setV10(double v10) {
        this.v10 = v10;
    }

    public double getV11() {
        return v11;
    }

    public void setV11(double v11) {
        this.v11 = v11;
    }

    public double getV12() {
        return v12;
    }

    public void setV12(double v12) {
        this.v12 = v12;
    }

    public double getV13() {
        return v13;
    }

    public void setV13(double v13) {
        this.v13 = v13;
    }

    public double getV14() {
        return v14;
    }

    public void setV14(double v14) {
        this.v14 = v14;
    }

    public double getV15() {
        return v15;
    }

    public void setV15(double v15) {
        this.v15 = v15;
    }

    public double getV16() {
        return v16;
    }

    public void setV16(double v16) {
        this.v16 = v16;
    }

    public double getV17() {
        return v17;
    }

    public void setV17(double v17) {
        this.v17 = v17;
    }

    public double getV18() {
        return v18;
    }

    public void setV18(double v18) {
        this.v18 = v18;
    }

    public double getV19() {
        return v19;
    }

    public void setV19(double v19) {
        this.v19 = v19;
    }

    public double getV20() {
        return v20;
    }

    public void setV20(double v20) {
        this.v20 = v20;
    }

    public double getV21() {
        return v21;
    }

    public void setV21(double v21) {
        this.v21 = v21;
    }

    public double getV22() {
        return v22;
    }

    public void setV22(double v22) {
        this.v22 = v22;
    }

    public double getV23() {
        return v23;
    }

    public void setV23(double v23) {
        this.v23 = v23;
    }

    public double getV24() {
        return v24;
    }

    public void setV24(double v24) {
        this.v24 = v24;
    }

    public double getV25() {
        return v25;
    }

    public void setV25(double v25) {
        this.v25 = v25;
    }

    public double getV26() {
        return v26;
    }

    public void setV26(double v26) {
        this.v26 = v26;
    }

    public double getV27() {
        return v27;
    }

    public void setV27(double v27) {
        this.v27 = v27;
    }

    public double getV28() {
        return v28;
    }

    public void setV28(double v28) {
        this.v28 = v28;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String fraudId) {
        this.transactionId = fraudId;
    }

    public int getPredictedValue() {
        return predictedValue;
    }

    public void setPredictedValue(int predictedValue) {
        this.predictedValue = predictedValue;
    }

    public int getObservedValue() {
        return observedValue;
    }

    public void setObservedValue(int observedValue) {
        this.observedValue = observedValue;
    }

    public boolean isPredicted() {
        return isPredicted;
    }

    public void setPredicted(boolean predicted) {
        isPredicted = predicted;
    }

    public boolean isObserved() {
        return isObserved;
    }

    public void setObserved(boolean observed) {
        isObserved = observed;
    }

    public double getPositiveProbability() {
        return positiveProbability;
    }

    public void setPositiveProbability(double positiveProbability) {
        this.positiveProbability = positiveProbability;
    }

    public double getNegativeProbability() {
        return negativeProbability;
    }

    public void setNegativeProbability(double negativeProbability) {
        this.negativeProbability = negativeProbability;
    }
}

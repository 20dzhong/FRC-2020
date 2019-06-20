package FRC.team852.team852.util.libs.motorcontroller;


import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.*;

import java.util.ArrayList;
import java.util.Arrays;

import static edu.wpi.first.wpilibj.PIDSourceType.kDisplacement;

public class SparkMaxGroup extends SpeedControllerGroup implements PIDSource, PIDOutput {

    private ArrayList<SparkMax> speedControllerList = new ArrayList<>();
    private SparkMax leader;
    private PIDSourceType sourceType;
    private CANSparkMax.IdleMode idleMode;

    public SparkMaxGroup(SparkMax leader, SparkMax... speedControllers) {
        this(kDisplacement, leader, speedControllers);
    }

    public SparkMaxGroup(PIDSourceType sourceType, SparkMax leader, SparkMax... speedControllers) {
        this(SparkMax.IdleMode.kBrake, sourceType, leader, speedControllers);
    }

    public SparkMaxGroup(SparkMax.IdleMode idleMode, PIDSourceType sourceType, SparkMax leader, SparkMax... speedControllers) {
        super(leader, speedControllers);
        this.leader = leader;
        speedControllerList.addAll(Arrays.asList(speedControllers));
        this.sourceType = sourceType;
        this.idleMode = idleMode;
        speedControllerList.forEach(sc -> {
            sc.follow(leader);
            sc.setPIDSourceType(this.sourceType);
            sc.setIdleMode(idleMode);
        });
        speedControllerList.add(leader);

    }


    public void resetEncoders() {
        speedControllerList.forEach(SparkMax::resetEncoder);
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {
        sourceType = pidSource;
        speedControllerList.forEach(x -> x.setPIDSourceType(sourceType));
    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return sourceType;
    }

    @Override
    public double pidGet() {
        if (speedControllerList.size() == 0)
            return 0;
        double sum = speedControllerList.stream().mapToDouble(SparkMax::pidGet).sum();
        return sum / speedControllerList.size();
    }

    public void setInverted(boolean inverted) {
        this.leader.setInverted(inverted);
    }

    public void set(double speed) {
        leader.set(speed);
    }

    public void setIdleMode(SparkMax.IdleMode idleMode) {
        speedControllerList.forEach(sc -> sc.setIdleMode(idleMode));
        this.idleMode = idleMode;
    }

    public CANSparkMax.IdleMode getIdleMode() {
        return this.idleMode;
    }

}
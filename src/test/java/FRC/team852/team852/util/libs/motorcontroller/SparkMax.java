package FRC.team852.team852.util.libs.motorcontroller;


import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class SparkMax extends CANSparkMax implements PIDSource, PIDOutput {

    private double resetOffset, lastPos, val, lastSpeed, isInverted;
    private CANEncoder enc;
    private PIDSourceType m_sourceType;

    public SparkMax(int channel, MotorType motorType) {
        this(channel, motorType, PIDSourceType.kDisplacement);
    }

    public SparkMax(int channel, MotorType motorType, PIDSourceType sourceType) {
        this(channel, motorType, sourceType, false);
    }

    public SparkMax(int channel, MotorType motorType, PIDSourceType sourceType, boolean inverted) {
        super(channel, motorType);
        this.resetOffset = 0.0;
        this.lastPos = 0.0;
        this.val = 0.0;
        this.enc = getEncoder();
        this.m_sourceType = sourceType;
        this.setInverted(inverted);
        this.lastSpeed = 0;
    }

    public void set(double speed) {
        if (this.lastSpeed != speed) {
            super.set(speed);
            this.lastSpeed = speed;
        }
    }

    public double getEncoderPosition() {
        lastPos = val;
        val = enc.getPosition();
        val *= isInverted;
        if (resetOffset >= val - 0.05 && resetOffset <= val + 0.05) return 0.0000;
        if (val == 0.0) return lastPos - resetOffset;
        return val - resetOffset;
    }

    public void resetEncoder() {
        resetOffset += getEncoderPosition();
    }

    public void setInverted(boolean inverted) {
        super.setInverted(inverted);
        if (inverted) isInverted = -1.0;
        else isInverted = 1.0;
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {
        this.m_sourceType = pidSource;
    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return m_sourceType;
    }

    @Override
    public double pidGet() {
        switch (m_sourceType) {
            case kDisplacement:
                return getEncoderPosition();
            case kRate:
                return enc.getVelocity();
            default:
                return 0.0;
        }
    }
}

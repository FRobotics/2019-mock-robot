package frc.robot.subsystem.motor;

public interface EncoderMotor extends Motor {
    public double getSpeed();
    @Override
    EncoderMotor setInverted(boolean inverted);
    @Override
    EncoderMotor invert();
}
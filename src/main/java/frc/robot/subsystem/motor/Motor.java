package frc.robot.subsystem.motor;

public interface Motor {
    void setSpeed(double speed);
    Motor setInverted(boolean inverted);
    Motor invert();
}
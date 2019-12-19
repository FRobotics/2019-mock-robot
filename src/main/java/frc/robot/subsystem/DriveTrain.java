package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.input.Axis;
import frc.robot.input.Controller;
import frc.robot.subsystem.motor.CANDriveMotorPair;
import frc.robot.subsystem.motor.EncoderMotor;

public class DriveTrain {

    public enum State {
        STOPPED, CONTROLLED
    };

    private State state;

    private EncoderMotor leftMotor;
    private EncoderMotor rightMotor;

    public DriveTrain(int leftID, int leftID2, int rightID, int rightID2) {
        this.leftMotor = new CANDriveMotorPair(new TalonSRX(leftID), new TalonSRX(leftID2));
        this.rightMotor = new CANDriveMotorPair(new TalonSRX(rightID), new TalonSRX(rightID2));
        this.state = State.STOPPED;
    }

    public void setLeftMotorSpeed(double speed) {
        leftMotor.setSpeed(speed);
    }

    public void setRightMotorSpeed(double speed) {
        rightMotor.setSpeed(speed);
    }

    public void periodic(Controller c) {
        switch (state) {
        case STOPPED:
            setLeftMotorSpeed(0);
            setRightMotorSpeed(0);
            break;
        case CONTROLLED:
            double left_speed = c.getAxis(Axis.LEFT_Y);
            double right_speed = c.getAxis(Axis.RIGHT_Y);

            setLeftMotorSpeed(left_speed);
            setRightMotorSpeed(right_speed);
            break;
        }
    }

    public void setState(State state) {
        this.state = state;
    }
}

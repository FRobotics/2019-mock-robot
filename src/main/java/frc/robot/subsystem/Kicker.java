package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.input.Button;
import frc.robot.input.Controller;
import frc.robot.subsystem.motor.CANMotor;
import frc.robot.util.Timer;

public class Kicker {

    public enum State {STOPPED, CONTROLLED, PUNCH_ROLL, PUNCH_PUNCH};
    private State state;
    private Timer stateTimer;

    private DoubleSolenoid puncher;   
    private CANMotor motor;
    
    public Kicker(int puncherForward, int puncherBackward, int motorId){
        this.puncher = new DoubleSolenoid(puncherForward, puncherBackward);
        this.motor = new CANMotor(new TalonSRX(motorId));
        this.state = State.STOPPED;
        this.stateTimer = new Timer();
    }

    public void punch() {
        puncher.set(Value.kForward);
    }

    private void retractPuncher() {
        puncher.set(Value.kReverse);
    }

    public void stopRoller() {
        motor.setSpeed(0);
    }

    public void rollOut() {
        motor.setSpeed(1);
    }

    public void rollIn() {
        motor.setSpeed(-1);
    }    

    public void periodic(Controller c){
        switch(state){
        case STOPPED:
            retractPuncher();
            stopRoller();
            break;
        case CONTROLLED:
            retractPuncher();
            if (c.buttonDown(Button.A)) {
                rollIn();
            } else {
                stopRoller();
            }
            if (c.buttonPressed(Button.B)) {
                this.state = State.PUNCH_ROLL;
                this.stateTimer.start();
            }
            break;
        case PUNCH_ROLL:
            rollOut();
            if(this.stateTimer.timePassed() > 1000) {
                this.setState(State.PUNCH_PUNCH);
                this.stateTimer.start();
            }
            break;
        case PUNCH_PUNCH:
            punch();
            rollOut();
            if(this.stateTimer.timePassed() > 1000) {
                this.setState(State.CONTROLLED);
                this.stateTimer.start();
            }
            break;
    }

        
    }
    public void setState(State state){
        this.state = state;
    }
}

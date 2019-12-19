package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Solenoid;


public class Solenoid4150 {

    private Solenoid solenoid;
    private boolean setOnce;
    private boolean currentState;

    public Solenoid4150(int id) {
        this.solenoid = new Solenoid(id);
        this.setOnce = false;
    }

    public void set(boolean forward) {
        if (forward != currentState || !setOnce) {
            currentState = forward;
            this.solenoid.set(forward);
            this.setOnce = true;
        }
    }

}
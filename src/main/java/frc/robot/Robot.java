/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystem.Kicker;
import frc.robot.input.Controller;
import frc.robot.subsystem.DriveTrain;

public class Robot extends TimedRobot {

  private Controller controller;
  private DriveTrain driveTrain;
  private Kicker kicker;

  @Override
  public void robotInit() {
    this.controller = new Controller(0);
    this.driveTrain = new DriveTrain(13, 12, 11, 10);
    this.kicker = new Kicker(0, 1, 15); // TODO: fill out these values
  }

  @Override
  public void robotPeriodic() {
    driveTrain.periodic(controller);
    kicker.periodic(controller);
    controller.postPeriodic();
  }

  @Override
  public void teleopInit() {
    driveTrain.setState(DriveTrain.State.CONTROLLED);
    kicker.setState(Kicker.State.CONTROLLED);
  }

  @Override
  public void disabledInit() {
    driveTrain.setState(DriveTrain.State.STOPPED);
    kicker.setState(Kicker.State.STOPPED);
  }
}

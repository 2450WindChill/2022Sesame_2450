// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with tank
 * steering and an Xbox controller.
 */
public class Robot extends TimedRobot {
  public final WPI_TalonSRX m_rightMotor = new WPI_TalonSRX(1);
  public final WPI_TalonSRX m_rightMotor2 = new WPI_TalonSRX(2);
  public final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(m_rightMotor, m_rightMotor2);

  public final WPI_TalonSRX m_leftMotor = new WPI_TalonSRX(3);
  public final WPI_TalonSRX m_leftMotor2 = new WPI_TalonSRX(4);
  public final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(m_leftMotor, m_leftMotor2);
  
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
  private final XboxController m_driverController = new XboxController(0);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_leftMotor.setInverted(true);
    m_leftMotor2.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    // Drive with tank drive.
    // That means that the Y axis of the left stick moves the left side
    // of the robot forward and backward, and the Y axis of the right stick
    // moves the right side of the robot forward and backward.
    m_robotDrive.tankDrive(m_driverController.getLeftY(), m_driverController.getRightY());
  }
}

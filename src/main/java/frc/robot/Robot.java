// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.MjpegServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.ClimberStep1Command;
import frc.robot.commands.ClimberStep2Command;
// import frc.robot.commands.ParallelExample;
import frc.robot.commands.PneumaticsCommand;
import frc.robot.subsystems.ClimberStep1;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
//import com.revrobotics.REVLibError;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with tank
 * steering and an Xbox controller.
 */

 
public class Robot extends TimedRobot {
  Compressor phCompressor = new Compressor(7, PneumaticsModuleType.CTREPCM);

  // Defining motors and putting the right motors in a motor control group
  public final CANSparkMax m_rightMotor = new CANSparkMax(1, MotorType.kBrushed);
  public final CANSparkMax m_rightMotor2 = new CANSparkMax(2, MotorType.kBrushed);
  public final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(m_rightMotor, m_rightMotor2);

// Defining motors and putting the left motors in a motor control group
  public final CANSparkMax m_leftMotor = new CANSparkMax(3, MotorType.kBrushed);
  public final CANSparkMax m_leftMotor2 = new CANSparkMax(4, MotorType.kBrushed);
  public final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(m_leftMotor, m_leftMotor2);
  
  // Takes motor control groups and puts them in a differential drive
  // Putting motors into different motor groups
  // Confused about this code
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

//   // Defining where the xbox controller is plugged in
  public final XboxController m_driverController = new XboxController(0);
//   //final JoystickButton b = new JoystickButton(m_driverController, 2);

  // Defining the b button 
  public final JoystickButton m_aButton = new JoystickButton(m_driverController, Button.kA.value);
  public final JoystickButton m_bButton = new JoystickButton(m_driverController, Button.kB.value);
  public final JoystickButton m_xButton = new JoystickButton(m_driverController, Button.kX.value);

  // Confused
  // public final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();
  public final PneumaticsSubsystem m_PneumaticsSubsystem = new PneumaticsSubsystem();
  public final ClimberStep1 m_ClimberStep1 = new ClimberStep1();
  //public final EmptyCommand empty = new EmptyCommand(m_ShooterSubsystem);  
  public final AutonomousCommand m_autonomousCommand = new AutonomousCommand(this);
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightMotor.setInverted(false);
    m_rightMotor2.setInverted(false);

    m_leftMotor.setInverted(false);
    m_leftMotor2.setInverted(false);
    //m_ShooterSubsystem.setDefaultCommand(empty);
    //b.toggleWhenPressed(new SpinShooter(m_ShooterSubsystem)); 
    phCompressor.enableDigital();
    
    // phCompressor.disable();


    
    CameraServer.startAutomaticCapture();

    configureButtons();
  }

  // Configures buttons using parallel command
  private void configureButtons() {
    // B Button Shooter
    System.out.println("About to configure buttons");
    m_xButton.whenPressed(new PneumaticsCommand(m_PneumaticsSubsystem));
    m_aButton.whenHeld(new ClimberStep1Command(m_ClimberStep1));
    m_bButton.whenHeld(new ClimberStep2Command(m_ClimberStep1));
    System.out.println("Configuring buttons");

  }
  // Runs a scheduler
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }
  
  @Override
  public void teleopPeriodic() {
    // Drive with tank drive.
    // That means that the Y axis of the left stick moves the left side
    // of the robot forward and backward, and the Y axis of the right stick
    // moves the right side of the robot forward and backward.
    m_robotDrive.tankDrive(m_driverController.getLeftY()*0.8, m_driverController.getRightY()*0.8);
    //System.out.println("Value of B button: " + m_driverController.getBButton());
  }

  @Override
  public void autonomousInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ExtendClimbCommand;
import frc.robot.commands.RetractClimbCommand;
import frc.robot.subsystems.ClimberSubSystem;
import frc.robot.subsystems.DriveTrainSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  public final ClimberSubSystem m_Climber = new ClimberSubSystem();
  // public final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Controllers
  public static XboxController xboxController = new XboxController(0);
  public final JoystickButton m_aButton = new JoystickButton(xboxController, Button.kA.value);

  public final JoystickButton m_bButton = new JoystickButton(xboxController, Button.kB.value);

  public final JoystickButton m_xButton = new JoystickButton(xboxController, Button.kX.value);
  public final JoystickButton m_triggerLeft = new JoystickButton(xboxController, 2);
  public final JoystickButton m_triggerRight = new JoystickButton(xboxController, 3);

  // Components
  public final Compressor phCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  public final static DriveTrainSubsystem m_driveTrainSub = new DriveTrainSubsystem();

  public final static ClimberSubSystem m_climbersubsystem = new ClimberSubSystem();

  // Commands
  // public final DriveWithController drive = new
  // DriveWithController(m_driveTrainSub);
  public final AutonomousCommand m_autonomousCommand = new AutonomousCommand(this);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */

  public RobotContainer() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.

    // m_ShooterSubsystem.setDefaultCommand(empty);
    // b.toggleWhenPressed(new SpinShooter(m_ShooterSubsystem));
    phCompressor.enableDigital();

    // phCompressor.disable();
    // Configure the button bindings & default commands

    // m_driveTrainSub.setDefaultCommand(drive);
    // m_conveySub.setDefaultCommand(conRun);
    CameraServer.startAutomaticCapture();
    configureButtonBindings();
    m_driveTrainSub.setDefaultCommand(new Drive(m_driveTrainSub));

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    System.out.println("About to configure buttons");
    m_aButton.whenHeld(new ExtendClimbCommand(1, m_Climber));
    m_bButton.whenHeld(new RetractClimbCommand(m_Climber));
    System.out.println("Configuring buttons");

  }

  // Left Bumper - Climb
  // new JoystickButton(xboxController, Button.kBumperLeft.value)
  // .whenPressed(new Climb(m_ClimbSub));

  public static XboxController getXboxController() {
    return xboxController;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  // // An ExampleCommand will run in autonomous
  // return m_autoCommand;
  // }
}

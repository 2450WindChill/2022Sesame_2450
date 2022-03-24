
package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.AngleCommands.AngleDownFullyCommand;
import frc.robot.AngleCommands.AngleUpFullyCommand;
import frc.robot.VerticalCommands.ExtendArmsFullyCommand;
import frc.robot.VerticalCommands.RetractArmsFullyCommand;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.FineTuneArmsCommand;
import frc.robot.subsystems.ClimberSubsystem;
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
  public final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
  public final static DriveTrainSubsystem m_driveTrainSub = new DriveTrainSubsystem();

  // Controllers
  public static XboxController driveController = new XboxController(0);
  public static XboxController climbController = new XboxController(1);

  public final JoystickButton m_aButton = new JoystickButton(climbController, Button.kA.value);
  public final JoystickButton m_bButton = new JoystickButton(climbController, Button.kB.value);
  public final JoystickButton m_yButton = new JoystickButton(climbController, Button.kY.value);
  public final JoystickButton m_xButton = new JoystickButton(climbController, Button.kX.value);

  public final JoystickButton m_triggerLeft = new JoystickButton(driveController, 2);
  public final JoystickButton m_triggerRight = new JoystickButton(driveController, 3);

  // Commands
  public final AutonomousCommand m_autonomousCommand = new AutonomousCommand(this);

  public RobotContainer() {

    CameraServer.startAutomaticCapture();
    CameraServer.startAutomaticCapture();

    configureButtonBindings();
    m_driveTrainSub.setDefaultCommand(new Drive(m_driveTrainSub));
    m_climberSubsystem.setDefaultCommand(new FineTuneArmsCommand(m_climberSubsystem));

  }

  private void configureButtonBindings() {
    System.out.println("About to configure buttons");
    //
    m_aButton.whenPressed(new AngleDownFullyCommand(m_climberSubsystem));
    m_bButton.whenPressed(new AngleUpFullyCommand(m_climberSubsystem));
    m_yButton.whenPressed(new ExtendArmsFullyCommand(m_climberSubsystem));
    m_xButton.whenPressed(new RetractArmsFullyCommand(m_climberSubsystem));
    System.out.println("Configuring buttons");

  }

  public static XboxController getClimbController() {
    return climbController;
  }

  public static XboxController getDriveController() {
    return driveController;
  }

}

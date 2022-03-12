
package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.AngleDownCommand;
import frc.robot.commands.AngleUpCommand;
import frc.robot.commands.AutoClimb;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.SetExtendArmsCommand;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ManualClimbCommand;
import frc.robot.commands.SetRetractArmsCommand;
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
  public static XboxController xboxController = new XboxController(0);
  public final JoystickButton m_leftBumper = new JoystickButton(xboxController, Button.kLeftBumper.value);
  public final JoystickButton m_rightBumper = new JoystickButton(xboxController, Button.kRightBumper.value);
  public final JoystickButton m_bButton = new JoystickButton(xboxController, Button.kB.value);
  public final JoystickButton m_yButton = new JoystickButton(xboxController, Button.kY.value);
  public final JoystickButton m_xButton = new JoystickButton(xboxController, Button.kX.value);

  public final JoystickButton m_triggerLeft = new JoystickButton(xboxController, 2);
  public final JoystickButton m_triggerRight = new JoystickButton(xboxController, 3);

  // Components
  // public final Compressor phCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  // Commands
  public final AutonomousCommand m_autonomousCommand = new AutonomousCommand(this);

  public RobotContainer() {

    // phCompressor.enableDigital();

    CameraServer.startAutomaticCapture();
    configureButtonBindings();
    m_driveTrainSub.setDefaultCommand(new Drive(m_driveTrainSub));
    m_climberSubsystem.setDefaultCommand(new ManualClimbCommand(m_climberSubsystem));

  }

  private void configureButtonBindings() {
    System.out.println("About to configure buttons");
    //
    m_leftBumper.whenHeld(new AngleDownCommand(m_climberSubsystem));
    m_rightBumper.whenHeld(new AngleUpCommand(m_climberSubsystem));
    m_bButton.whenPressed(new AutoClimb(m_climberSubsystem));
    m_yButton.whenPressed(new SetExtendArmsCommand(m_climberSubsystem));
    m_xButton.whenPressed(new SetRetractArmsCommand(m_climberSubsystem));
    System.out.println("Configuring buttons");

  }

  public static XboxController getXboxController() {
    return xboxController;
  }

}

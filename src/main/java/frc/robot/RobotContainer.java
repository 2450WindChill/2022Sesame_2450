
package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ExtendClimbCommand;
import frc.robot.commands.RetractClimbCommand;
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
  public final JoystickButton m_aButton = new JoystickButton(xboxController, Button.kA.value);
  public final JoystickButton m_bButton = new JoystickButton(xboxController, Button.kB.value);
  public final JoystickButton m_yButton = new JoystickButton(xboxController, Button.kY.value);
  public final JoystickButton m_xButton = new JoystickButton(xboxController, Button.kX.value);

  public final JoystickButton m_triggerLeft = new JoystickButton(xboxController, 2);
  public final JoystickButton m_triggerRight = new JoystickButton(xboxController, 3);

  // Components
  public final Compressor phCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  // Commands
  public final AutonomousCommand m_autonomousCommand = new AutonomousCommand(this);

  public RobotContainer() {

    phCompressor.enableDigital();

    CameraServer.startAutomaticCapture();
    configureButtonBindings();
    m_driveTrainSub.setDefaultCommand(new Drive(m_driveTrainSub));

  }

  private void configureButtonBindings() {
    System.out.println("About to configure buttons");
    // m_aButton.whenHeld(new AngleClimbCommandUp(m_climbersubsystem));
    // m_bButton.whenHeld(new AngleCommandDown(m_climbersubsystem));
    m_yButton.whenHeld(new ExtendClimbCommand(m_climberSubsystem));
    m_xButton.whenHeld(new RetractClimbCommand(m_climberSubsystem));

    System.out.println("Configuring buttons");

  }

  public static XboxController getXboxController() {
    return xboxController;
  }

}

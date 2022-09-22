package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Delay;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class AutoFullShoot extends CommandBase {
    private final ShooterSubsystem m_shoot;
    private final ConveyorSubsystem m_conveyor;

    private Delay d;
    private long time = Constants.autoFullShootTime;

    public AutoFullShoot(ShooterSubsystem subsystem, ConveyorSubsystem m_subsystem){
        m_shoot = subsystem;
        m_conveyor = m_subsystem;

        addRequirements(subsystem);
        addRequirements(m_subsystem);
    }
    @Override
    public void initialize() {
        d = new Delay(time);
    }

    @Override
    public void execute() {
        m_shoot.topLaunchMotor.set(Constants.topShootSpeed);
        m_shoot.bottomLaunchMotor.set(Constants.bottomShootSpeed);
        m_conveyor.conveyorMotor.set(Constants.conveyorSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        m_shoot.topLaunchMotor.set(0);
        m_shoot.bottomLaunchMotor.set(0);
        m_conveyor.conveyorMotor.set(0);
    }

    @Override
    public boolean isFinished() {
        return d.isExpired();
    }

}

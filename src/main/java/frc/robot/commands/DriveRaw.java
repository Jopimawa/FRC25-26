import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveRaw extends Command {
    private final DriveSubsystem m_driveSubsystem;
    private final Joystick m_joystick;

    public DriveRaw(DriveSubsystem driveSubsystem, double x, double y) {
        m_driveSubsystem = driveSubsystem;
        m_joystick = joystick;
        
        addRequirements(m_driveSubsystem);
    }

    @Override
    public void execute() {
        m_driveSubsystem.arcadeDrive(y, x));
    }

    @Override
    public void end(boolean interrupted) {
        m_driveSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
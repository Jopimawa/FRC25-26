import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    private final PWMVictorSPX m_leftMotor1 = new PWMVictorSPX(Constants.kDriveLeftMotor1);
    private final PWMVictorSPX m_leftMotor2 = new PWMVictorSPX(Constants.kDriveLeftMotor2);

    private final PWMVictorSPX m_rightMotor1 = new PWMVictorSPX(Constants.kDriveRightMotor1);
    private final PWMVictorSPX m_rightMotor2 = new PWMVictorSPX(Constants.kDriveRightMotor2);

    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor1, m_rightMotor1);

    public DriveSubsystem() {
        m_leftMotor1.setInverted(false); 
        m_rightMotor1.setInverted(false); 
        m_leftMotor2.setInverted(false); 
        m_rightMotor2.setInverted(false); 

        m_leftMotor1.addFollower(m_leftMotor2);
        m_rightMotor1.addFollower(m_rightMotor2);

        m_drive.setSafetyEnabled(true);
        m_drive.setDeadband(0.02);
    }

    
    public void tankDrive(double leftSpeed, double rightSpeed) {
        m_drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void stop() {
        m_drive.stopMotor();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Drive/Left Motor", m_leftMotor1.get());
        SmartDashboard.putNumber("Drive/Right Motor", m_rightMotor1.get());
        SmartDashboard.putNumber("Drive/Left Motor Follower", m_leftMotor2.get());
        SmartDashboard.putNumber("Drive/Right Motor Follower", m_rightMotor2.get());
    }
}
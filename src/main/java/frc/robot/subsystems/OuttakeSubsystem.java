
public class OuttakeSubsystem extends SubsystemBase {
    private final PWMVictorSPX m_outtakeMotor;
    boolean pos = false;
    private double v_speed = 1;
    private double v_time = 0.8;

    public OuttakeSubsystem() {
        m_outtakeMotor = new PWMVictorSPX(Constants.kOuttakeMotor);

        m_outtakeMotor.setInverted(false);
    }

    public void setSpeed() {
        int speed = (pos) ? v_speed : -v_speed;
        m_outtakeMotor.set(speed);
        pos = !pos
    }

    public void stop() {
        m_outtakeMotor.stopMotor();
    } 
    public getTime() {
        return v_time
    }

    @Override
    public void periodic() {
        v_speed = SmartDashboard.getNumber("Outtake/Speed", 0.8);
        v_time = SmartDashboard.getNumber("Outtake/Time", 1);
        
        SmartDashboard.putNumber("Outtake/Speed", v_speed);
        SmartDashboard.putNumber("Outtake/Time", v_time);
    }

}
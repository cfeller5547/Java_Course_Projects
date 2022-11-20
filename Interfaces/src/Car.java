
public class Car implements MotorVehicle{

	
	//reason for @override: wont compile if interface DOESN'T have this method,
	//so protects programmer from mispelling, etc. -----why wont it compile without it??
	
	@Override
	public boolean start() {
		return true;
	}
	
	@Override
	public boolean stop() {
		return false;
	}
	
	public boolean is4Door() {
		return true;
	}

}

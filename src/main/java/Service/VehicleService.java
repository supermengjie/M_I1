package Service;

import vo.Vehicle;

import java.util.List;

public interface VehicleService {

    public String update(Vehicle vechile);

    String save(Vehicle vehicle);

    List<Vehicle> findVehicles();

    Vehicle findVehiclesById(int id);

    void deleteStudentById(int id);
}

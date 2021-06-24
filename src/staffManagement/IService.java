package staffManagement;

import ui.Call;

public interface IService {

    public Call add(Employee employee);

    public Call delete(Employee employee);

    public Call query(Employee employee);

    public Call detail(Employee employee);

}

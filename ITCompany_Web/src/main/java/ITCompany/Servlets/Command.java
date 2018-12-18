package ITCompany.Servlets;

import java.sql.SQLException;

public interface Command {

    void execute() throws ClassNotFoundException, SQLException;

}

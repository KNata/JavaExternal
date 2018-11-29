package ITCompany.MenuChooser;

import java.sql.SQLException;

public class RemoteControl {

    private Command command;

    public RemoteControl() {

    }

    public void setCommand(Command aCommand) {
        command = aCommand;
    }

    public void chooseCommand() throws SQLException, ClassNotFoundException {
        command.execute();
    }
}

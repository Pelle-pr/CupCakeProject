package PresentationLayer;

import FunctionLayer.CupCake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put("basket", new NewCupCake());
        commands.put("redirect", new Redirect());
        commands.put("newOrder", new NewOrder());
        commands.put("myorders", new MyOrder());
        commands.put("deleteOrderLine", new DeleteOrderLine());
        commands.put("userpage",new Userpage());
        commands.put("orderpage", new Orderpage());
        commands.put("insertmoney", new InsertMoney());
        commands.put("updateorder", new UpdateOrder());
        commands.put("logout", new Logout());
    }

    static Command from(HttpServletRequest request ) {
        String TargetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(TargetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException, SQLException, ServletException, IOException;

}

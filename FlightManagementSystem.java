import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class FlightManagementSystem {
    public boolean addFlight(Flight flight) {
      
      try{
          
          Connection conn = DB.getConnection();
          String query = "insert into flight(flightId,source,destination,noofseats,flightfare) values (?,?,?,?,?)";
          PreparedStatement p = conn.prepareStatement(query);
          p.setInt(1,flight.getFlightId());
          p.setString(2,flight.getSource());
          p.setString(3,flight.getDestination());
          p.setInt(4,flight.getNoOfSeats());
          p.setDouble(5,flight.getFlightFare());
          
          p.execute();
              System.out.println("Inserted Successfully");
              
        query = "select flightId,noofseats,flightfare from flight where source ='NYC' and destination='LA'";
        p = conn.prepareStatement(query);
        ResultSet rs = p.executeQuery();
              while(rs.next())
              {
                  System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getDouble(3));
              }
              
              
              return true;
          
          
          
          
      }
      catch(ClassNotFoundException | SQLException e)
      {
          System.out.println(e);
      }
      
      return false;
    }
}

//import com.flipkart.bean.Booking;
//import com.flipkart.exceptions.SQLExceptionHandler;
//import com.flipkart.utils.DBConnection;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class BookingDAO {
////    ScheduleDAO scheduleDAO  = new ScheduleDAO();
//    private final SQLExceptionHandler sqlExceptionHandler = new SQLExceptionHandler();
//
//    public void  addBooking(String userName, String scheduleID) {
//        //System.out.println(userName + scheduleID);
//        Connection conn = DBConnection.connect();
//        PreparedStatement stmt = conn.prepareStatement(ADD_BOOKING);
//        stmt.setString(1, userName+scheduleID);
//        stmt.setString(2, userName);
//        stmt.setString(3, scheduleID);
//        stmt.executeUpdate();
//        stmt.close();
//    }
//}

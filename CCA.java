package cca;

import cmp.DataSource;
import java.sql.*;
import java.util.Scanner;

public class CCA {

    public static void main(String argv[]) {
        
        displayLeadCustomer();
        displayFlight();
        displayFlightBooking();
        one();
        two();
        three();
        four();
        five();
        six();
        seven();
        eight();
        nine();
        ten();
        eleven();

    }
   
    // Display the full content of the LeadCustomer table
    public static void displayLeadCustomer() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            // create a string containing some SQL 
            String SQLStatement = "SELECT * FROM leadcustomer";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute SQL statement
            rs = stmt.executeQuery(SQLStatement);

            // loop to step through each row of result set
            while (rs.next()) {
                int theCustomerID = rs.getInt("customerid");
                String theFirstname = rs.getString("firstname");
                String theSurname = rs.getString("surname");
                String theAddress = rs.getString("billingaddress");
                String theEmail = rs.getString("email");
                System.out.println("CustomerID: " + theCustomerID + " Customer Name: " + theFirstname + " " + theSurname + " Billing Address: " + theAddress + " Contact Email: " + theEmail);
            }

        } catch (SQLException e) {
            // print details of SQL error
            // could be multiple errors chained together
            System.err.println("Error(s) occurred");
            while (e != null) {
                System.err.println("SQLException : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("SQLCode : " + e.getErrorCode());
                e = e.getNextException();
                System.err.println();
            }
        } catch (Exception e) {

            // print the error message and the stack trace
            e.printStackTrace(System.err);
        } finally {

            // disconnect and tidy up
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
        }
    }

    // Display the full content of the Flight table
    public static void displayFlight(){
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            // create a string containing some SQL 
            String SQLStatement = "SELECT * FROM flight";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute SQL statement
            rs = stmt.executeQuery(SQLStatement);

            // loop to step through each row of result set
            while (rs.next()) {
                int theFlightID = rs.getInt("flightid");
                String theDate = rs.getString("flightdate");
                String theOrigin = rs.getString("origin");
                String theDestination = rs.getString("destination");
                int theCapacity = rs.getInt("maxcapacity");
                int thePrice = rs.getInt("priceperseat");
                System.out.println("FlightID: " + theFlightID + " Flight Date: " + theDate + " Origin: " + theOrigin + " Destination: " + theDestination + " Flight Maximum Seat Capacity: " + theCapacity + " Price Per Seat: " + thePrice);
            }

        } catch (SQLException e) {
            // print details of SQL error
            // could be multiple errors chained together
            System.err.println("Error(s) occurred");
            while (e != null) {
                System.err.println("SQLException : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("SQLCode : " + e.getErrorCode());
                e = e.getNextException();
                System.err.println();
            }
        } catch (Exception e) {

            // print the error message and the stack trace
            e.printStackTrace(System.err);
        } finally {

            // disconnect and tidy up
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
        }
    }
   
    // Display the full content of the FlightBooking table
    public static void displayFlightBooking(){
       
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            // create a string containing some SQL 
            String SQLStatement = "SELECT * FROM flightbooking";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute SQL statement
            rs = stmt.executeQuery(SQLStatement);

            // loop to step through each row of result set
            while (rs.next()) {
                int theBookingID = rs.getInt("bookingid");
                int theCustomerID = rs.getInt("customerid");
                int theFlightID = rs.getInt("flightid");
                int theNumber = rs.getInt("numseats");
                String theStatus = rs.getString("status");
                String theBookingTime = rs.getString("bookingtime");
                int theTotal = rs.getInt("totalcost");
                System.out.println("BookingID: " + theBookingID + " CustomerID: " + theCustomerID + " FlightID: " + theFlightID + " Number of Seats: " + theNumber + " Seat Status: " + theStatus + " Booking Time: " + theBookingTime + " Total Cost: " + theTotal);
            }

        } catch (SQLException e) {
            // print details of SQL error
            // could be multiple errors chained together
            System.err.println("Error(s) occurred");
            while (e != null) {
                System.err.println("SQLException : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("SQLCode : " + e.getErrorCode());
                e = e.getNextException();
                System.err.println();
            }
        } catch (Exception e) {

            // print the error message and the stack trace
            e.printStackTrace(System.err);
        } finally {

            // disconnect and tidy up
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
        }
    }
 
    // Given a customer ID number, name, address and email
    // create a new customer record
    public static void one() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            //Input information
            Scanner scan = new Scanner(System.in);
            System.out.println("ENTER CUSTOMER ID");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("ENTER CUSTOMER FIRST NAME");
            String fname = scan.nextLine();
            System.out.println("ENTER CUSTOMER SURNAME");
            String sname = scan.nextLine();
            System.out.println("ENTER CUSTOMER ADDRESS");
            String address = scan.nextLine();
            System.out.println("ENTER CUSTOMER EMAIL");
            String email = scan.nextLine();

            // create a string containing some SQL 
            String SQLStatement = "INSERT INTO LeadCustomer (CustomerID, FirstName, Surname, BillingAddress, Email) VALUES (" + id + ",'" + fname + "','" + sname + "','" + address + "','" + email + "')";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute the insert
            int rowcount = stmt.executeUpdate(SQLStatement);

            // should insert one row
            if (rowcount == 1) {
                System.out.println("insert done OK");
            } else {
                System.out.println("insert failed!");
            }

        } catch (SQLException e) {
            // print details of SQL error
            // could be multiple errors chained together
            System.err.println("Error(s) occurred");
            while (e != null) {
                System.err.println("SQLException : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("SQLCode : " + e.getErrorCode());
                e = e.getNextException();
                System.err.println();
            }
        } catch (Exception e) {

            // print the error message and the stack trace
            e.printStackTrace(System.err);
        } finally {

            // disconnect and tidy up
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
        }
    } // complete

    // Given a flight ID number, origin, destination, flight
    // date and capacity of the aircraft, create a new flight
    // record
    public static void two() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            //Input information
            Scanner scan = new Scanner(System.in);
            System.out.println("ENTER FLIGHT ID");
            int fid = scan.nextInt();
            scan.nextLine();
            System.out.println("ENTER FLIGHT ORIGIN");
            String origin = scan.nextLine();
            System.out.println("ENTER FLIGHT DESTINATION");
            String destination = scan.nextLine();
            System.out.println("ENTER FLIGHT MAXIMUM CAPACITY");
            int capacity = scan.nextInt();
            scan.nextLine();
            System.out.println("ENTER FLIGHT DATE IN THE FORMAT (yyyy-mm-dd hh:mm:ss)");
            String strdate = scan.nextLine();
            //Timestamp t = Timestamp.valueOf(strdate);
            System.out.println("ENTER THE PRICE OF EACH SEAT FOR THIS FLIGHT");
            int price = scan.nextInt();

            // create a string containing some SQL 
            String SQLStatement = "INSERT INTO Flight (FlightID, FlightDate, Origin, Destination, MaxCapacity, PricePerSeat) VALUES (" + fid + ", '" + strdate + "','" + origin + "','" + destination + "'," + capacity + "," + price + ")";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute the insert
            int rowcount = stmt.executeUpdate(SQLStatement);

            // should insert one row
            if (rowcount == 1) {
                System.out.println("insert done OK");
            } else {
                System.out.println("insert failed!");
            }

        } catch (SQLException e) {
            // print details of SQL error
            // could be multiple errors chained together
            System.err.println("Error(s) occurred");
            while (e != null) {
                System.err.println("SQLException : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("SQLCode : " + e.getErrorCode());
                e = e.getNextException();
                System.err.println();
            }
        } catch (Exception e) {

            // print the error message and the stack trace
            e.printStackTrace(System.err);
        } finally {

            // disconnect and tidy up
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
        }
    } // complete

    // Given a customer ID, remove the record for that customer
    public static void three() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            //Input information
            Scanner scan = new Scanner(System.in);
            System.out.println("ENTER CUSTOMER ID");
            int id = scan.nextInt();

            // create a string containing some SQL 
            String SQLStatement = "DELETE FROM  LeadCustomer WHERE CustomerId = '" + id + "'";
            System.out.println("SQL Statement is: " + SQLStatement);
            

            // execute the update
            int rowcount = stmt.executeUpdate(SQLStatement);

            // could update 0, 1 or many rows
            System.out.println(rowcount + " updates done");

        } catch (SQLException e) {
            // print details of SQL error
            // could be multiple errors chained together
            System.err.println("Error(s) occurred");
            while (e != null) {
                System.err.println("SQLException : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("SQLCode : " + e.getErrorCode());
                e = e.getNextException();
                System.err.println();
            }
        } catch (Exception e) {

            // print the error message and the stack trace
            e.printStackTrace(System.err);
        } finally {

            // disconnect and tidy up
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
        }
    } // complete

    // Given a flight ID, remove the record for that flight
    public static void four() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            //Input information
            Scanner scan = new Scanner(System.in);
            System.out.println("ENTER FLIGHT ID");
            int fid = scan.nextInt();

            // create a string containing some SQL 
            String SQLStatement = "DELETE FROM  Flight WHERE FlightId = '" + fid + "'";
            System.out.println("SQL Statement is: " + SQLStatement);
            ;

            // execute the update
            int rowcount = stmt.executeUpdate(SQLStatement);

            // could update 0, 1 or many rows
            System.out.println(rowcount + " updates done");

        } catch (SQLException e) {
            // print details of SQL error
            // could be multiple errors chained together
            System.err.println("Error(s) occurred");
            while (e != null) {
                System.err.println("SQLException : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("SQLCode : " + e.getErrorCode());
                e = e.getNextException();
                System.err.println();
            }
        } catch (Exception e) {

            // print the error message and the stack trace
            e.printStackTrace(System.err);
        } finally {

            // disconnect and tidy up
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
        }
    } // complete

    // Check the availability of seats on all flights by showin the flight
    // ID number, flight date along with the number of available seats
    public static void five() {

    } // not started 

    // Given a flight ID number, check the status of all seats currently
    // allocated to that flight
    public static void six() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            //Input information
            Scanner scan = new Scanner(System.in);
            System.out.println("ENTER FLIGHT ID");
            int fid = scan.nextInt();

            // create a string containing some SQL 
            String SQLStatement = "SELECT status FROM FlightBooking WHERE flightid='" + fid + "'";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute SQL statement
            rs = stmt.executeQuery(SQLStatement);

            // loop to step through each row of result set
            while (rs.next()) {
                String theStatus = rs.getString("status");
                int theFlightID = rs.getInt("flightid");
                System.out.println(theStatus + " : " + theFlightID);
            }

        } catch (SQLException e) {
            // print details of SQL error
            // could be multiple errors chained together
            System.err.println("Error(s) occurred");
            while (e != null) {
                System.err.println("SQLException : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("SQLCode : " + e.getErrorCode());
                e = e.getNextException();
                System.err.println();
            }
        } catch (Exception e) {

            // print the error message and the stack trace
            e.printStackTrace(System.err);
        } finally {

            // disconnect and tidy up
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
        }
    } // complete

    // Given a booking ID, customer ID number, flight ID number and the number
    // of seats required, make a simple booking - this could be a confirmed
    // booking or holding the seats for a 24 hour period
    public static void seven() {

    } // not started

    // Given a booking ID number, cancel the booking. Note that cancelling
    // a booking only changes the status and should not delete the historical
    // details of the original booking
    public static void eight() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            //Input information
            Scanner scan = new Scanner(System.in);
            System.out.println("ENTER BOOKING ID");
            int bid = scan.nextInt();

            // create a string containing some SQL 
            String SQLStatement = "UPDATE FlightBooking SET status='C' WHERE bookingid= '" + bid + "'";
            System.out.println("SQL Statement is: " + SQLStatement);
            ;

            // execute the update
            int rowcount = stmt.executeUpdate(SQLStatement);

            // could update 0, 1 or many rows
            System.out.println(rowcount + " updates done");

        } catch (SQLException e) {
            // print details of SQL error
            // could be multiple errors chained together
            System.err.println("Error(s) occurred");
            while (e != null) {
                System.err.println("SQLException : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("SQLCode : " + e.getErrorCode());
                e = e.getNextException();
                System.err.println();
            }
        } catch (Exception e) {

            // print the error message and the stack trace
            e.printStackTrace(System.err);
        } finally {

            // disconnect and tidy up
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
        }
    } // complete

    // A flight is going to be rescheduled. Generate a list of cusotmers 
    // who will need to be contacted to be informed of the rescheduling.
    public static void nine() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            //Input information
            Scanner scan = new Scanner(System.in);
            System.out.println("ENTER FLIGHT ID");
            int fid = scan.nextInt();

            // create a string containing some SQL 
            String SQLStatement = "SELECT DISTINCT leadcustomer.customerid, leadcustomer.firstname, leadcustomer.surname, leadcustomer.email FROM  leadcustomer INNER JOIN flightbooking ON Leadcustomer.customerid=flightbooking.customerid WHERE flightid='" + fid + "' AND Status='R'";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute SQL statement
            rs = stmt.executeQuery(SQLStatement);

            // loop to step through each row of result set
            while (rs.next()) {
                int theCustomerID = rs.getInt("customerid");
                String theFirstname = rs.getString("firstname");
                String theSurname = rs.getString("surname");
                String theEmail = rs.getString("email");
                System.out.println("CustomerID: " + theCustomerID + " Customer Name: " + theFirstname + " " + theSurname + " Contact Email: " + theEmail);
            }

        } catch (SQLException e) {
            // print details of SQL error
            // could be multiple errors chained together
            System.err.println("Error(s) occurred");
            while (e != null) {
                System.err.println("SQLException : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("SQLCode : " + e.getErrorCode());
                e = e.getNextException();
                System.err.println();
            }
        } catch (Exception e) {

            // print the error message and the stack trace
            e.printStackTrace(System.err);
        } finally {

            // disconnect and tidy up
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {

                // print the error message and the stack trace
                e.printStackTrace(System.err);
            }
        }
    } // complete
    
    // Release seats of any booking which has held the status of 'Held
    // for more than 24 hours.
    public static void ten() {

    } // not started

    public static void eleven() {

    } // not started

}

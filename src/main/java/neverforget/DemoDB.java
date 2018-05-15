
package neverforget;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 */

public class DemoDB {

    // 2. define connection params to db
    final static String URL = "jdbc:postgresql://54.93.65.5:5432/mihai7";
    final static String USERNAME = "fasttrackit_dev";
    final static String PASSWORD = "fasttrackit_dev";


    public static void main(String[] args) {

        // nothing here
    }

    public static void demoCreate(String obiect, String locatie) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");



        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO neverforget (obiect, locatie) VALUES (?,?)");
        pSt.setString(1, obiect);
        pSt.setString(2, locatie);

        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public static List<Neverforget> demoRead() throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");


        String startsWith = "ion";


        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        String query = "SELECT * FROM neverforget order by obiect asc";
        System.out.println(query);
        // 5. execute a query
        ResultSet rs = st.executeQuery(query);

        // 6. iterate the result set and print the values

        List ListaDeObiecte = new ArrayList<Neverforget>();
        while (rs.next()) {
            String obiect = rs.getString("obiect").trim();
            String locatie = rs.getString("locatie").trim();
            Neverforget p = new Neverforget();
            p.obiect = obiect;
            p.locatie = locatie;
            ListaDeObiecte.add(p);
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();
        return ListaDeObiecte;

    }

    public static List<Neverforget> demoRead(String order, String search) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");


        String startsWith = "ion";


        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        String query="";
        if(search == null) {
            search = "";
        }
        if (order != null && order.equals("desc")) {
            query = "SELECT * FROM neverforget WHERE obiect like '%" + search + "%' ORDER BY obiect desc";
        } else {
            query = "SELECT * FROM neverforget WHERE obiect like '%" + search + "%' ORDER BY obiect asc";
        }

        System.out.println(query);
        // 5. execute a query
        ResultSet rs = st.executeQuery(query);

        // 6. iterate the result set and print the values

        List ListaDeObiecte = new ArrayList<Neverforget>();
        while (rs.next()) {
            String obiect = rs.getString("obiect").trim();
            String locatie = rs.getString("locatie").trim();
            long id=rs.getLong("id");
            Neverforget p = new Neverforget();
            p.obiect = obiect;
            p.locatie = locatie;
            p.id = id;
            ListaDeObiecte.add(p);
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();
        return ListaDeObiecte;

    }
    private static void demoUpdate() throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");



        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("UPDATE neverforget SET nume=?, telefon=? WHERE id=?"); //so we have 3 params
        pSt.setString(1, "gates");
        pSt.setString(2, "bill");
        pSt.setLong(3, 2);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }


    public static void demoDelete(long id) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");



        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM neverforget WHERE id=?");
        pSt.setLong(1,id);

        // 5. execute a prepared statement
        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");
        // 6. close the objects
        pSt.close();
        conn.close();
    }
}


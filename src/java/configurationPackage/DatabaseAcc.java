package configurationPackage;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class DatabaseAcc {

    // configuration field
    private String Patient_ID;
    private String Staff_ID;
    private String Device_ID;
    private String Week_NO;
    private String Threshold_DateTime;
    private String[] Threshold_ = new String[10];
    private String NoDayinWeek;
    private String NoSetinDay;
    private String NoTimeinSet;

    private Configurations getConfig = new Configurations();

    public DatabaseAcc() {
    }

    public String stringXML() {
        StringWriter xml = new StringWriter();
        try {

//		JAXBContext jaxbContext = JAXBContext.newInstance(Configurations.class);
            JAXBContext jaxbContext = JAXBContext.newInstance(getConfig.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(getConfig, xml);
            jaxbMarshaller.marshal(getConfig, System.out);

        } catch (JAXBException e) {
            System.err.println("JAXBEXception");
            e.printStackTrace();
        }
        return xml.toString();
    }

    public void setConfiguration(String pid, String did) {
        this.Patient_ID = pid;
        this.Device_ID = did;
//        String SELECT_QUERY = "SELECT * FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'";
        String week = "";
        Connector(week);
    }

    public void setConfiguration2(String pid, String did, String wno) {
        this.Patient_ID = pid;
        this.Device_ID = did;
        this.Week_NO = wno;
//        String SELECT_QUERY = "SELECT * FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+Week_NO+"";
        String week = wno;

//        Connector(SELECT_QUERY);
        Connector(week);
    }

    //-----------------------------database access------------------
//    public void Connector(String SELECT_QUERY){
    public void Connector(String week) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }
        System.err.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbtcdb","root", "");
            connection = DriverManager.getConnection("jdbc:mysql://nbtcrehab.eng.psu.ac.th:3306/nbtcdb","nbtcAdmin", "Admin2558");
//            connection = DriverManager.getConnection("jdbc:mysql://172.31.0.99:3306/nbtcdb", "nbtcAdmin", "Admin2558");
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.err.println("You made it, take control your database now!");
            try {
                Statement stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

                String SELECT_QUERY_device_thresholdCount = "SELECT Threshold_Counter FROM device WHERE Device_ID=\'" + Device_ID + "\'";
                ResultSet thcount = stmt.executeQuery(SELECT_QUERY_device_thresholdCount);
                thcount.last();
                int thc = thcount.getInt(thcount.getRow());
                thcount.close();

                String SELECT_QUERY_patientWeek_weekNO = "SELECT MAX(Week_NO) FROM patient_week WHERE Patient_ID=" + Patient_ID + " AND Device_ID=\'" + Device_ID + "\'";
                ResultSet wno = stmt.executeQuery(SELECT_QUERY_patientWeek_weekNO);
                wno.last();
                int week_NO = wno.getInt(wno.getRow());
                System.out.println("weekNO: " + week_NO);
                wno.beforeFirst();
                wno.close();
                int nDinW;
                int day_NO;

                int nSinD;
                int set_NO;
                int nTinS;
                int time_NO;

                if (week_NO != 0) {
                    String SELECT_QUERY_threshold_weekNO = "SELECT NoDayinWeek FROM threshold WHERE Threshold_ID IN (SELECT MAX(Threshold_ID) FROM threshold WHERE Patient_ID=" + Patient_ID + " AND Device_ID=\'" + Device_ID + "\'" + " AND Week_NO=" + week_NO + ")";
                    ResultSet rs2 = stmt.executeQuery(SELECT_QUERY_threshold_weekNO);
                    rs2.last();
                    nDinW = rs2.getInt(rs2.getRow());
                    System.out.println("nDinW: " + nDinW);
                    rs2.beforeFirst();
                    rs2.close();
                    String SELECT_QUERY_patientWeek_dayNO = "SELECT MAX(Day_NO) FROM patient_week WHERE Patient_ID=" + Patient_ID + " AND Device_ID=\'" + Device_ID + "\'" + " AND Week_NO=" + week_NO + "";
                    ResultSet dno = stmt.executeQuery(SELECT_QUERY_patientWeek_dayNO);
                    dno.last();
                    day_NO = dno.getInt(dno.getRow());
                    System.out.println("dayNO: " + day_NO);
                    dno.beforeFirst();
                    dno.close();

                    String SELECT_QUERY_threshold_weekNO_set = "SELECT NoSetinDay FROM threshold WHERE Threshold_ID IN (SELECT MAX(Threshold_ID) FROM threshold WHERE Patient_ID=" + Patient_ID + " AND Device_ID=\'" + Device_ID + "\'" + " AND Week_NO=" + week_NO + ")";
                    ResultSet rs2_set = stmt.executeQuery(SELECT_QUERY_threshold_weekNO_set);
                    rs2_set.last();
                    nSinD = rs2_set.getInt(rs2_set.getRow());
                    System.out.println("nSinD: " + nSinD);
                    rs2_set.beforeFirst();
                    rs2_set.close();
                    String SELECT_QUERY_patientWeek_setNO = "SELECT MAX(Set_NO) FROM patient_week WHERE Patient_ID=" + Patient_ID + " AND Device_ID=\'" + Device_ID + "\'" + " AND Week_NO=" + week_NO + " AND Day_NO=" + day_NO + "";
                    ResultSet sno = stmt.executeQuery(SELECT_QUERY_patientWeek_setNO);
                    sno.last();
                    set_NO = sno.getInt(sno.getRow());
                    System.out.println("setNO: " + set_NO);
                    sno.beforeFirst();
                    sno.close();

                    String SELECT_QUERY_threshold_weekNO_time = "SELECT NoTimeinSet FROM threshold WHERE Threshold_ID IN (SELECT MAX(Threshold_ID) FROM threshold WHERE Patient_ID=" + Patient_ID + " AND Device_ID=\'" + Device_ID + "\'" + " AND Week_NO=" + week_NO + ")";
                    ResultSet rs2_time = stmt.executeQuery(SELECT_QUERY_threshold_weekNO_time);
                    rs2_time.last();
                    nTinS = rs2_time.getInt(rs2_time.getRow());
                    System.out.println("nTinS: " + nTinS);
                    rs2_time.beforeFirst();
                    rs2_time.close();
                    String SELECT_QUERY_patientWeek_timeNO = "SELECT MAX(Time_NO) FROM patient_week WHERE Patient_ID=" + Patient_ID + " AND Device_ID=\'" + Device_ID + "\'" + " AND Week_NO=" + week_NO + " AND Day_NO=" + day_NO + " AND Set_NO=" + set_NO + "";
                    ResultSet tno = stmt.executeQuery(SELECT_QUERY_patientWeek_timeNO);
                    tno.last();
                    time_NO = tno.getInt(tno.getRow());
                    System.out.println("timeNO: " + time_NO);
                    tno.beforeFirst();
                    tno.close();

                } else {
                    day_NO = 1;
                    nDinW = 1;
                    set_NO = 1;
                    nSinD = 1;
                    nTinS = 1;
                    time_NO = 1;
                }

                String SELECT_QUERY;
                if (!week.equals("")) {
                    SELECT_QUERY = "SELECT * FROM threshold WHERE Threshold_ID IN (SELECT MAX(Threshold_ID) FROM threshold WHERE Patient_ID=" + Patient_ID + " AND Device_ID=\'" + Device_ID + "\'" + " AND Week_NO=" + week + ")";
//                SELECT_QUERY = "SELECT * FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+week+"";
                    day_NO = 1;
                    nDinW = 1;
                    set_NO = 1;
                    nSinD = 1;
                    nTinS = 1;
                    time_NO = 1;
                    System.out.println("given week");
                } else if ((day_NO >= nDinW && set_NO >= nSinD && time_NO >= nTinS) || week_NO == 0) {
                    SELECT_QUERY = "SELECT * FROM threshold WHERE Threshold_ID IN (SELECT MAX(Threshold_ID) FROM threshold WHERE Patient_ID=" + Patient_ID + " AND Device_ID=\'" + Device_ID + "\'" + " AND Week_NO=" + (week_NO + 1) + ")";
//                SELECT_QUERY = "SELECT * FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+(week_NO+1)+"";
                    System.out.println("next week");
                } else {
                    SELECT_QUERY = "SELECT * FROM threshold WHERE Threshold_ID IN (SELECT MAX(Threshold_ID) FROM threshold WHERE Patient_ID=" + Patient_ID + " AND Device_ID=\'" + Device_ID + "\'" + " AND Week_NO=" + week_NO + ")";
//                SELECT_QUERY = "SELECT * FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+(week_NO)+"";
                    System.out.println("current week");
                }

                ResultSet rs = stmt.executeQuery(SELECT_QUERY);

//            System.out.println(config);
                Configuration getconfig = new Configuration();
                if (!rs.isBeforeFirst()) {
                    System.out.println("No data");
                    getConfig.getConfiguration().add(getconfig);
                }
                while (rs.next()) {
                    getconfig = new Configuration();

                    getconfig.setThreshold_ID(rs.getInt("Threshold_ID"));
                    getconfig.setPatient_ID(rs.getInt("Patient_ID") + "");
                    getconfig.setStaff_ID(rs.getInt("Staff_ID") + "");
                    getconfig.setDevice_ID(rs.getString("Device_ID"));
                    getconfig.setWeek_NO(rs.getInt("Week_NO"));
                    getconfig.setThreshold_DateTime(rs.getString("Threshold_DateTime"));
                    if (1 <= thc) {
                        getconfig.setThreshold_1(rs.getInt("Threshold_1") + "");
                    } else {
                        getconfig.setThreshold_1("null");
                    }
                    if (2 <= thc) {
                        getconfig.setThreshold_2(rs.getInt("Threshold_2") + "");
                    } else {
                        getconfig.setThreshold_2("null");
                    }
                    if (3 <= thc) {
                        getconfig.setThreshold_3(rs.getInt("Threshold_3") + "");
                    } else {
                        getconfig.setThreshold_3("null");
                    }
                    if (4 <= thc) {
                        getconfig.setThreshold_4(rs.getInt("Threshold_4") + "");
                    } else {
                        getconfig.setThreshold_4("null");
                    }
                    if (5 <= thc) {
                        getconfig.setThreshold_5(rs.getInt("Threshold_5") + "");
                    } else {
                        getconfig.setThreshold_5("null");
                    }
                    if (6 <= thc) {
                        getconfig.setThreshold_6(rs.getInt("Threshold_6") + "");
                    } else {
                        getconfig.setThreshold_6("null");
                    }
                    if (7 <= thc) {
                        getconfig.setThreshold_7(rs.getInt("Threshold_7") + "");
                    } else {
                        getconfig.setThreshold_7("null");
                    }
                    if (8 <= thc) {
                        getconfig.setThreshold_8(rs.getInt("Threshold_8") + "");
                    } else {
                        getconfig.setThreshold_8("null");
                    }
                    if (9 <= thc) {
                        getconfig.setThreshold_9(rs.getInt("Threshold_9") + "");
                    } else {
                        getconfig.setThreshold_9("null");
                    }
                    if (10 <= thc) {
                        getconfig.setThreshold_10(rs.getInt("Threshold_10") + "");
                    } else {
                        getconfig.setThreshold_10("null");
                    }
                    getconfig.setNoDayinWeek(rs.getInt("NoDayinWeek"));
                    getconfig.setNoSetinDay(rs.getInt("NoSetinDay"));
                    getconfig.setNoTimeinSet(rs.getInt("NoTimeinSet"));

                    getConfig.getConfiguration().add(getconfig);

                }
                rs.close();
                
//            System.out.println(getConfig.getConfiguration().size());

                if (!stmt.isClosed()){
                    stmt.close();
                }
                if (!connection.isClosed()) {
                    System.out.println("Close connection");
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("SQLException");
            }
        } else {
            System.out.println("Failed to make connection!");
        }
    }

}

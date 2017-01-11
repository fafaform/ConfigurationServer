package getcurrentPackage;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class GetCurrentAcc {

    private String Patient_ID;
    private String Device_ID;

    
    private Current getcurrent = new Current();
        
    public GetCurrentAcc(){}
    
    public String stringXML(){
        StringWriter xml = new StringWriter();
        try {
                
//                JAXBContext jaxbContext = JAXBContext.newInstance(getConfig.getClass());
                JAXBContext jaxbContext = JAXBContext.newInstance(Current.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


                jaxbMarshaller.marshal(getcurrent, xml);
		jaxbMarshaller.marshal(getcurrent, System.out);

	      } catch (JAXBException e) {
                  System.err.println("JAXBEXception");
		e.printStackTrace();
	      }
        return xml.toString();
    }

    public void setConfiguration(String pid, String did) {
        this.Patient_ID = pid;
        this.Device_ID = did;
        Connector();
    }

    
    
    //-----------------------------database access------------------
//    public void Connector(String SELECT_QUERY){
    public void Connector(){
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
//            connection = DriverManager.getConnection("jdbc:mysql://nbtcrehab.eng.psu.ac.th:3306/nbtcdb","nbtcAdmin", "Admin2558");
            connection = DriverManager.getConnection("jdbc:mysql://172.31.0.99:3306/nbtcdb","nbtcAdmin", "Admin2558");
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.err.println("You made it, take control your database now!");
            try{
            Statement stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            
            
            String SELECT_QUERY_patientWeek_weekNO = "SELECT MAX(Week_NO) FROM patient_week WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'";
            ResultSet wno = stmt.executeQuery(SELECT_QUERY_patientWeek_weekNO);
            wno.last();
            int week_NO = wno.getInt(wno.getRow());
            System.out.println("weekNO: "+week_NO);
            wno.beforeFirst();
            int nDinW;
            int nSinD;
            int nTinS;
            int day_NO;
            int set_NO;
            int time_NO;
            String end_dateTime;
                    
            if(week_NO != 0){
                
                String SELECT_QUERY_threshold_weekNO = "SELECT NoDayinWeek FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+week_NO+"";
                ResultSet rs2 = stmt.executeQuery(SELECT_QUERY_threshold_weekNO);
                rs2.last();
                nDinW = rs2.getInt(rs2.getRow());
                System.out.println("nDinW: "+nDinW);
                rs2.beforeFirst();
                
                String SELECT_QUERY_threshold_dayNO = "SELECT NoSetinDay FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+week_NO+"";
                ResultSet dt = stmt.executeQuery(SELECT_QUERY_threshold_dayNO);
                dt.last();
                nSinD = dt.getInt(dt.getRow());
                System.out.println("nSinD: "+nSinD);
                dt.beforeFirst();
                
                String SELECT_QUERY_threshold_setNO = "SELECT NoTimeinSet FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+week_NO+"";
                ResultSet st = stmt.executeQuery(SELECT_QUERY_threshold_setNO);
                st.last();
                nTinS = st.getInt(st.getRow());
                System.out.println("nSinD: "+nTinS);
                st.beforeFirst();
                
                String SELECT_QUERY_patientWeek_dayNO = "SELECT MAX(Day_NO) FROM patient_week WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+week_NO+"";
                ResultSet dno = stmt.executeQuery(SELECT_QUERY_patientWeek_dayNO);
                dno.last();
                day_NO = dno.getInt(dno.getRow());
                System.out.println("dayNO: "+day_NO);
                dno.beforeFirst();
                
                String SELECT_QUERY_patientWeek_setNO = "SELECT MAX(Set_NO) FROM patient_week WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+week_NO+" AND Day_NO="+day_NO+"";
                ResultSet sno = stmt.executeQuery(SELECT_QUERY_patientWeek_setNO);
                sno.last();
                set_NO = sno.getInt(sno.getRow());
                System.out.println("setNO: "+set_NO);
                sno.beforeFirst();
                
                String SELECT_QUERY_patientWeek_timeNO = "SELECT MAX(Time_NO) FROM patient_week WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+week_NO+" AND Day_NO="+day_NO+" AND Set_NO="+set_NO+"";
                ResultSet tno = stmt.executeQuery(SELECT_QUERY_patientWeek_timeNO);
                tno.last();
                time_NO = tno.getInt(tno.getRow());
                System.out.println("timeNO: "+time_NO);
                tno.beforeFirst();
                
                String SELECT_QUERY_patientWeek_enddatetime = "SELECT End_DateTime FROM patient_week WHERE Patient_Week_ID IN (SELECT MAX(Patient_Week_ID) FROM patient_week WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+week_NO+" AND Day_NO="+day_NO+" AND Set_NO="+set_NO+" AND Time_NO="+time_NO+")";
//                String SELECT_QUERY_patientWeek_enddatetime = "SELECT End_DateTime FROM patient_week WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+week_NO+" AND Day_NO="+day_NO+" AND Set_NO="+set_NO+" AND Time_NO="+time_NO;
                ResultSet edt = stmt.executeQuery(SELECT_QUERY_patientWeek_enddatetime);
                edt.last();
                end_dateTime = edt.getInt(edt.getRow())+"";
                System.out.println("end datetime: "+end_dateTime);
                edt.beforeFirst();
            
            }else {
                day_NO = 0;
                set_NO = 0;
                time_NO = 0;
                nDinW = 0;
                nSinD = 0;
                nTinS = 0;
                end_dateTime = "0";
            }
            
//            String SELECT_QUERY;
//            if(!week.equals("")){
//                SELECT_QUERY = "SELECT * FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+week+"";
//                System.out.println("given week");
//            }else if(day_NO >= nDinW || week_NO == 0){
//                SELECT_QUERY = "SELECT * FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+(week_NO+1)+"";
//                System.out.println("next week");
//            }else{
//                SELECT_QUERY = "SELECT * FROM threshold WHERE Patient_ID="+Patient_ID+" AND Device_ID=\'"+Device_ID+"\'"+" AND Week_NO="+(week_NO)+"";
//                System.out.println("current week");
//            }
            
//            ResultSet rs = stmt.executeQuery(SELECT_QUERY);

//            System.out.println(config);
//            while(rs.next()){
            getcurrent = new Current();
            
            getcurrent.setPatient_ID(Patient_ID);
//            System.out.println(getcurrent.getPatient_ID());
            getcurrent.setDevice_ID(Device_ID);
            getcurrent.setWeek_NO(week_NO);
//                        System.out.println(getcurrent.getWeek_NO());
            getcurrent.setDay_NO(day_NO);
            getcurrent.setSet_NO(set_NO);
            getcurrent.setTime_NO(time_NO);
            getcurrent.setNoDayinWeek(nDinW);
            getcurrent.setNoSetinDay(nSinD);
            getcurrent.setNoTimeinSet(nTinS);
            getcurrent.setEnd_DateTime(end_dateTime);
            
            
                
//                getconfig.setThreshold_ID(rs.getInt("Threshold_ID"));
//                getconfig.setPatient_ID(rs.getInt("Patient_ID")+"");
//                getconfig.setStaff_ID(rs.getInt("Staff_ID")+"");
//                getconfig.setDevice_ID(rs.getString("Device_ID"));
//                getconfig.setWeek_NO(rs.getInt("Week_NO"));
//                getconfig.setThreshold_DateTime(rs.getString("Threshold_DateTime"));
//                getconfig.setThreshold_1(rs.getInt("Threshold_1"));
//                getconfig.setThreshold_2(rs.getInt("Threshold_2"));
//                getconfig.setThreshold_3(rs.getInt("Threshold_3"));
//                getconfig.setThreshold_4(rs.getInt("Threshold_4"));
//                getconfig.setThreshold_5(rs.getInt("Threshold_5"));
//                getconfig.setThreshold_6(rs.getInt("Threshold_6"));
//                getconfig.setThreshold_7(rs.getInt("Threshold_7"));
//                getconfig.setThreshold_8(rs.getInt("Threshold_8"));
//                getconfig.setThreshold_9(rs.getInt("Threshold_9"));
//                getconfig.setThreshold_10(rs.getInt("Threshold_10"));
//                getconfig.setNoDayinWeek(rs.getInt("NoDayinWeek"));
//                getconfig.setNoSetinDay(rs.getInt("NoSetinDay"));
//                getconfig.setNoTimeinSet(rs.getInt("NoTimeinSet"));
                
//                getConfig.getConfiguration().add(getconfig);
                
//            }
            
            

            } catch(SQLException e){
                e.printStackTrace();
                System.err.println("SQLException");
            }
        } else {
            System.out.println("Failed to make connection!");
        }
    }
 
}

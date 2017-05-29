package getcurrentPackage;
//@XmlTransient

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Current {
    public String Patient_ID;
    public String Device_ID;
    public String Week_NO;
    public String Day_NO;
    public String Set_NO;
    public String Time_NO;
    public String End_DateTime;
    public String NoDayinWeek;
    public String NoSetinDay;
    public String NoTimeinSet;
    
    
    public Current(){
//        Patient_ID = "null";
//        Device_ID = "null";
//        Week_NO = "null";
//        Day_NO = "null";
//        End_DateTime = "null";
//        Time_NO = "null";
//        NoDayinWeek = "null";
//        NoSetinDay = "null";
//        NoTimeinSet = "null";
//        Set_NO = "null";
    }
    

//    @XmlElement
    @XmlTransient
    public void setPatient_ID(String Patient_ID) {
        this.Patient_ID = Patient_ID;
    }

//    @XmlElement
    @XmlTransient
    public void setDevice_ID(String Device_ID) {
        this.Device_ID = Device_ID;
    }

//    @XmlElement
    @XmlTransient
    public void setWeek_NO(int Week_NO) {
//        if(Week_NO != 0){
            this.Week_NO = Week_NO+"";
//        }else this.Week_NO = "null";
    }
    
    //    @XmlElement
    @XmlTransient
    public void setDay_NO(int Day_NO) {
//        if(Day_NO != 0){
            this.Day_NO = Day_NO+"";
//        }else this.Day_NO = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setSet_NO(int Set_NO) {
//        if(Set_NO != 0){
            this.Set_NO = Set_NO+"";
//        }else this.Set_NO = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setTime_NO(int Time_NO) {
//        if(Time_NO != 0){
            this.Time_NO = Time_NO+"";
//        }else this.Time_NO = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setNoDayinWeek(int NoDayinWeek) {
//        if(NoDayinWeek != 0){
            this.NoDayinWeek = NoDayinWeek+"";
//        }else this.NoDayinWeek = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setNoSetinDay(int NoSetinDay) {
//        if(NoSetinDay != 0){
            this.NoSetinDay = NoSetinDay+"";
//        }else this.NoSetinDay = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setNoTimeinSet(int NoTimeinSet) {
//        if(NoTimeinSet != 0){
            this.NoTimeinSet = NoTimeinSet+"";
//        }else this.NoTimeinSet = "null";
    }
    
    @XmlTransient
    public void setEnd_DateTime(String End_DateTime) {
//        if(!End_DateTime.equals("0")){
            this.End_DateTime = End_DateTime;
//        }else this.End_DateTime = "null";
    }
    
    public String getPatient_ID() {
        return Patient_ID;
    }

    public String getDevice_ID() {
        return Device_ID;
    }

    public String getWeek_NO() {
        return Week_NO;
    }

    public String getNoDayinWeek() {
        return NoDayinWeek;
    }

    public String getNoSetinDay() {
        return NoSetinDay;
    }

    public String getNoTimeinSet() {
        return NoTimeinSet;
    }

    public String getDay_NO() {
        return Day_NO;
    }

    public String getSet_NO() {
        return Set_NO;
    }

    public String getTime_NO() {
        return Time_NO;
    }

    public String getEnd_DateTime() {
        return End_DateTime;
    }
}

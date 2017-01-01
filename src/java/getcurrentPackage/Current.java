package getcurrentPackage;
//@XmlTransient

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Current {
    public String Patient_ID;
    public String Device_ID;
    public int Week_NO;
    public int Day_NO;
    public String End_DateTime;
    public int Time_NO;
    public int NoDayinWeek;
    public int NoSetinDay;
    public int NoTimeinSet;
    

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
        this.Week_NO = Week_NO;
    }

//    @XmlElement
    @XmlTransient
    public void setNoDayinWeek(int NoDayinWeek) {
        this.NoDayinWeek = NoDayinWeek;
    }

//    @XmlElement
    @XmlTransient
    public void setNoSetinDay(int NoSetinDay) {
        this.NoSetinDay = NoSetinDay;
    }

//    @XmlElement
    @XmlTransient
    public void setNoTimeinSet(int NoTimeinSet) {
        this.NoTimeinSet = NoTimeinSet;
    }
    
//    @XmlElement
    @XmlTransient
    public void setDay_NO(int Day_NO) {
        this.Day_NO = Day_NO;
    }

//    @XmlElement
    @XmlTransient
    public void setSet_NO(int Set_NO) {
        this.Set_NO = Set_NO;
    }

//    @XmlElement
    @XmlTransient
    public void setTime_NO(int Time_NO) {
        this.Time_NO = Time_NO;
    }
    
    @XmlTransient
    public void setEnd_DateTime(String End_DateTime) {
        this.End_DateTime = End_DateTime;
    }
    
    public String getPatient_ID() {
        return Patient_ID;
    }

    public String getDevice_ID() {
        return Device_ID;
    }

    public int getWeek_NO() {
        return Week_NO;
    }

    public int getNoDayinWeek() {
        return NoDayinWeek;
    }

    public int getNoSetinDay() {
        return NoSetinDay;
    }

    public int getNoTimeinSet() {
        return NoTimeinSet;
    }
        public int Set_NO;

    public int getDay_NO() {
        return Day_NO;
    }

    public int getSet_NO() {
        return Set_NO;
    }

    public int getTime_NO() {
        return Time_NO;
    }

    public String getEnd_DateTime() {
        return End_DateTime;
    }
}

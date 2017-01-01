package configurationPackage;
//@XmlTransient

import javax.xml.bind.annotation.XmlTransient;

public class Configuration {
    public int Threshold_ID;
    public String Patient_ID;
    public String Staff_ID;
    public String Device_ID;
    public int Week_NO;
    public String Threshold_DateTime;
    public int Threshold_1;
    public int Threshold_2;
    public int Threshold_3;
    public int Threshold_4;
    public int Threshold_5;
    public int Threshold_6;
    public int Threshold_7;
    public int Threshold_8;
    public int Threshold_9;
    public int Threshold_10;
    public int NoDayinWeek;
    public int NoSetinDay;
    public int NoTimeinSet;
    
//    @XmlElement
    @XmlTransient
    public void setThreshold_ID(int Threshold_ID) {
        this.Threshold_ID = Threshold_ID;
    }
//    @XmlElement
    @XmlTransient
    public void setPatient_ID(String Patient_ID) {
        this.Patient_ID = Patient_ID;
    }

//    @XmlElement
    @XmlTransient
    public void setStaff_ID(String Staff_ID) {
        this.Staff_ID = Staff_ID;
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
    public void setThreshold_DateTime(String Threshold_DateTime) {
        this.Threshold_DateTime = Threshold_DateTime;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_1(int Threshold_1) {
        this.Threshold_1 = Threshold_1;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_2(int Threshold_2) {
        this.Threshold_2 = Threshold_2;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_3(int Threshold_3) {
        this.Threshold_3 = Threshold_3;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_4(int Threshold_4) {
        this.Threshold_4 = Threshold_4;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_5(int Threshold_5) {
        this.Threshold_5 = Threshold_5;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_6(int Threshold_6) {
        this.Threshold_6 = Threshold_6;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_7(int Threshold_7) {
        this.Threshold_7 = Threshold_7;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_8(int Threshold_8) {
        this.Threshold_8 = Threshold_8;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_9(int Threshold_9) {
        this.Threshold_9 = Threshold_9;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_10(int Threshold_10) {
        this.Threshold_10 = Threshold_10;
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

    public int getThreshold_ID() {
        return Threshold_ID;
    }
    
    public String getPatient_ID() {
        return Patient_ID;
    }

    public String getStaff_ID() {
        return Staff_ID;
    }

    public String getDevice_ID() {
        return Device_ID;
    }

    public int getWeek_NO() {
        return Week_NO;
    }

    public String getThreshold_DateTime() {
        return Threshold_DateTime;
    }

    public int getThreshold_1() {
        return Threshold_1;
    }

    public int getThreshold_2() {
        return Threshold_2;
    }

    public int getThreshold_3() {
        return Threshold_3;
    }

    public int getThreshold_4() {
        return Threshold_4;
    }

    public int getThreshold_5() {
        return Threshold_5;
    }

    public int getThreshold_6() {
        return Threshold_6;
    }

    public int getThreshold_7() {
        return Threshold_7;
    }

    public int getThreshold_8() {
        return Threshold_8;
    }

    public int getThreshold_9() {
        return Threshold_9;
    }

    public int getThreshold_10() {
        return Threshold_10;
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
}

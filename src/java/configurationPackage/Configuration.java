package configurationPackage;
//@XmlTransient

import javax.xml.bind.annotation.XmlTransient;

public class Configuration {
    public String Threshold_ID;
    public String Patient_ID;
    public String Staff_ID;
    public String Device_ID;
    public String Week_NO;
    public String Threshold_DateTime;
    public String Threshold_1;
    public String Threshold_2;
    public String Threshold_3;
    public String Threshold_4;
    public String Threshold_5;
    public String Threshold_6;
    public String Threshold_7;
    public String Threshold_8;
    public String Threshold_9;
    public String Threshold_10;
    public String NoDayinWeek;
    public String NoSetinDay;
    public String NoTimeinSet;
    
    public Configuration(){
        Threshold_ID = "null";
        Patient_ID = "null";
        Staff_ID = "null";
        Device_ID = "null";
        Week_NO = "null";
        Threshold_1 = "null";
        Threshold_2 = "null";
        Threshold_3 = "null";
        Threshold_4 = "null";
        Threshold_5 = "null";
        Threshold_6 = "null";
        Threshold_7 = "null";
        Threshold_8 = "null";
        Threshold_9 = "null";
        Threshold_10 = "null";
        NoDayinWeek = "null";
        NoSetinDay = "null";
        NoTimeinSet = "null";
    }
    
//    @XmlElement
    @XmlTransient
    public void setThreshold_ID(int Threshold_ID) {
        this.Threshold_ID = Threshold_ID+"";
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
        this.Week_NO = Week_NO+"";
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_DateTime(String Threshold_DateTime) {
        this.Threshold_DateTime = Threshold_DateTime;
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_1(int Threshold_1) {
        if(Threshold_1 != 0){
            this.Threshold_1 = Threshold_1+"";
        }else this.Threshold_1 = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_2(int Threshold_2) {
        if(Threshold_2 != 0){
            this.Threshold_2 = Threshold_2+"";
        }else this.Threshold_2 = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_3(int Threshold_3) {
        if(Threshold_3 != 0){
            this.Threshold_3 = Threshold_3+"";
        }else this.Threshold_3 = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_4(int Threshold_4) {
        if(Threshold_4 != 0){
            this.Threshold_4 = Threshold_4+"";
        }else this.Threshold_4 = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_5(int Threshold_5) {
        if(Threshold_5 != 0){
            this.Threshold_5 = Threshold_5+"";
        }else this.Threshold_5 = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_6(int Threshold_6) {
        if(Threshold_6 != 0){
            this.Threshold_6 = Threshold_6+"";
        }else this.Threshold_6 = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_7(int Threshold_7) {
        if(Threshold_7 != 0){
            this.Threshold_7 = Threshold_7+"";
        }else this.Threshold_7 = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_8(int Threshold_8) {
        if(Threshold_8 != 0){
            this.Threshold_8 = Threshold_8+"";
        }else this.Threshold_8 = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_9(int Threshold_9) {
        if(Threshold_9 != 0){
            this.Threshold_9 = Threshold_9+"";
        }else this.Threshold_9 = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setThreshold_10(int Threshold_10) {
        if(Threshold_10 != 0){
            this.Threshold_10 = Threshold_10+"";
        }else this.Threshold_10 = "null";
    }

//    @XmlElement
    @XmlTransient
    public void setNoDayinWeek(int NoDayinWeek) {
        this.NoDayinWeek = NoDayinWeek+"";
    }

//    @XmlElement
    @XmlTransient
    public void setNoSetinDay(int NoSetinDay) {
        this.NoSetinDay = NoSetinDay+"";
    }

//    @XmlElement
    @XmlTransient
    public void setNoTimeinSet(int NoTimeinSet) {
        this.NoTimeinSet = NoTimeinSet+"";
    }

    public String getThreshold_ID() {
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

    public String getWeek_NO() {
        return Week_NO;
    }

    public String getThreshold_DateTime() {
        return Threshold_DateTime;
    }

    public String getThreshold_1() {
        return Threshold_1;
    }

    public String getThreshold_2() {
        return Threshold_2;
    }

    public String getThreshold_3() {
        return Threshold_3;
    }

    public String getThreshold_4() {
        return Threshold_4;
    }

    public String getThreshold_5() {
        return Threshold_5;
    }

    public String getThreshold_6() {
        return Threshold_6;
    }

    public String getThreshold_7() {
        return Threshold_7;
    }

    public String getThreshold_8() {
        return Threshold_8;
    }

    public String getThreshold_9() {
        return Threshold_9;
    }

    public String getThreshold_10() {
        return Threshold_10;
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
}

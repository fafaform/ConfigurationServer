package configurationPackage;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyConfiguration {
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
    
    public MyConfiguration() {}
    
    public MyConfiguration(String Patient_ID, String Staff_ID, String Device_ID, int Week_NO, String Threshold_DateTime, int[] Threshold_, int NoDayinWeek, int NoSetinDay, int NoTimeinSet){
        this.Patient_ID = Patient_ID;
        this.Staff_ID = Staff_ID;
        this.Device_ID = Device_ID;
        this.Week_NO = Week_NO;
        this.Threshold_DateTime = Threshold_DateTime;
        this.Threshold_1 = Threshold_[0];
        this.Threshold_2 = Threshold_[1];
        this.Threshold_3 = Threshold_[2];
        this.Threshold_4 = Threshold_[3];
        this.Threshold_5 = Threshold_[4];
        this.Threshold_6 = Threshold_[5];
        this.Threshold_7 = Threshold_[6];
        this.Threshold_8 = Threshold_[7];
        this.Threshold_9 = Threshold_[8];
        this.Threshold_10 = Threshold_[9];
        this.NoDayinWeek = NoDayinWeek;
        this.NoSetinDay = NoSetinDay;
        this.NoTimeinSet = NoTimeinSet;
    }
}

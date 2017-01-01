package configurationPackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Configurations {
    
    public List<Configuration> configuration;
    
    public Configurations(){
        configuration = new ArrayList<>();
    }

    public List<Configuration> getConfiguration() {
        return configuration;
    }
    @XmlElement(name="Configurations")
    public void setConfiguration(ArrayList<Configuration> configuration) {
        this.configuration = configuration;
    }

}

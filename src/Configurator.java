import java.io.*;
import java.util.Properties;

public class Configurator {

    private Properties props;
    private String pathToProps;

    Configurator(){
        props = new Properties();
        pathToProps = "tmp/config.properties";
    }

    public void setProps(Properties props) {
        this.props = props;
    }


    public void saveProps(){
        try {
            OutputStream output = new FileOutputStream(this.pathToProps);
            try {
                this.props.store(output, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadProps(){
        try {
            InputStream input = new FileInputStream(this.pathToProps);
            try {
                this.props.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Properties getProps(){
        return this.props;
    }


}

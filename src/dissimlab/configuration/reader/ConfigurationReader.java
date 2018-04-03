package dissimlab.configuration.reader;

import dissimlab.configuration.Configuration;
import dissimlab.configuration.Series;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConfigurationReader {
    private static final String FILENAME = "configuration.xml";
    private Logger logger = Logger.getLogger(ConfigurationReader.class.getName());
    private Series series;

    public void readConfiguration() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File configuration = new File(classLoader.getResource(FILENAME).getFile());
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(configuration);
            document.getDocumentElement().normalize();
            NodeList nThreadsNodes = document.getElementsByTagName(ElementType.N_THREADS.camelCaseValue());
            if (nThreadsNodes.getLength() != 1) {
                throw new IllegalArgumentException("Number of threads not defined.");
            }
            series = new Series(Integer.valueOf(nThreadsNodes.item(0).getTextContent()), new ArrayList<>());
            NodeList configNodes = document.getElementsByTagName(ElementType.CONFIG.camelCaseValue());
            for (int i = 0; i < configNodes.getLength(); i++) {
                Node configNode = configNodes.item(i);
                if (configNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) configNode;
                    series.getConfigs().add(new Configuration(Double.valueOf(eElement.getElementsByTagName
                        (ElementType.SEED.camelCaseValue()).item(0).getTextContent())));
                }
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Something really bad happened.");
        }
    }

    public Series getSeries() {
        return series;
    }

}
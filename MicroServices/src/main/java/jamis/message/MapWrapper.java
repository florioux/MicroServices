package jamis.message;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;


public class MapWrapper
{
	@XmlAnyElement( lax=true )
	protected List<JAXBElement<String>> elements;
}

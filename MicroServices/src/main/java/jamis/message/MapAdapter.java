package jamis.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;


public class MapAdapter extends XmlAdapter<MapWrapper, Map<String, String>>
{
	@Override
	public MapWrapper marshal(Map<String, String> map) throws Exception
	{
		MapWrapper wrapper = new MapWrapper();

		List<JAXBElement<String>> elements = new ArrayList<JAXBElement<String>>();

		wrapper.elements = elements;

		if( map == null || map.isEmpty() )
		{
			return wrapper;
		}

		for( Entry<String, String> property : map.entrySet() )
		{
			QName name = new QName( property.getKey() );
			elements.add( new JAXBElement<String>( name, String.class, property.getValue().toString() ) );
		}

		return wrapper;
	}

	@Override
	public Map<String, String> unmarshal(MapWrapper wrapper) throws Exception
	{
		Map< String, String> map = new HashMap<String, String>();

		if( wrapper == null || wrapper.elements == null || wrapper.elements.isEmpty() )
		{
			return map;
		}

		for( Object object : wrapper.elements )
		{
			Element element = (Element) object;
			map.put( element.getNodeName(), element.getTextContent() );
		}

		return map;
	}
}

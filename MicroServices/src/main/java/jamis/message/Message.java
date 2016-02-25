package jamis.message;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRootElement( name = "message" )
@XmlAccessorType( XmlAccessType.FIELD)
public class Message
{
	@XmlAttribute
	private String module;
	@XmlAttribute
	private String version;

	@XmlElement( name="field")
	@XmlJavaTypeAdapter( MapAdapter.class)
	private final Map<String, String> fields = new HashMap<String, String>();

	public Message()
	{
		// NOP
	}

	public Message( String module, String version )
	{
		this.module = module;
		this.version = version;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Map<String, String> getFields()
	{
		return fields;
	}

	public void addField( String key, String value )
	{
		fields.put( key, value);
	}

	@Override
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append( "module=" + module + ";");
		buffer.append( "version=" + version + ";");

		for( Entry<String, String> field : fields.entrySet() )
		{
			buffer.append( field.getKey()+"="+field.getValue()+";");
		}

		return buffer.toString();
	}
}

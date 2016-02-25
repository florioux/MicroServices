package jamis.message;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class MessageTest
{
	public static void main(String[] args)
	{
		Message msg = new Message("TestModule", "01");

		msg.addField("NAME", "Smith");
		msg.addField("MESSAGE", "Hello");

		try
		{
			JAXBContext ctx = JAXBContext.newInstance(Message.class);
			Marshaller jaxbMarshaller = ctx.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			StringWriter stringWriter = new StringWriter();

			jaxbMarshaller.marshal(msg, stringWriter);

			String result = stringWriter.toString();

			System.out.println(result);

			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			StringReader stringReader = new StringReader(result);

			Object object = unmarshaller.unmarshal(stringReader);

			Message msg2;

			if (object != null && object.getClass().isAssignableFrom(Message.class))
			{
				msg2 = Message.class.cast(object);

				System.out.println(msg2.toString());
			}

		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}
}

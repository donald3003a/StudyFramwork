package cn.github.studyframework.infrastructure.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public final class XMLTransformed {

	private XMLTransformed() {

	}

	public static void marshallerByJaxb(String path, Object object, Class clazz) throws JAXBException, IOException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Marshaller marshaller = jc.createMarshaller();
		File file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		}
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(object, file);
	}

	public static Object unmarshallerByJaxb(String path, Class clazz) throws JAXBException, IOException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		File file = new File(path);
		if (!file.exists()) {
			throw new FileNotFoundException("Can not load xml file!");
		}
		return unmarshaller.unmarshal(file);
	}
}

package cn.github.studyframework.infrastructure.xml;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import cn.github.studyframework.domain.Bean;
import cn.github.studyframework.domain.Beans;

public class XMLTransformedTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public void testMarshallerByJaxb() throws Exception {
		Beans beans = new Beans();
		List<Bean> list = new ArrayList<Bean>();
		Bean beanOne = new Bean();
		beanOne.setClassName("testClassOne");
		beanOne.setId("testIdOne");
		Bean beanTwo = new Bean();
		beanTwo.setClassName("testClassTwo");
		beanTwo.setId("testIdTwo");
		list.add(beanOne);
		list.add(beanTwo);
		beans.setBeanList(list);
		XMLTransformed.marshallerByJaxb("test.xml", beans, Beans.class);
	}

	public void testUnmarshallerByJaxb() throws Exception {
		Beans actual = (Beans) XMLTransformed.unmarshallerByJaxb("test.xml", Beans.class);
		Assert.assertEquals("testClassOne", actual.getBeanList().get(0).getClassName());
	}
}

package cn.github.studyframework.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "beans", namespace = "http://www.example.org/studyframework_0.1")
@XmlAccessorType(XmlAccessType.NONE)
public class Beans {

	@XmlElement(name = "bean")
	private List<Bean> beanList;

	public List<Bean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<Bean> beanList) {
		this.beanList = beanList;
	}

}

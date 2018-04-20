package dierji.httpServer.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PersonHandler extends DefaultHandler {
    private List<Person> persons;
    private Person person;
    private String tag;//记录标签名

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
//        System.out.println("处理文件开始");
        persons = new ArrayList<Person>();

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("开始一个元素" + qName);
        if (qName != null) {
            tag = qName;
        }
        if (qName != null && qName.equals("person")) {
            person = new Person();
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch,start,length);
        System.out.println(str);
        if (tag != null && tag.equals("name")) {
            person.setName(str);
        } else if (tag != null && tag.equals("age")) {
            Integer age = Integer.valueOf(str);
            person.setAge(age);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("结束一个元素" + qName);
        if (qName.equals("person")) {
            this.persons.add(person);
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
//        System.out.println("处理文件结束");
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}


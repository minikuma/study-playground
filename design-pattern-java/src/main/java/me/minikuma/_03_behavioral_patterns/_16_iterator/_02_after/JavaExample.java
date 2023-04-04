package me.minikuma._03_behavioral_patterns._16_iterator._02_after;

import me.minikuma._03_behavioral_patterns._16_iterator._01_before.Post;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.function.Consumer;

public class JavaExample {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        Board board = new Board();
        board.addPost("디자인 패턴");
        board.addPost("이터레이터 패턴");

        board.getPosts().iterator().forEachRemaining(new Consumer<Post>() {
            @Override
            public void accept(Post post) {
                System.out.println(post.getTitle());
            }
        });

        // XML 처리
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("book.xml"));

        while (reader.hasNext()) {
            XMLEvent xmlEvent = reader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                QName name = startElement.getName();
                if (name.getLocalPart().equals("book")) {
                    Attribute title = startElement.getAttributeByName(new QName("title"));
                    System.out.println(title.getValue());
                }
            }
        }
    }
}

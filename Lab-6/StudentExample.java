import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.math.BigInteger;

public class StudentExample {
    public static void main(String[] args) {
        try {
            // Initialize JAXB context for the generated classes
            JAXBContext context = JAXBContext.newInstance(generated.ObjectFactory.class);

            // Create a student object
            generated.Student student = new generated.Student();
            student.setName("John Doe");
            student.setAge(BigInteger.valueOf(20));
            student.setGrade("A");

            // Marshalling (Java object to XML)
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(student, new File("student.xml"));

            // Unmarshalling (XML to Java object)
            Unmarshaller unmarshaller = context.createUnmarshaller();
            generated.Student unmarshalledStudent = (generated.Student) unmarshaller.unmarshal(new File("student.xml"));

            // Print the unmarshalled student data
            System.out.println("Name: " + unmarshalledStudent.getName());
            System.out.println("Age: " + unmarshalledStudent.getAge());
            System.out.println("Grade: " + unmarshalledStudent.getGrade());
        } catch(JAXBException e) {
            e.printStackTrace();
        }
    }
}


// TO RUN THE FILE

// xjc -d src student.xsd
// javac -cp src StudentExample.java
// java -cp .:src:src/generated StudentExample

// Name: John Doe
// Age: 20
// Grade: A
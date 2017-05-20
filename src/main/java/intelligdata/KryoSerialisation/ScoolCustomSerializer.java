package intelligdata.KryoSerialisation;

import java.util.List;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import intelligdata.domain.School;
import intelligdata.domain.Student;

/*
 * This class implements custom serialization
 */
public class ScoolCustomSerializer extends Serializer<School>{

	@Override
	public School read(Kryo kryo, Input in, Class<School> clazz) {
		kryo.setReferences(true);
		School school=new School();
		kryo.reference(school);
		/*
		 * This is required because the students keep reference to the School object which in turn keeps reference to the student
		 */
		List<Student> f=null;
		school.setName(in.readString());
		school.setStudents((List<Student>)kryo.readClassAndObject(in));
		return school;		
	}

	@Override
	public void write(Kryo kryo, Output output, School school) {
		output.writeString(school.getName());
        kryo.writeClassAndObject(output, school.getStudents());
	}
	

}

package intelligdata.KryoSerialisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import intelligdata.domain.Person;

public class SimpleKryoSerialisation {
	public static void main(String[] args) throws FileNotFoundException{
		/*
		 * In this Example there is no need to define/implement custom Serializer, so we don't implement any
		 * No argument constructor is needed
		 */
		Kryo kryo=new Kryo();
		Person pers=new Person("John","Smith",35);
		OutputStream fileout=new FileOutputStream("person.bin");
		Output out=new Output(fileout);
		/*
		 * if you use this version of write method, Person cannot be null. 
		 * use writeObjectOrNull and readObjectOrNullif  null is possible
		 */
		kryo.writeObject(out, pers);
		out.close();// Make sure you close the OUtput
		
		// let's read the object back
		
		InputStream filein= new FileInputStream("person.bin");
		Input in=new Input(filein);
		Person read=kryo.readObject(in, Person.class);
		in.close();// make sure you close this
		System.out.println(read);
		
	}
	
}






package intelligdata.KryoSerialisation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import intelligdata.domain.Person;

public class KryoSerialisationToArray {
	/*
	 * THis example demonstrates writing object to a byte array, not to a file
	 */
	public static void main(String [] args){
		Person per=new Person("Geroge","Washington",67);
		Kryo kryo=new Kryo();
		ByteArrayOutputStream arrayOut=new ByteArrayOutputStream();
		Output out=new Output(arrayOut);
		/*
		 * if you use this version of write method, Person cannot be null. use writeObjectOrNull if  null is possible
		 */
		kryo.writeObject(out,per);
		out.close();
		
		// let's read the object back
		byte[] personByteArray=arrayOut.toByteArray();
		ByteArrayInputStream arrayin=new ByteArrayInputStream(personByteArray);
		Input in=new Input(arrayin);
		Person readPerson=kryo.readObject(in, Person.class);
		readPerson.print();
	}

}

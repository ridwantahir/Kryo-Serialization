package intelligdata.KryoSerialisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import intelligdata.domain.School;
import intelligdata.domain.Utilities;
/*
 * This example demonstrates how kryo can serialize nested objects and collections
 */
public class NestedObjectsKryoSerialization {
	public static void main(String[] args) throws FileNotFoundException{
		School school=Utilities.getSchool();
		Kryo kryo=new Kryo();
		OutputStream file=new FileOutputStream("school.bin");
		Output out=new Output(file);
		kryo.writeObject(out, school);
		out.close();
		
		// now let's read the object
		
		InputStream filein=new FileInputStream("school.bin");
		Input in=new Input(filein);
		School schoolRead=kryo.readObject(in, School.class);
		schoolRead.print();
	}
}

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Test;

public class TestSerializable {
	
	Personnel p;
	Personnel p2;
	
	ObjectOutputStream oos;
    ObjectInputStream ois;
	

	  public void setup() {
		
		p= new Personnel.Builder("Akrami", "Payam", 1).build();
		
		oos = null;
		
	}
	  
	  private Object deserialize(final byte[] bytes) throws ClassNotFoundException, IOException {
	        ByteArrayInputStream a = new ByteArrayInputStream(bytes);
	        ObjectInputStream b = new ObjectInputStream(a);
	        return b.readObject();
	  }
	  
	  private byte[] serialize(final Object obj) throws IOException {
	        ByteArrayOutputStream a = new ByteArrayOutputStream();
	        ObjectOutputStream b = new ObjectOutputStream(a);
	        b.writeObject(obj);
	        return a.toByteArray();
	    }
	  
	  
	  public void Output() {
		  try {
		    	
		        FileOutputStream fichier = new FileOutputStream("personneTest.txt");
		        oos = new ObjectOutputStream(fichier);
		        oos.writeObject(p);
		        oos.flush();
		    } catch (java.io.IOException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		          if (oos != null) {
		            oos.flush();
		            oos.close();
		          }
		        } catch (IOException ex) {
		          ex.printStackTrace();
		        }
		      }
	  }
	  
	  public void Input() {
		  try {
		        FileInputStream fichier = new FileInputStream("personneTest.txt");
		        ois = new ObjectInputStream(fichier);
		        p2 = (Personnel) ois.readObject();
		        p2.print();
		      } catch (final java.io.IOException e) {
		        e.printStackTrace();
		      } catch (final ClassNotFoundException e) {
		        e.printStackTrace();
		      } finally {
		        try {
		          if (ois != null) {
		            ois.close();
		          }
		        } catch (final IOException ex) {
		          ex.printStackTrace();
		        }
		      }
	  }
	  
	  
	  
	  
	  
	  
	  

	@Test
	public void test() throws IOException, ClassNotFoundException {
        //Output();
        //Input();
        
        
        byte[] serialisable = serialize(p);
        byte[] serialisable2 = serialize(p);

        Object deserialisable = deserialize(serialisable);
        Object deserialisable2 = deserialize(serialisable2);
        
        Assert.assertEquals(deserialisable, deserialisable2);
        Assert.assertEquals(p, deserialisable);
        Assert.assertEquals(p, deserialisable2);
	}

}

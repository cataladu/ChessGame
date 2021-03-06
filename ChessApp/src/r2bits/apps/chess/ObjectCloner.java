package r2bits.apps.chess;


import java.io.*;



public class ObjectCloner
{
	// so that nobody can accidentally create an ObjectCloner object
	private ObjectCloner()
	{
	}

	// returns a deep copy of an object
	public static Object deepCopy(Object oldObj) throws Exception 
	{
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);

			// serialize and pass the object
			oos.writeObject(oldObj);
			oos.flush();

			ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bin);

			Object result = ois.readObject();
			
			oos.close();
			ois.close();
			
			// return the new object
			return result;
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}

}

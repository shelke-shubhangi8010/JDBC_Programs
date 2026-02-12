package test;
import javax.sql.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.RowSetFactory;
public class RowSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			CachedRowSet rowset = RowSetProvider.newFactory().createCachedRowSet();
			rowset.setUrl("jdbc:mysql://localhost:3306/javaDB");
			rowset.setUsername("root");
			rowset.setPassword("root");
			rowset.setCommand("select * from person");
			rowset.execute();
		while(rowset.next())
		{
			System.out.println("Id :"+rowset.getInt()+"Name :"+rowset.getString(2)+"Age :"+rowset.getInt(3));
		}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		
		
	}

}

package edu.yangtzeu.lmis.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.yangtzeu.lmis.bll.BookBorrowAdmin;
import edu.yangtzeu.lmis.model.AbstractModel;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.BookBorrow;
import edu.yangtzeu.lmis.model.Borrow;

public class BookBorrowDAL {
	private String[] dispColNames = new String[] {"ͼ�����","ͼ������","ͼ������","�������","��������",
			"Ӧ������","��������","���ڽ��Ԫ"};
	
	private String[] methodNames = new String[]	{"getBkID","getBkName","getBkAuthor",
			"getIdContinueTimes","getIdDateOut","getIdDateRetPlan","getIdOverDay","getIdOverMoney"};
	
	public String[] getPrettyColumnNames()
	{
		return dispColNames;
	}
	
	public String[] getMethodNames()
	{
		return methodNames;
	}
	
	private BookBorrow initReader(ResultSet rs) throws SQLException
	{
		BookBorrow bkbw = new BookBorrow();
		//rd.setRdID(rs.getInt("rdID"));
		bkbw.setBkID(rs.getInt("bkID"));
		bkbw.setBkName(rs.getString("bkName"));
		bkbw.setBkAuthor(rs.getString("bkAuthor"));
		bkbw.setIdContinueTimes(rs.getInt("IdContinueTimes"));
		bkbw.setIdDateOut(rs.getDate("IdDateOut"));
		bkbw.setIdDateRetPlan(rs.getDate("IdDateRetPlan"));
		bkbw.setIdOverDay(rs.getInt("IdOverDay"));
		bkbw.setIdOverMoney(rs.getFloat("IdOverMoney"));

		
		return bkbw;
		
	}
	public BookBorrow[] getObjectByID(int rdID) throws SQLException {
		ArrayList<BookBorrow> bkbws = new ArrayList<BookBorrow>();
		ResultSet rs = SQLHelper
				.getResultSet("SELECT Tb_borrow.`bkID`,bkName,bkAuthor,IdContinueTimes,IdDateOut,IdDateRetPlan,IdOverDay,IdOverMoney "
						+ "from Tb_Book,Tb_borrow "
						+ "where Tb_borrow.`rdID` = " + "'"+rdID+"'"
						+"and Tb_book.`bkID` = Tb_borrow.`bkID`");
		if(rs != null)
		{
			while(rs.next())
			{
				BookBorrow bkbw = initReader(rs);
				bkbws.add(bkbw);
			}
			rs.close();
		}
		if(bkbws.size() > 0)
		{
			BookBorrow[] array = new BookBorrow[bkbws.size()];
			bkbws.toArray(array);
			return array;
		}
		
		return null;	
	}


}

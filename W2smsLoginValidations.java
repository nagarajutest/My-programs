package w2sms;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class W2smsLoginValidations 
{
	public static void main(String[] args) throws Exception, IOException 
	{
		//Conect to excel file
		File f=new File("Wlogin.xls");
		//open excel file for reading
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh1=rwb.getSheet(0);//0 for sheet1
		int nour1=rsh1.getRows();
		int nouc1=rsh1.getColumns();
		Sheet rsh2=rwb.getSheet(1);//1 for sheet2
		int nour2=rsh2.getRows();
		int nouc2=rsh2.getColumns();
		//open same excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh1=wwb.getSheet(0);//0 for sheet1
		WritableSheet wsh2=wwb.getSheet(1);//1 for sheet 2
		WritableCellFormat cf=new WritableCellFormat();
		cf.setAlignment(Alignment.JUSTIFY);
		cf.setWrap(true);
		//set name to result column in sheet1
		Date d1=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String ssname=sf.format(d1);
		Label l1=new Label(nouc1,0,ssname,cf);
		wsh1.addCell(l1);
		//set name to result column in sheet2
		Label l2=new Label(nouc2,0,ssname,cf);
		wsh2.addCell(l2);
		//create object to methods class
		W2smsMethods msm=new W2smsMethods();
		//collect methods info using methods class object
		Method m[]=msm.getClass().getMethods();
		//keyword driven
		try
		{
			//calling methods one after other
			//1st row(index is 0)havenames of cols in sheet1
			for(int i=1;i<nour1;i++)
			{
				int flag=0;
				//get tid and mode from sheet1
				String tid=rsh1.getCell(0,i).getContents();
				String mode=rsh1.getCell(2,i).getContents();
				if(mode.equalsIgnoreCase("yes"))
				{
					//1st row (index 0)have names of cols in shhet2
					for(int j=1;j<nour2;j++)
					{
						String sid=rsh2.getCell(0,j).getContents();
						if(tid.equalsIgnoreCase(sid))
						{
							//take step details from sheet2
							String mn=rsh2.getCell(2,j).getContents();
							String a=rsh2.getCell(3,j).getContents();
							String b=rsh2.getCell(4,j).getContents();
							String c=rsh2.getCell(5,j).getContents();
							System.out.println(mn+" "+a+" "+b+" "+c);
							for(int k=0;k<m.length;k++)
							{
								if(m[k].getName().equals(mn))
								{
									String r=(String) m[k].invoke(msm,a,b,c);
									Label lb=new Label(nouc2,j,r,cf);
									wsh2.addCell(lb);//step result
									if(r.contains("Failed")||r.contains("Interupted"))
									{
										flag=1;
									}
								}
							}
						}
						if(flag==0)
						{
							Label l=new Label(nouc1,i,"passed",cf);
							wsh1.addCell(l);
						}
						else
						{
							Label l=new Label(nouc1,i,"Failed",cf);
							wsh1.addCell(l);
						}
						
					}
				}
				
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//save and close excel
		wwb.write();
		wwb.close();
		rwb.close();

	}

}

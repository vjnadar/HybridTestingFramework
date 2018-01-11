package utilities;

import constants.CommonConstants;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

/**
 * Created by Vijay Joshua Nadar on 3/6/2017.
 */
public class ExcelConfig

{

    XSSFWorkbook workbook;

    XSSFSheet sheet1;

    XSSFSheet sheet2;

    public ExcelConfig(String excelPath)

    {
        try {

            File source= new File(CommonConstants.EXCELFILELOCATION);

            FileInputStream fis=new FileInputStream(source);

            workbook=new XSSFWorkbook(fis);

            sheet1=workbook.getSheetAt(CommonConstants.TC_SHEETNO);

            sheet2=workbook.getSheetAt(CommonConstants.TS_SHEETNO);

        } catch (IOException e)

        {

            e.printStackTrace();
        }

    }
    public int getRowCount(int sheetNumber)

    {

        int rowCount=0;

        if(sheetNumber==0)

        {

            rowCount=sheet1.getLastRowNum();

        }else if(sheetNumber==1)
        {

            rowCount=sheet2.getLastRowNum();

        }

        return rowCount;

    }

    public String getData(int sheetNumber,int rowNumber, int columnNumber)

    {

        DataFormatter format=new DataFormatter();

        String data=null;

        int rowCount=getRowCount(sheetNumber);

        if(sheetNumber==0)

        {

            data=format.formatCellValue(sheet1.getRow(rowNumber).getCell(columnNumber));

        }else if(sheetNumber==1)

        {

            data=format.formatCellValue(sheet2.getRow(rowNumber).getCell(columnNumber));

        }

        return data;

    }

    public int getFirstTestRow(String commonValue,int sheetNumber,int columnNumber)

    {

        int rowCount=getRowCount(sheetNumber);

        int firstTestRow=0;

        for(int i=1;i<=rowCount;i++)

        {

            if(commonValue.equalsIgnoreCase(getData(sheetNumber,i,columnNumber)))

            {

                firstTestRow=i;

                break;

            }

        }

        return firstTestRow;

    }
    public int getLastTestRow(int firstTestRow, int sheetNumber,int columnNumber)

    {

        int rowCount=getRowCount(sheetNumber);

        String firstTestRowValue=getData(sheetNumber,firstTestRow,columnNumber);

        int lastTestRow=0;

        for(int i=firstTestRow;i<=rowCount;i++)

        {

            if(!(firstTestRowValue.equalsIgnoreCase(getData(sheetNumber,i,columnNumber))))

            {

                lastTestRow=i-1;

                break;

            }

        }
        return lastTestRow;

    }
    
//    public void writeToExcel(int sheetNumber,int rowNumber,int columnNumber)


}

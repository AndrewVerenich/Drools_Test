package by.scripts

import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook


class XlsSplitter {
    static void split(String fileName,String downloadPath, String targetPath, String sheetName){

        File file=new File(downloadPath+'/'+fileName)
        FileInputStream inputStream=new FileInputStream(file)
        HSSFWorkbook workbook=new HSSFWorkbook(inputStream)

        for(int i=workbook.getNumberOfSheets()-1;i>=0;i--){
            HSSFSheet tmpSheet =workbook.getSheetAt(i)
            if(!tmpSheet.getSheetName().equals(sheetName)){
                workbook.removeSheetAt(i)
            }
        }

        inputStream.close()

        File destFile=new File(targetPath+'/'+sheetName+'.xls')
        FileOutputStream output = new FileOutputStream(destFile)
        workbook.write(output)
        output.close()
    }
}

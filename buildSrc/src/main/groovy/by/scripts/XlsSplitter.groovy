package by.scripts

import groovy.json.JsonSlurper
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook

class XlsSplitter {
    static void split(String documentDescriptor, String rootDir, String downloadPath, String relResourcePath) {
        def rulesJson = new JsonSlurper().parseText(new File(documentDescriptor).text)
        rulesJson.files.each {
            def docName = it.fileName
            def projectName = it.projectName
            it.documents.each {
                def sheetName = it.getKey()
                def newSheetName = sheetName
                if (!it.getValue().sheetName.equals(""))
                    newSheetName = it.getValue().sheetName
                if (!it.getValue().projectName.equals(""))
                    projectName = it.getValue().projectName
                splitOnSheets(docName + '.xls',
                        downloadPath,
                        rootDir + '/' + projectName + '/' + relResourcePath,
                        sheetName,
                        newSheetName,
                        it.getValue().documentName)
            }
        }
    }

    static void splitOnSheets(String docName, String downloadPath, String targetPath, String sheetName,
                              String newSheetName, String newDocName) {
        HSSFWorkbook workbook = getWorkbook(downloadPath, docName)
        removeAllSheetsExceptOne(workbook, sheetName, newSheetName)
        saveWorkbook(targetPath, newDocName, workbook)
    }

    private static HSSFWorkbook getWorkbook(String downloadPath, String docName) {
        File file = new File(downloadPath + '/' + docName)
        FileInputStream inputStream = new FileInputStream(file)
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream)
        workbook
    }

    private static void saveWorkbook(String targetPath, String newDocName, HSSFWorkbook workbook) {
        File destFile = new File(targetPath + '/' + newDocName + '.xls')
        FileOutputStream output = new FileOutputStream(destFile)
        workbook.write(output)
    }

    private static void removeAllSheetsExceptOne(HSSFWorkbook workbook, String sheetName, String newSheetName) {
        for (int i = workbook.getNumberOfSheets() - 1; i >= 0; i--) {
            HSSFSheet tmpSheet = workbook.getSheetAt(i)
            if (!tmpSheet.getSheetName().equals(sheetName)) {
                workbook.removeSheetAt(i)
            }
        }
        workbook.setSheetName(0, newSheetName)
    }

}

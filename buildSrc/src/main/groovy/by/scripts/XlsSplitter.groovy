package by.scripts

import groovy.json.JsonSlurper
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class XlsSplitter {
    static void split(String documentDescriptor, String rootDir, String downloadPath, String relResourcePath) {
        def rulesJson = new JsonSlurper().parseText(new File(documentDescriptor).text)
        rulesJson.files.each {
            def docName = it.fileName
            def projectName = it.projectName
            it.documents.each {
                def sheetName = it.getKey()
                def newSheetName = sheetName
                if ("" != it.getValue().sheetName)
                    newSheetName = it.getValue().sheetName
                if ("" != it.getValue().projectName)
                    projectName = it.getValue().projectName
                splitOnSheets(docName + '.xlsx',
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
        XSSFWorkbook workbook = getWorkbook(downloadPath, docName)
        removeAllSheetsExceptOne(workbook, sheetName, newSheetName)
        saveWorkbook(targetPath, newDocName, workbook)
    }

    private static XSSFWorkbook getWorkbook(String downloadPath, String docName) {
        File file = new File(downloadPath + '/' + docName)
        FileInputStream inputStream = new FileInputStream(file)
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream)
        workbook
    }

    private static void saveWorkbook(String targetPath, String newDocName, XSSFWorkbook workbook) {
        File destFile = new File(targetPath + '/' + newDocName + '.xlsx')
        FileOutputStream output = new FileOutputStream(destFile)
        workbook.write(output)
    }

    private static void removeAllSheetsExceptOne(XSSFWorkbook workbook, String sheetName, String newSheetName) {
        for (int i = workbook.getNumberOfSheets() - 1; i >= 0; i--) {
            XSSFSheet tmpSheet = workbook.getSheetAt(i)
            if (!tmpSheet.getSheetName().equals(sheetName)) {
                workbook.removeSheetAt(i)
            }
        }
        workbook.setSheetName(0, newSheetName)
    }

}

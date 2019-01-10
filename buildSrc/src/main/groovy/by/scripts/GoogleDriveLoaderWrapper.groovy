package by.scripts

class GoogleDriveLoaderWrapper {
//    static boolean filePropertiesValid(final Map fileProperties) {
//        fileProperties.containsKey("fileId") &&
//                fileProperties.containsKey("savePath") &&
//                fileProperties.containsKey("alias") &&
//                fileProperties.containsKey("fileName")
//
//    }
//
//    static void downloadFile(GoogleDriveLoader googleDriveLoader,
//                             Map fileProperties,
//                             String rootProjectPath,
//                             String projectName,
//                             String relativeProjectPath = "src/main/resources/excel") {
//        if (Objects.isNull(googleDriveLoader) || !filePropertiesValid(fileProperties)) {
//            return
//        }
//
//        String savePath = ("${rootProjectPath}/${projectName}/${relativeProjectPath}/${fileProperties.savePath ?: ""}") + "/"
//        def dir = new File(savePath)
//        dir.mkdirs()
//
//        println "Google Drive Download File. Alias: [${fileProperties.alias}] File id: [${fileProperties.fileId}] Save path: [${savePath}]"
//
//        File file = googleDriveLoader.getFileById(fileProperties.fileId as String)
//        def fileName = fileProperties.fileName ?: file.getName()
//        try {
//            googleDriveLoader.downloadFile(file.getId()).writeTo new FileOutputStream(new File(dir, "${fileName}.xlsx"))
//        } catch (Exception e) {
//            println "File [${fileName}] hasn't been downloaded"
//        }
//
//        println "File [${fileName}] has been downloaded"
//    }
//
//    static GoogleDriveLoader createGoogleDriveLoader() {
//        def clientId = System.getProperty("clientId", "")
//        def clientSecret = System.getProperty("clientSecret", "")
//        def refreshToken = System.getProperty("refreshToken", "")
//
//        if (clientId == "" || clientSecret == "" || refreshToken == "") return null
//
//        return new GoogleDriveLoader(clientId, clientSecret, refreshToken)
//    }

}
# Drools_test
This application is used to calculate vacation and illness days of an employee. 
## Getting Started
Clone this repo to your local machine using:
```bash
git clone https://github.com/AndrewVerenich/Drools_Test
```
The application uses Business Rules Management System (BRMS) Red Hat Drools. You can edit you business rules in .xls file 
and store this file on Google Drive. Then the application will use this file from Google Drive. You should complete following steps:

+ Create your rules for vacation and illness days in .xls file. Example file is in gradle/resources/Employee.xls. Your file must 
have "vacDays" and "illDays" sheets.
+ Create your new Google Drive account and store .xls file. Then write file name and file id in gradle/resources/files.json
```json
{
  "files": [
    {
      "alias": "your alias",
      "fileId": "your fileId",
      "projectName": "default projectName",
      "fileName": "your fileName",
      "documents": {
        "sheetName": {
          "documentName": "new docName",
          "sheetName": "new sheetName",
          "projectName": "projectName"
        }
      }
    }
  ]
}
```
+ Set up Google Drive API in your account and write your credentials in gradle/resources/credentials.json. More information on https://developers.google.com/drive/api/v3/about-auth
```json
{
  "clientId": "your clientId",
  "clientSecret": "your clientSecret",
  "refreshToken": "your refreshToken"
}
```

Build the application.
```bash
gradle build
```
## Technology stack
+ Spring Framework
+ Red Hat Drools
+ GoogleDrive API
+ Gradle

## License
[MIT](https://choosealicense.com/licenses/mit/)

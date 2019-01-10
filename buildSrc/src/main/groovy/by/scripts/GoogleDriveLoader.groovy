package by.scripts

import com.google.api.client.auth.oauth2.TokenResponseException
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.client.googleapis.auth.oauth2.GoogleRefreshTokenRequest
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.drive.Drive

/**
 * This class provides access to google drive
 *
 * How to create clientId, clientSecret:
 * 1. Go to <a href="https://console.developers.google.com">Google console</a>
 * 2. Create new project
 * 3. Go to "Dashboard" tab and click "Enable APIs and services" then select "Google Drive API" and "Enable"
 * 4. Go to "Credentials" tab
 * 5. Specify "Product name shown to users" on "OAuth consent screen"
 * 6. "Create credentials" -> "OAuth client ID" -> "Web application" on "Credentials" tab
 * 7. Fill "Authorized redirect URIs" field with "https://developers.google.com/oauthplayground"
 * 8. Create button
 *
 * How to create refresh_token:
 * 1. Go to <a href="https://developers.google.com/oauthplayground">Google Oauth playground</a>
 * 2. Open settings
 * 3. Set OAuth flow: Server, Access type:Offline, Use your own OAuth credentials (tick)
 * 4. Fill "OAuth Client ID" and "OAuth Client secret" fields
 * 5. Select: "Select & authorize APIs" value "Drive API v" and click "Authorize APIs"
 * 6. Then click "Exchange authorization code for tokens"
 * 7. Save "Refresh token"
 *
 * @see <a href="https://developers.google.com/identity/protocols/OAuth2#expiration">Token expiration</a>
 */
class GoogleDriveLoader {
//    private static final String FILE_FIELDS = 'nextPageToken, files(id, name, modifiedTime)'
//    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance()
//    private static final HttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()
//    private final Drive drive
//
//    GoogleDriveLoader(final String clientId, final String clientSecret, final String refreshToken) {
//        drive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, createGoogleCredential(clientId, clientSecret, refreshToken)).build()
//    }
//
//    static private GoogleCredential createGoogleCredential(final String clientId, final String clientSecret, final String refreshToken) {
//        String accessToken = new GoogleRefreshTokenRequest(HTTP_TRANSPORT, JSON_FACTORY, refreshToken, clientId, clientSecret).execute().getAccessToken()
//        new GoogleCredential.Builder()
//                .setClientSecrets(clientId, clientSecret)
//                .setJsonFactory(JSON_FACTORY)
//                .setTransport(HTTP_TRANSPORT).build()
//                .setRefreshToken(refreshToken)
//                .setAccessToken(accessToken)
//    }
//
//    ByteArrayOutputStream downloadFile(final String fileId) throws TokenResponseException {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
//
//        drive.files()
//                .export(fileId, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
//                .executeMediaAndDownloadTo(outputStream)
//
//        outputStream
//    }
//
//    List<File> getFilesFromFolder(final String folderId) throws TokenResponseException {
//        drive.files().list()
//                .setQ("'${folderId}' in parents and mimeType != 'application/vnd.google-apps.folder' and trashed = false")
//                .setFields(FILE_FIELDS)
//                .execute()
//                .getFiles()
//    }
//
//    File getFileById(final String fileId) throws TokenResponseException {
//        drive.files().get(fileId).execute()
//    }
}
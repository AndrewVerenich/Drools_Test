package by.scripts

import groovy.json.JsonSlurper
import org.drools.compiler.compiler.DecisionTableProvider
import org.drools.decisiontable.DecisionTableProviderImpl
import org.kie.api.io.Resource
import org.kie.internal.io.ResourceFactory

class DrlFileGenerator {
    static void create(String documentDescriptor, String rootDir, String savePath, relResourcePath) {
        DecisionTableProvider provider = new DecisionTableProviderImpl()
        def rulesJson = new JsonSlurper().parseText(new File(documentDescriptor).text)
        rulesJson.files.each {
            def projectName = it.projectName
            it.documents.each {
                def docName = it.getValue().documentName
                if ("" != it.getValue().projectName)
                    projectName = it.getValue().projectName
                Resource dt = ResourceFactory.newFileResource(rootDir + '/' + projectName + '/' + relResourcePath + '/' +
                        docName + '.xlsx')
                String drlString = provider.loadFromResource(dt, null)
                saveDrlFile(drlString, savePath, docName)
            }
        }
    }

    static void saveDrlFile(String rules, String savePath, String docName) {
        PrintStream out = new PrintStream(new FileOutputStream(savePath + '/' + docName + '.drl'))
        out.print(rules)
    }
}

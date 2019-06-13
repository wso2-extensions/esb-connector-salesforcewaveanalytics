##  Integration tests for WSO2 ESB Salesforce Wave Analytics connector
##### Pre-requisites:

    - Maven 3.3.x
    - Java 1.8

##### Tested Platforms:

    - WSO2 EI 6.4.0

##### Steps to follow in setting integration test.


 1. Download EI 6.4.0 from [official website](https://wso2.com/products/enterprise-service-bus/#).

 2. Create a Salesforce account and create a connected app.

            i. Using the URL "https://developer.salesforce.com/promotions/orgs/analytics-de" create an account.
            
            ii. Create a connected app to get the clientId and clientSecret. Refer below link to create connected app.
                https://developer.salesforce.com/docs/atlas.en-us.218.0.api_rest.meta/api_rest/intro_defining_remote_access_applications.htm.
       * Get the client credentials from the connected app.
     
       * Follow the steps below to obtain an access token and refresh token to access the connected application that you created:
       
           1. In the following URL, first replace <your_client_id> place holder with the consumer key that you obtained. Next, replace <your_redirect_uri> place holder with the value that you specified as the callback URL when creating the connected application, and then open the URL via a web browser. 
               ```xml
               https://login.salesforce.com/services/oauth2/authorize?response_type=code&client_id=<your_client_id>&redirect_uri=<your_redirect_uri>
               ```
           2. Approve the application to access your Salesforce account. You will see that the browser redirects you to the callback URL that you specified when creating the connected application:
              ```xml
              https://app.com/oauth_callback?code=aWe...c4w%3D%3D
              ```
           3. Extract the authorization code from the callback URL.
       
           4. Send a direct POST request to the authorization server using the following request: 
               > NOTE: Be sure to replace the place holders with values applicable to the connected application that you created.
               ```xml
               https://login.salesforce.com/services/oauth2/token?code=aWe...c4w==&grant_type=authorization_code&client_id=<your_client_id>&client_secret=<your_client_secret>&redirect_uri=<your_redirect_uri>&format=json
               ```
               > NOTE:In the above request, you can set the format to one of the following based on the format in which you want to retrieve the response:
               * **url encoded**
               * **json**
               * **xml**
           5. From the response that you get, extract the access token to access Salesforce via the created application. 
              > NOTE: You will also get a refresh token to renew the access token when it expires.


 3. Before you start performing various operations with the connector, make sure to place the Salesforce certificate to the location
   "{SALESFORCEWAVEANALYTICS_CONNECTOR_HOME}/repository/".Follow the steps to import the certificate:
   
            i.  Export the Salseforce certificate "DigiCertSHA2SecureServerCA.crt" form the Salesforcehome page and place the certificate file in following location. 
               "{SALESFORCEWAVEANALYTIS_CONNECTOR_HOME}/src/repository"
               
            ii. Open a command line terminal and execute the following command to import the certificate to  client-truststore.jks and wso2carbon.jks:
                   "keytool -importcert -file DigiCertSHA2SecureServerCA.crt -keystore {SALESFORCEWAVEANALYTICS_CONNECTOR_HOME}/src/test/resources/keystores/products/client-truststore.jks -alias salesforce" and "keytool -importcert -file DigiCertSHA2SecureServerCA.crt -keystore {SALESFORCEWAVEANALYTICS_CONNECTOR_HOME}/src/test/resources/keystores/products/wso2carbon.jks -alias salesforce"
               
 4. Update the esb-connector-salesforcewaveanalytics properties file at location "<SALESFORCEWAVEANALYTICS_CONNECTOR_HOME>/repository/ with the suited values.

 5. Following are the properties used in the 'esb-connector-salesforcewaveanalytics.properties' file and salesforcewaveanalytics properties file at location "<SALESFORCEWAVEANALYTICS_CONNECTOR_HOME>/src/test/resources/artifacts/ESB/connector/config" to run the integration tests.
    
                apiUrl 		                 -   The URL of the Salesforceconnected app.
                apiVersion                           -   The api version for the connected app(New version is better because some of the features are supported only on the new version).
                refreshToken                         -   The refresh token to access the API.
                clientId                             -   The Consumer key of API to access the connected app.
                clientSecret                         -   The consumer key of API to access the connected app.
                hostName                             -   Value of the hostname to authenticate salesforce.
                accessToken                          -   The access token to the access the API.
                state                                -   The state of the dashboard.
                folderName                           -   Folder name in which this dashboard is stored
                label                                -   The label of the asset.
                description                          -   Short description of the asset.
                name                                 -   The name of the asset
                mobileOnly                           -   For mobile dashboards only.
                scope                                -   The type of scope to be applied to a collection of resources.
                pageSize                             -   Number of items to be returned in a single page. Minimum is 1, maximum is 200, and default is 25.
                sort                                 -   Property names that can be sorted.
                type                                 -   The description of the newly created/updated record.
                hasCurrentOnly                       -   Current version true or false
                order                                -   Order of the values (Ascending or descending).
                isPinned                             -   Boolean value for pinned.
                mobileOnlyFeaturedAssets             -   Set this parameter to true to show only dashboards that are enabled for the Einstein Analytics mobile app.
                mobileDisabled                       -   Whether the dashboard is disabled on mobile.
                attachedFilesId                      -   The attached files id.
                attachedFilesName                    -   The attached files name.
                assetIcon                            -   The icon enumeration that best represents the new folder or application. Valid values are 1.png through 20.png.
                defaultAssetName                     -   Name of the default asset.
                canBeSharedExternally                -   Whether the application is shared in Communities.
                applicationStatus                    -   The creation status of application.
        
                
 ###### Note
 To get a attachedFileId follow the steps given below:
 
* Login to your developer account.
* Switch to classical view.
* Go to User menu for your user name.
* Go to My profile and click the "+" sign.
* And select the "files".
* Under the "MY FILES" choose Owned by me or shared with me or following and select a file.
* You can get the attachedFilesId at the URL for example "https://ap8.salesforce.com/0690o000005szja?retUrl=%2F_ui%2Fcore%2Fchatter%2Ffiles%2FFileTabPage".
* Extract the attachedFilesId.
            

 
 6,   Navigate to "{SALESFORCEWAVEANALYTICS_CONNECTOR_HOME}/" and run the following command. <br/>
           
             `$ mvn clean install -Dskip-tests=false`

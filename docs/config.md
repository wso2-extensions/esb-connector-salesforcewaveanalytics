# Configuring Salesforce Wave Analytics Operations

[[Prerequisites]](#Prerequisites) [[Initializing the connector]](#initializing-the-connector)

## Prerequisites

> NOTE: To work with the Salesforce Wave Analytics connector, you need to have a Salesforce account. If you do not have a Salesforce account, go to [https://developer.salesforce.com/promotions/orgs/analytics-de](https://developer.salesforce.com/promotions/orgs/analytics-de) and create a Salesforce developer account.

Before you start performing various operations with the connector, make sure to place the Salesforce certificate to the location.Follow the steps to import the certificate:
   
        i.  Export the Salseforce certificate "DigiCertSHA2SecureServerCA.crt" form the salesforce home page.
           
        ii. Open a command line terminal and execute the following command to import the certificate to  client-truststore.jks and wso2carbon.jks:
               "keytool -importcert -file DigiCertSHA2SecureServerCA.crt -keystore {SALESFORCEWAVEANALYTICS_CONNECTOR_HOME}/src/test/resources/keystores/products/client-truststore.jks -alias salesforce" and "keytool -importcert -file DigiCertSHA2SecureServerCA.crt -keystore {SALESFORCEWAVEANALYTICS_CONNECTOR_HOME}/src/test/resources/keystores/products/wso2carbon.jks -alias salesforce"
           

Salesforce Wave Analytics API uses the OAuth protocol to allow application users to securely access data without having to reveal their user credentials.  For more information on authentication is done in Salesforce, see [Understanding Authentication](https://developer.salesforce.com/docs/atlas.en-us.api_rest.meta/api_rest/intro_understanding_authentication.htm).

###Obtaining user credentials

* **Follow the steps below to create a connected application using Salesforce and to obtain the consumer key as well as the consumer secret for the created connected application:**

    1. Go to https://developer.salesforce.com/promotions/orgs/analytics-de, and sign up to get a free developer environment. 
    2. Go to **Setup** -> **Create** -> **Apps**, and click **New**. This creates a new connected application.
    3. Specify a name for your application, your email address as well as any other basic information applicable to your application.
    4. Specify an **Info URL**. This is where a user can go for more information about your application.
    5. Select **Enable OAuth Settings**. This displays the **API (Enable OAuth Settings)** section.
    6. Under the **API (Enable OAuth Settings)** section, specify a **Callback URL**. Depending on the OAuth flow you use, this is typically the URL that your browser is redirected to, after successful authentication. Since this URL is used in some OAuth flows to pass an access token, the URL must use secure HTTP or a custom URI scheme.
    7. Select the required OAuth scopes from the **Available OAuth Scopes** list and click **Add** to include those as **Selected OAuth Scopes**. These OAuth scopes include permission given by the user running the connected application.
    8. Click **Save**. This saves the details of the connected application that you created, and displays the **Consumer Key** as well as the **Consumer Secret** of the connected application under the **API (Enable OAuth Settings)** section.
    
* **Follow the steps below to obtain an access token and refresh token to access the connected application that you created:**

    1. In the following URL, first replace <your_client_id> place holder with the consumer key that you obtained. Next, replace <your_redirect_uri> place holder with the value that you specified as the callback URL when creating the connected application, and then open the URL via a web browser. 
        ```xml
        https://login.salesforce.com/services/oauth2/authorize?response_type=code&client_id=<your_client_id>&redirect_uri=<your_redirect_uri>
        ```
    2. Approve the application to access your Salesforce account. You will see that the browser redirects you to the callback URL that you specified when creating the connected application:
       ```xml
       https://app.com/oauth_callback?code=aWe...c4w%3D%3D
       ```
    3. Extract the authorization code from the callback URL.
.
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


In this connector we have  [Web Server OAuth Authentication Flow](#init).

## Initializing the connector

To use the Salesforce Wave Analytics connector, add the <salesforcewaveanalytics.init> element in your configuration before carrying out any other Salesforce Wave Analytics operation.

Add the following <salesforcewaveanalytics.init> method in your configuration:
 
#### init
```xml
 <salesforcewaveanalytics.init>
      <accessToken>{$ctx:accessToken}</accessToken>
      <apiUrl>{$ctx:apiUrl}</apiUrl>
      <clientId>{$ctx:clientId}</clientId>
      <clientSecret>{$ctx:clientSecret}</clientSecret>
      <refreshToken>{$ctx:refreshToken}</refreshToken>
      <hostName>{$ctx:hostName}</hostName>
      <apiVersion>{$ctx:apiVersion}</apiVersion>
      <registryPath>{$ctx:registryPath}</registryPath>
      <intervalTime>{$ctx:intervalTime}</intervalTime>
 </salesforcewaveanalytics.init>
```
**Properties** 
* apiVersion:  The version of the Salesforce API. 
* accessToken:  The access token to authenticate your API calls.
* apiUrl:  The instance URL for your organization.
* hostName:  SalesforceOAuth endpoint when issuing authentication requests in your application.
* refreshToken:  The refresh token that you received to refresh the API access token.
* clientId:  The consumer key of the connected application that you created.
* clientSecret:  The consumer secret of the connected application that you created.
* intervalTime:  The time interval in milliseconds, after which you need to check the validity of the access token.
* registryPath:  The registry path of the connector. You must specify the registry path as follows: registryPath = “connectors/salesforcewaveanalytics”.

**Sample Request**

Following is a sample REST request that can be handled by the init operation.

```json
{
  "clientId": "3MVG9ZL0ppGP5UrBztM9gSLYyUe7VwAVhD9.yQnZX2mmCu_48Uwc._doxrBTgY4jqmOSDhxRAiUBf8gCr2mk7",
  "refreshToken": "5Aep861TSESvWeug_ztpnAk6BGQxRdovMLhHso81iyYKO6hTm6kHoL4.YfwIi9cHLwga.pPTsTuJlmKjo05x.o.",
  "clientSecret": "1187341468789253319",
  "hostName": "https://login.salesforce.com",
  "apiVersion": "v39.0",
  "registryPath":"connectors/salesforcewaveanalytics",
  "accessToken":"00D280000017q6q!AQoAQOeXcp7zKo3gUdy6r064_LsJ5bYYrUn_qAZG9TtKFLPfUMRxiato.E162_2XAtCTZLFQTbNk2Rz6Zm_juSakFE_aaBPp",
  "intervalTime" : "100000",
  "apiUrl":"https://ap2.salesforce.com"
}
```

**Related  documentation**

[https://developer.salesforce.com/docs/atlas.en-us.api_rest.meta/api_rest/intro_understanding_web_server_oauth_flow.htm](https://developer.salesforce.com/docs/atlas.en-us.api_rest.meta/api_rest/intro_understanding_web_server_oauth_flow.htm)



Now that you have connected to Salesforce, use the information in the following topics to perform various operations with the connector.

[Working with Annotations](annotations.md)

[Working with Wave](wave.md)

[Working with Dataset](datasets.md)

[Working with Dashboard](dashboard.md)

[Working with Folder](folder.md)

[Working with Lense](lense.md)

[Working with Template](template.md)

[Working with query](query.md)

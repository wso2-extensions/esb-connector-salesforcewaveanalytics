# Working with Template

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview 

The following operations allow you to work with listTemplate, for the current organization. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with listTemplate, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [listTemplate](#returns-the-collection-of-the-templates)    | Returns the collection of the templates. |

### Operation details

This section provides more details on each of the operations.

#### Returns the collection of the templates
To return the collection of the templates, use salesforcewaveanalytics.listTemplate and specify the following property.

**listItemsInMenu**
```xml
 <salesforcewaveanalytics.listTemplate>
       <type>{$ctx:type}</type>
</salesforcewaveanalytics.listTemplate>
```

**Properties**
* type: The type of the template.

**Sample request**

Following is a sample request that can be handled by the listTemplate operation.

```json
{
  "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
  "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPOOKxsV_3lDwKwTzBz2pGXcuHtmd.D7ZISnDg_AD",
  "clientSecret": "5478649612867397870",
  "hostName": "https://login.salesforce.com",
  "apiVersion": "v39.0",
  "registryPath":"connectors/salesforcewaveanalytics",
  "accessToken":"00D0o0000016avV!AQYAQMndEofSnH8XffbB_X7Eli8WF7_3cCa3WkP1tv8tp5iy2CFQIpgbK9FKdttS9._VbyZqM0p8vUNDf3.eu1yEanJd2j6o",
  "intervalTime" : "100000",
  "apiUrl":"https://ap8.salesforce.com",
  "type":"app"
}
```
**Sample response**

Given below is a sample response for the listTemplate operation.

```json
{
    "templates": [
        {
            "assetIcon": "12.png",
            "assetVersion": 43,
            "configurationUrl": "/services/data/v39.0/wave/templates/sfdc_internal__ApprovalAnalytics/configuration",
            "description": "The Salesforce Approval Analytics Template will give managers and leaders more visibility into approval process and identify bottlenecks. v1.0 #041",
            "folderSource": null,
            "id": "sfdc_internal__ApprovalAnalytics",
            "label": "Approval Analytics",
            "name": "ApprovalAnalytics",
            "namespace": "sfdc_internal",
            "releaseInfo": {
                "notesUrl": "/services/data/v39.0/wave/templates/sfdc_internal__ApprovalAnalytics/releasenotes",
                "templateVersion": "1.0"
            },
            "templateIcon": "Approval.jpg",
            "templateType": "app",
            "url": "/services/data/v39.0/wave/templates/sfdc_internal__ApprovalAnalytics"
        },.....
 }
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_templates.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_templates.htm)

### Sample configuration

Following example illustrates how to connect to Salesforce with the init operation and listTemplate operation.

1. Create a sample proxy as below :

    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="listTemplate"
           startOnLoad="true"
           statistics="disable"
           trace="disable"
           transports="http,https">
        <target>
            <inSequence>
                <property expression="json-eval($.accessToken)" name="accessToken"/>
                <property expression="json-eval($.apiVersion)" name="apiVersion"/>
                <property expression="json-eval($.hostName)" name="hostName"/>
                <property expression="json-eval($.refreshToken)" name="refreshToken"/>
                <property expression="json-eval($.clientSecret)" name="clientSecret"/>
                <property expression="json-eval($.clientId)" name="clientId"/>
                <property expression="json-eval($.apiUrl)" name="apiUrl"/>
                <property expression="json-eval($.registryPath)" name="registryPath"/>
                <property expression="json-eval($.type)" name="type"/>
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
                    <timeout>120000</timeout>
                </salesforcewaveanalytics.init>
                <salesforcewaveanalytics.listTemplate>
                    <type>{$ctx:type}</type>
                </salesforcewaveanalytics.listTemplate>
                <send/>
            </inSequence>
        </target>
        <description/>
    </proxy>
    ```

2. Create a json file named listTemplate.json and copy the configurations given below to it:

    ```json
    {
      "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
      "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPOOKxsV_3lDwKwTzBz2pGXcuHtmd.D7ZISnDg_AD",
      "clientSecret": "5478649612867397870",
      "hostName": "https://login.salesforce.com",
      "apiVersion": "v39.0",
      "registryPath":"connectors/salesforcewaveanalytics",
      "accessToken":"00D0o0000016avV!AQYAQMndEofSnH8XffbB_X7Eli8WF7_3cCa3WkP1tv8tp5iy2CFQIpgbK9FKdttS9._VbyZqM0p8vUNDf3.eu1yEanJd2j6o",
      "intervalTime" : "100000",
      "apiUrl":"https://ap8.salesforce.com",
      "type":"app"
    }                       
    ```
3. Replace the values according to your setup.

4. Execute the following curl command:
    ```bash
      curl -X POST http://localhost:8280/services/listTemplate --header 'Content-Type: application/json' -d @listTemplate.json
    ```

5. Salesforce returns a json response similar to the one shown below:
 
```json
{
    "templates": [
        {
            "assetIcon": "12.png",
            "assetVersion": 43,
            "configurationUrl": "/services/data/v39.0/wave/templates/sfdc_internal__ApprovalAnalytics/configuration",
            "description": "The Salesforce Approval Analytics Template will give managers and leaders more visibility into approval process and identify bottlenecks. v1.0 #041",
            "folderSource": null,
            "id": "sfdc_internal__ApprovalAnalytics",
            "label": "Approval Analytics",
            "name": "ApprovalAnalytics",
            "namespace": "sfdc_internal",
            "releaseInfo": {
                "notesUrl": "/services/data/v39.0/wave/templates/sfdc_internal__ApprovalAnalytics/releasenotes",
                "templateVersion": "1.0"
            },
            "templateIcon": "Approval.jpg",
            "templateType": "app",
            "url": "/services/data/v39.0/wave/templates/sfdc_internal__ApprovalAnalytics"
        },.....
 }
```

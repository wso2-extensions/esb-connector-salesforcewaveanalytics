# Working with Lense operation

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview 

The following operations allow you to work with Lense, for the current organization. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with listLense, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [listLense](#returns-the-list-of-lenses)    | Returns the list of lenses. |

### Operation details

This section provides more details on each of the operations.

#### Returns the list of lenses
To return the list of lense, use salesforcewaveanalytics.listLense and specify the following property.

**listLense**
```xml
<salesforcewaveanalytics.listLense>
     <folderId>{$ctx:folderId}</folderId>
     <scope>{$ctx:scope}</scope>
     <page>{$ctx:page}</page>
     <pageSize>{$ctx:pageSize}</pageSize>
     <q>{$ctx:q}</q>
     <sort>{$ctx:sort}</sort>
 </salesforcewaveanalytics.listLense>
```

**Properties**
* folderId: The Id of the Folder.
* scope: Type of scope to be applied to a collection resource representation.
* page: A generated token that indicates the view of the folders to be returned.
* pageSize: Number of items to be returned in a single page. Minimum is 1, maximum is 200, and default is 25.
* q: Search terms.
* sort: Property names that can be sorted.

**Sample request**

Following is a sample request that can be handled by the listLense operation.

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
  "folderId":"00l0o000002AC91AAG"
}
```
**Sample response**

Given below is a sample response for the listLense operation.

```json
{
    "lenses": [],
    "nextPageUrl": null,
    "totalSize": 0,
    "url": "/services/data/v39.0/wave/lenses"
}
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_lenses.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_lenses.htm)

### Sample configuration

Following example illustrates how to connect to Salesforce with the init operation and listLense operation.

1. Create a sample proxy as below :

    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="listLense"
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
                <property expression="json-eval($.intervalTime)" name="intervalTime"/>
                <property expression="json-eval($.isPinned)" name="folderId"/>
                <property expression="json-eval($.page)" name="hasCurrentOnly"/>
                <property expression="json-eval($.pageSize)" name="pageSize"/>
                <property expression="json-eval($.q)" name="q"/>
                <property expression="json-eval($.sort)" name="sort"/>
                <property expression="json-eval($.scope)" name="scope"/>
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
                <salesforcewaveanalytics.listLense>
                    <folderId>{$ctx:folderId}</folderId>
                    <scope>{$ctx:scope}</scope>
                    <page>{$ctx:page}</page>
                    <pageSize>{$ctx:pageSize}</pageSize>
                    <q>{$ctx:q}</q>
                    <sort>{$ctx:sort}</sort>
                </salesforcewaveanalytics.listLense>
                <send/>
            </inSequence>
        </target>
        <description/>
    </proxy>
    
    ```

2. Create a json file named listLense.json and copy the configurations given below to it:

    ```json
    {
       "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
      "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPOOKxsV_3lDwKwTzBz2pGXcuHtmd.D7ZISnDg_AD",
      "clientSecret": "5478649612867397870",
      "hostName": "https://login.salesforce.com",
      "apiVersion": "v39.0",
      "registryPath":"connector/salesforcewaveanalytics",
      "accessToken":"00D0o0000016avV!AQYAQMndEofSnH8XffbB_X7Eli8WF7_3cCa3WkP1tv8tp5iy2CFQIpgbK9FKdttS9._VbyZqM0p8vUNDf3.eu1yEanJd2j6o",
      "intervalTime" : "100000",
      "apiUrl":"https://ap8.salesforce.com",
      "folderId":"00l0o000002AC91AAG"
    }                  
    ```
3. Replace the values according to your setup.

4. Execute the following curl command:
    ```bash
      curl -X POST http://localhost:8280/services/listLense --header 'Content-Type: application/json' -d @listLense.json
    ```

5. Salesforce returns a json response similar to the one shown below:
 
```json
{
    "lenses": [],
    "nextPageUrl": null,
    "totalSize": 0,
    "url": "/services/data/v39.0/wave/lenses"
}
```

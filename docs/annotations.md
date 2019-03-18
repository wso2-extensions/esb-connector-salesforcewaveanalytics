# Working with Annotations

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview 

The following operations allow you to work with listAnnotations, for the current organization. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with listAnnotations, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [listAnnotations](#retrieving-a-list-of-annotations)    | Retrieves a list of annotations. |


### Operation details

This section provides more details on each of the operations.

#### retrieving-a-list-of-annotations
To retrieve the list of annotations. listAnnotations specify the following property.

**listAnnotations**
```xml
<salesforcewaveanalytics.listAnnotations>
     <assetId>{$ctx:assetId}</assetId>
</salesforcewaveanalytics.listAnnotations>
```

**Properties**
* assetId: The Id of the asset.

**Sample request**

Following is a sample request that can be handled by the listAnnotation operation.

```json
{
  "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
    "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPONbHgix4zD5rvoMxmCtonNdOfabXKmY4PujXuim",
    "clientSecret": "5478649612867397870",
    "hostName": "https://login.salesforce.com",
    "apiVersion": "v36.0",
    "registryPath":"connectors/salesforcewaveanalytics",
    "accessToken":"00D0o0000016avV!AQYAQFTaqe4NeMl5FVlTVBcUTrkvG0XjDpbdt7q14cdtSmqdz9LtZMazheD.rLmUL0bLptNRJ_OGejzl9ns_O2PHGL.xtO5F",
    "intervalTime" : "100000",
    "apiUrl":"https://ap8.salesforce.com",
    "assetId":"0FK0o000000LTbVGAW"
}
```
**Sample response**

Given below is a sample response for the listAnnotations operation.

```json
{"annotations": [],"feedSubject": {"id": "0LY0o000000Y04WGAS","url": "/services/data/v37.0/chatter/records/0LY0o000000Y04WGAS"
    },"url": "/services/data/v37.0/wave/annotations?assetId=0FK0o000000LTbVGAW"}
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_annotations.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_annotations.htm)

### Sample configuration

Following example illustrates how to connect to Salesforce with the init operation and listAnnotations operation.

1. Create a sample proxy as below :
    
    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="listAnnotations"
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
                <property expression="json-eval($.assetId)" name="assetId"/>
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
                <salesforcewaveanalytics.listAnnotations>
                    <assetId>{$ctx:assetId}</assetId>
                </salesforcewaveanalytics.listAnnotations>
                <send/>
            </inSequence>
        </target>
        <description/>
    </proxy>
    
    ```

2. Create a json file named listAnnotation.json and copy the configurations given below to it:

    ```json
    {
        "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
        "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPONbHgix4zD5rvoMxmCtonNdOfabXKmY4PujXuim",
        "clientSecret": "5478649612867397870",
        "hostName": "https://login.salesforce.com",
        "apiVersion": "v36.0",
        "registryPath":"connectors/salesforcewaveanalytics",
        "accessToken":"00D0o0000016avV!AQYAQFTaqe4NeMl5FVlTVBcUTrkvG0XjDpbdt7q14cdtSmqdz9LtZMazheD.rLmUL0bLptNRJ_OGejzl9ns_O2PHGL.xtO5F",
        "intervalTime" : "100000",
        "apiUrl":"https://ap8.salesforce.com",
        "assetId":"0FK0o000000LTbVGAW"
    }                       
    ```
3. Replace the values according to your setup.

4. Execute the following curl command:
      ```bash
      curl -X POST http://localhost:8280/services/listAnnotation --header 'Content-Type: application/json' -d @listAnnotation.json
      ```

5. Salesforce returns a json response similar to the one shown below:
 
```json
{
    "annotations": [],
    "feedSubject": {
        "id": "0LY0o000000Y04WGAS",
        "url": "/services/data/v37.0/chatter/records/0LY0o000000Y04WGAS"
    },
    "url": "/services/data/v37.0/wave/annotations?assetId=0FK0o000000LTbVGAW"
}
```

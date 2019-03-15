# Working with query

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview 

The following operations allow you to work with query, for the current organization. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with query, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [query](#executes-a-query-written-in-Salesforce-Analytics-Query-Language)    | Executes a query written in Salesforce Analytics Query Language. |

### Operation details

This section provides more details on each of the operations.

#### Executes a query written in Salesforce Analytics Query Language
To execute a query written in Salesforce Analytics Query Language, use salesforcewaveanalytics.query and specify the following property.

**query**
```xml
<salesforcewaveanalytics.query>
      <query>{$ctx:query}</query>
</salesforcewaveanalytics.query>
```

**Properties**
* query: The query, in JSON format.

**Sample request**

Following is a sample request that can be handled by the query operation.

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
  "query":"q = load \"0Fb0o000000PEGACA4/0Fc0o000000RZh5CAG\";q = group q by 'FirstName';q = foreach q generate 'FirstName' as 'FirstName', count() as 'count';q = limit q 2000;"
 }
```
**Sample response**

Given below is a sample response for the query operation.

```json
{
  "action":"query",
  "responseId":"3vy-E9YmX-TIWe0769juD-",
  "results": {
    "records":[
      {"FirstName":"","count":1},
      {"FirstName":"Admin","count":1},
      {"FirstName":"Integration","count":1},
      {"FirstName":"Security","count":1}
    ]
  },
  "query":"q = load \"0Fbxx0000000006CAA/0Fcxx000000001dCAA\";
           q = group q by 'FirstName';
           q = foreach q generate 'FirstName' as 'FirstName', count() as 'count';
           q = limit q 2000;",
  "responseTime":544
}

```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_query.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_query.htm)

### Sample configuration

Following example illustrates how to connect to Salesforce with the init operation and query operation.

1. Create a sample proxy as below :

```xml
<proxy xmlns="http://ws.apache.org/ns/synapse"
       name="query"
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
            <property expression="json-eval($.query)" name="query"/>
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
            <salesforcewaveanalytics.query>
                <query>{$ctx:query}</query>
            </salesforcewaveanalytics.query>
            <send/>
        </inSequence>
    </target>
    <description/>
</proxy>
```

2. Create a json file named query.json and copy the configurations given below to it:

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
  "query":"q = load \"0Fb0o000000PEGACA4/0Fc0o000000RZh5CAG\";q = group q by 'FirstName';q = foreach q generate 'FirstName' as 'FirstName', count() as 'count';q = limit q 2000;"
 }                
```
3. Replace the credentials with your values.

4. Execute the following curl command:
```bash
  curl -X POST http://nirudikaa-ThinkPad-T530:8280/services/query --header 'Content-Type: application/json' -d @query.json
```

5. Salesforce returns a json response similar to the one shown below:
 
```json
{
  "action":"query",
  "responseId":"3vy-E9YmX-TIWe0769juD-",
  "results": {
    "records":[
      {"FirstName":"","count":1},
      {"FirstName":"Admin","count":1},
      {"FirstName":"Integration","count":1},
      {"FirstName":"Security","count":1}
    ]
  },
  "query":"q = load \"0Fbxx0000000006CAA/0Fcxx000000001dCAA\";
           q = group q by 'FirstName';
           q = foreach q generate 'FirstName' as 'FirstName', count() as 'count';
           q = limit q 2000;",
  "responseTime":544
}

```

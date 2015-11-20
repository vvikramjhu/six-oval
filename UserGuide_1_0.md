# <font color='#0044CC'>Introduction</font> #

This document will assist you in installing and using
the SIX OVAL features.


## <font color='#0044CC'>Installation</font> ##

Put the SIX OVAL JAR and dependent JAR files
in the Java classpath.
Consult the [release note](ReleaseNotes.md)
for finding the dependent components.


## <font color='#0044CC'>Examples</font> ##

You can find some examples,
which are shown in this page,
in the
[source code repository](https://code.google.com/p/six-oval/source/browse/#svn/trunk/src/test/java/jp/go/aist/six/test/oval/example).




---

# <font color='#0044CC'>Domain Model</font> #

See
[Domain Model document](DomainModel_1_0.md).
Also, for the OVAL families and components supported,
refer to the [release note](ReleaseNotes.md).





---

# <font color='#0044CC'>Object-XML Mapping</font> #

This feature supports marshalling/unmarshalling
of Java objects.
That is, it is possible to serialize/deserialize
the OVAL model objects to/from OVAL XML documents
in a few steps.


Listing 1 shows how to build domain model objects
from an XML input document
and to generate an XML output document from objects.

```
// Listing 1: Unmarshalling/Marshalling (Local File)

import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.util.xml.XmlMapper;
.....

XmlMapper  xml_mapper = OvalContext.getInstance().getXmlMapper();

String  local_src = "definitions.xml";
File  src_file = new File( local_src );
Object  obj1 = xml_mapper.unmarshal( new FileInputStream( src_file ) );
System.out.println( obj1 );
xml_mapper.marshal( obj1, System.out );

    /* type-safe method, may throw ClassCastException */
OvalDefinitions  oval_defs1 = xml_mapper.unmarshal( new FileInputStream( src_file ), OvalDefinitions.class );
```


Listing 2 shows how to read an XML document
from a network resource, i.e. URL.
Then, the object is serialized to a file.

```
// Listing 2: Unmarshalling (Network Resource)

String  network_src = "http://oval.mitre.org/repository/data/DownloadDefinition?"
                     + "id=oval%3aorg.mitre.oval%3adef%3a12541";
URL  src_url = new URL( network_src );
Object  obj2 = xml_mapper.unmarshal( src_url.openStream() );
System.out.println( obj2 );
File  dst_file = new File( "oval-def-example.xml" );
xml_mapper.marshal( obj2, new FileOutputStream( dst_file ) );

    /* type-safe method, may throw ClassCastException */
OvalDefinitions  oval_defs2 = xml_mapper.unmarshal( src_url.openStream(), OvalDefinitions.class );
```


Several variant unmarshal and marshal methods
are defined in XmlMapper.
Listing 3 shows the method signatures.

```
// Listing 3: XmlMapper Interface

Object unmarshal(java.xml.transform.Source source)
Object unmarshal(java.io.Reader reader)
Object unmarshalFromString(java.lang.String xml)

<T> T unmarshal(java.xml.transform.Source source, java.lang.Class<T> type)
<T> T unmarshal(java.io.Reader reader, java.lang.Class<T> type)
<T> T unmarshalFromString(java.lang.String xml, java.lang.Class<T> type)

void marshal(Object obj, javax.xml.transform.Result result)
void marshal(Object obj, java.io.OutputStream result)
void marshal(Object obj, java.io.Writer result)
String marshalToString(Object obj)
```



---

# <font color='#0044CC'>Object Repository</font> #

This feature supports persistent storage
for the OVAL domain model.
That is, it is possible to save/load the Java objects
to/from a persistent storage, and to retrieve the objects
in a programmatic way.

In this version, we use
[MongoDB](http://www.mongodb.org/)
as a the internal storage system.
MongoDB is a kind of document-oriented database or
NoSQL, so-called.

The reasons why we abandoned relational databases are:
  * the schema of the OVAL data model is evolving and multiple versions should be co-exist,
  * the model contains many subclasses derived from the same abstract class to represent platform dependent data,
  * and the model contains a composit pattern, sometimes called as self-referring structure, of arbitrary repetitions.


## <font color='#0044CC'>Database Setup and Configuration</font> ##

Before using the object persistence feature,
you must install the MongoDB and set up the database.
Please refer to our [step-by-step guide](MongoDB.md)
and the original
[MongoDB  Installation Guides](http://www.mongodb.org/display/DOCS/Quickstart).

You may need to run the MongoDB server
with access control functionality.
In this guide, we assume that the server's _secure mode_
is enabled with "--auth" option and
applications need the user name and password
to access the database.
For further details on security settings,
read the above step-by-step guide and the original
[Security and Authentication](http://www.mongodb.org/display/DOCS/Security+and+Authentication) document.


In applications,
several configuration parameters must be set
to get the right access to the database.
Listing 4 shows the default Java property values.
Users can override these values to reflect
the database settings.
This is done with the Java properties file
named "six-oval.properties".
This file name can't be changed but located in
any directory in the Java CLASSPATH.
Listing 5 shows example overriding values.


```
# Listing 4: Default Java properties

six.oval.repository.database.host      =localhost
six.oval.repository.database.port      =27017
six.oval.repository.database.name      =oval
six.oval.repository.database.username  =six
six.oval.repository.database.password  =six
```

```
# Listing 5: Overriding Java properties (six-oval.properties in CLASSPATH)

six.oval.repository.database.name      =ovalrepo
six.oval.repository.database.username  =foo
six.oval.repository.database.password  =bar
```



## <font color='#0044CC'>CRUD Operations</font> ##

OvalDatabase interface defines
the low-level persistent storage operations
for the OVAL Domain Model objects.
Listing 6 shows an example to store and load
an OVAL Definitions document and the element Definitions.

```
// Listing 6: Save and Load Operations

import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.OvalServerContext;
import jp.go.aist.six.oval.repository.OvalDatabase;
import jp.go.aist.six.util.xml.XmlMapper;
.....

OvalServerContext  context = OvalContext.getServerInstance();

    /* Unmarshal XML document */
XmlMapper  xml_mapper = context.getXmlMapper();
String  local_src = "definitions.xml";
File  src_file = new File( local_src );
OvalDefinitions  oval_defs = xml_mapper.unmarshal( new FileInputStream( src_file ), OvalDefinitions.class );

    /* Save OVAL Definition document */
OvalDatabase  db = context.getDatabase();
String  id = db.save( OvalDefinitions.class, oval_defs );
System.out.println( "whole OVAL Definitions document is saved: id=" + id );

    /* Load Definitions */
for (DefinitionType  def : oval_defs.getDefinitions().getDefinition()) {
    String  def_id = def.getOvalId();
    System.out.println( "finding Definition: id=" + def_id );
    DefinitionType  p_def = db.findById( DefinitionType.class, def_id );
    System.out.println( p_def );
}
```



## <font color='#0044CC'>Queries</font> ##

Listing 7 shows example queries for the OVAL Database.
Refer to the
[query parameters document](RepositoryQueryParameters_1_0.md)
for details.

```
// Listing 7: Queries

    /* keyword in "title" or "description" */
DefinitionQueryParams  params04 = new DefinitionQueryParams();
params04.setSearchTerms( "XSS" );
params04.setOrder( "id" );
params04.setCount( "10" );

    /* Definition IDs */
DefinitionQueryParams  params13 = new DefinitionQueryParams();
params13.setId( "oval:org.mitre.oval.test:def:121,oval:org.mitre.oval.test:def:140" );

    /* definition class */
DefinitionQueryParams  params20 = new DefinitionQueryParams();
params20.setDefinitionClass( "compliance" );

    /* affected platforms */
DefinitionQueryParams  params32 = new DefinitionQueryParams();
params32.setPlatform( "Microsoft Windows XP*,Microsoft Windows 7*" );

    /* affected products */
DefinitionQueryParams  params41 = new DefinitionQueryParams();
params41.setProduct( "Mozilla Firefox,Mozilla Thunderbird" );

    /* CVE IDs */
DefinitionQueryParams  params62 = new DefinitionQueryParams();
params62.setCve( "CVE-2011-*,CVE-2010-0176" );

DefinitionQueryParams[]  params_list = new DefinitionQueryParams[] {
    params04, params13, params20, params32, params41, params62
};

    /* Execute Queries */
OvalDatabase  db = OvalContext.getServerInstance().getDatabase();
for (DefinitionQueryParams  params : params_list) {
    System.out.println( "searches Definitions: query params=" + params );
    List<DefinitionType>  p_def_list = db.find( DefinitionType.class, params );
    System.out.println( "#Definitions found: " + p_def_list.size() );
    for (DefinitionType  p_def : p_def_list) {
        System.out.println( "result Definition: " + p_def );
    }
}
```



## <font color='#0044CC'>High-Level Interface</font> ##

OvalDefinitionRepository and OvalResultRepository
define higher level interfaces.
The methods does NOT have arguments to specify Java types.
Instead, the types of objects are indicated by method names.
For example, Listing 8 shows a comparison of
OvalDefinitionRepository and OvalDatabase,
a low-level interface.


```
// Listing 8: High- and Low-Level Interfaces.

    /* High-Level */
public interface OvalDefinitionRepository
{
    public DefinitionType findDefinitionById( String oval_id );
    .....
    public QueryResults<DefinitionType> findDefinition( QueryParams params );
}

    /* Low-Level (just for comparison) */
public interface OvalDatabase
{
    public <K, T extends Persistable<K> & OvalObject> T findById( Class<T> type, K id );
    .....
    public <K, T extends Persistable<K> & OvalObject> List<T> find( Class<T> type, QueryParams params );
}
```



---

# <font color='#0044CC'>Web Services</font> #

This feature supports Web-based OVAL repository services.
That is, it is possible to access remote OVAL repository
from Java applications.



## <font color='#0044CC'>Web Application Setup</font> ##

Before using this Web services feature,
you must set up a servlet container like
[Tomcat](http://tomcat.apache.org/).
Here, we don't describe how to install it.

Deployment of our Web application is easy;
just put the _WAR file_ on the appropriate path
indicated by the container.
For example, if you use Tomcat,
copy the WAR file to "$CATALINA\_BASE/webapps".


If you need to configure the Java properties
to access the database,
configure the properties file,
"six-oval.properties" as described above,
in the application's context;
e.g. "$CATALINA\_BASE/webapps/six-oval/WEB-INF"
in case of Tomcat.


## <font color='#0044CC'>REST API</font> ##

Here, we show some examples.
Please refer to the
[Web Services document](WebServices_1_0.md)
for details.


Figure 1 shows an example call to the API using
[curl](http://curl.haxx.se/).
Here, a Definition is retrieved using its OVAL ID;
"oval:org.mitre.oval.test:def:165".


> <b>Figure 1</b>: Web Services invocation using curl.
![http://staff.aist.go.jp/nakamura-akihito/six/oval/version-0_7_0/six-oval-070_ws-get-definition.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/version-0_7_0/six-oval-070_ws-get-definition.png)


Listing 9 shows the same service invocation
from Java code.
The details of the service invocations are hidden
from programmers.

```
// Listing 9: Web Services invocation from Java.

import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.repository.OvalRepository;
.....

    /* Find Definition by ID */
String  def_id = "oval:org.mitre.oval.test:def:165";
System.out.println( "*** finding Definition: " + def_id );
OvalRepository  repository = OvalContext.getInstance().getRepository();
DefinitionType  def = repository.findDefinitionById( def_id );
System.out.println( "*** found Definition: " + def );
```


Listing 10 shows the Java configuration properties.

```
// Listing 10: Web Services properties (six-oval.properties in CLASSPATH).

six.oval.repository.web.base-url = https://foo.bar.org:8080/six-oval/repository
#six.oval.repository.web.base-url = http://localhost:8080/six-oval/repository  #default

```




---

# <font color='#0044CC'>Interpreter Driving</font> #

We don't intend to develop an OVAL Interpreter.
Instead, we use existing one, ovaldi, and
provide a simple _proxy_ class in Java to drive it.

There two wrappers; simple and networking.
The simple proxy is just an ovaldi launcher.
The networking proxy extends the local file-based
input/output of ovaldi to URI-based ones.
That is, it is possible to obtain the OVAL Definitions
from a network location and submit the OVAL Results
to a remote location.



## <font color='#0044CC'>Configuration</font> ##

Listing 11 shows the default Java configuration properties
for ovaldi.
There are two properties; "ovaldi.path" and "ovaldi.workdir".
The former specifies the path to the ovaldi executable file
and the latter gives the working directory
of the ovaldi process.
The default value for the working directory is null,
which means to use the working directory
of the current Java process.

```
// Listing 11: Default ovaldi configuration properties.

ovaldi.path     = ovaldi
#ovaldi.workdir = 
```


Listing 12 shows an example overriding
configuration properties.
In this case, the platform is Windows and
"ovaldi.exe" binary is located in "C:" drive.

```
// Listing 12: Overriding ovaldi configuration properties (six-oval.properties in CLASSPATH).

ovaldi.path = C:\\app\\ovaldi-5.10.1.2-x64\\ovaldi.exe
```



## <font color='#0044CC'>Simple Proxy</font> ##

Listing 13 shows how to launch ovaldi from Java
with command options.
In this case, "definitions.xml" file in current working
directory is used as the input OVAL Definition document,
and default output file names are used.
Note that the ovaldi executable path is given
by the properties file as described above.


```
// Listing 13: Simple Proxy

import jp.go.aist.six.oval.interpreter.Options;
import jp.go.aist.six.oval.core.interpreter.OvaldiOption;
import jp.go.aist.six.oval.core.interpreter.OvaldiProxy;
.....

Options  options = new Options();
options.set( OvaldiOption.NO_VERIFY )
       .set( OvaldiOption.OVAL_XML_DIR, "C:\\app\\ovaldi-5.10.1.2-x64\\xml" );

OvaldiProxy  ovaldi = new OvaldiProxy( options );
int  exit_value = ovaldi.execute();
System.out.println( "ovaldi exit value: " + exit_value );
```



## <font color='#0044CC'>Networking Proxy</font> ##

Listing 14 shows how to configure the network
locations of input and output resources.
If you have set up the above Web-Services,
it is possible to store the OVAL Results
from various managed node
at the centralized result repository.

```
// Listing 14: Networking Proxy

import jp.go.aist.six.oval.core.interpreter.NetworkingOvaldiProxy;
.....

Options  options = new Options();
options.set( OvaldiOption.NO_VERIFY )
       .set( OvaldiOption.OVAL_XML_DIR, "C:\\app\\ovaldi-5.10.1.2-x64\\xml" )
       .set( OvaldiOption.OVAL_DEFINITIONS, 
             "http://oval.mitre.org/repository/data/DownloadDefinition?id=oval%3aorg.mitre.oval%3adef%3a12541" );
//     .set( OvaldiOption.OVAL_RESULTS, 
//           "http://localhost:8080/six-oval/repository/oval_results" );

NetworkingOvaldiProxy  ovaldi = new NetworkingOvaldiProxy( options );
int  exit_value = ovaldi.execute();

```




---
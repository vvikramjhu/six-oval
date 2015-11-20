# <font color='#0044CC'>Introduction</font> #

In this document, we show the details
of SIX OVAL Web services.
In this version, 1.0,
we provide only the _repository services_.



## <font color='#0044CC'>REST API</font> ##
The main parts of REST-style Web services are
resource models, identifiers of the resources,
representation of the resources, and
interaction models.

The OVAL resource model is well-defined in
[the OVAL Language specification](http://oval.mitre.org/language/).
Currently, XML is one and only
standardized resource representation format
of the OVAL resources.
Therefore, it is natural
that we adopt these model and representation format.

Below, we describe the resource identifier design with URIs
and interaction design with HTTP requests and responses.
Please note that only distinctive HTTP headers
are listed.




---

# <font color='#0044CC'>Repository Services</font> #

The OVAL repository is a persistent storage
which contains the OVAL resources.
The repository services provide REST APIs
to access the repository with HTTP.


Suppose that the base URI of the service is
denoted as `$REPO_BASE`;
e.g. `http://foo.org/six-oval/repository`.


## <font color='#0044CC'>Definition Resources</font> ##

| **Operation** | **HTTP Method** | **URI Path** | **Request Headers** | **Request Body** | **Response Headers** | **Response Body** |
|:--------------|:----------------|:-------------|:--------------------|:-----------------|:---------------------|:------------------|
| Find by ID    | GET             | `/definitions/{id}` | `Accept: application/xml` | -                | `200 OK`<br><code>Content-Type: application/xml</code> <table><thead><th> <code>oval-def:definition</code> </th></thead><tbody>
<tr><td> Find all      </td><td> GET             </td><td>  <code>/definitions</code> </td><td> <code>Accept: application/xml</code> </td><td> -                </td><td> <code>200 OK</code><br><code>Content-Type: application/xml</code> </td><td> <code>six-oval:query_results</code> </td></tr>
<tr><td> Query         </td><td> GET             </td><td>  <code>/definitions?{query}</code> </td><td> <code>Accept: application/xml</code> </td><td> -                </td><td> <code>200 OK</code><br><code>Content-Type: application/xml</code> </td><td> <code>six-oval:query_results</code> </td></tr></tbody></table>


<h2><font color='#0044CC'>Element Resources: Definition, Test, Object, State, and Variable</font></h2>
T.B.D.<br>
<br>
<br>
<h2><font color='#0044CC'>Oval Definitions Document Resources</font></h2>

<table><thead><th> <b>Operation</b> </th><th> <b>HTTP Method</b> </th><th> <b>URI Path</b> </th><th> <b>Request Headers</b> </th><th> <b>Request Body</b> </th><th> <b>Response Headers</b> </th><th> <b>Response Body</b> </th></thead><tbody>
<tr><td> Find by ID       </td><td> GET                </td><td> <code>/oval_definitions/{id}</code> </td><td> <code>Accept: application/xml</code> </td><td> -                   </td><td> <code>200 OK</code><br><code>Content-Type: application/xml</code> </td><td> <code>oval-def:oval_definitions</code> </td></tr>
<tr><td> Find all         </td><td> GET                </td><td>  <code>/oval_definitions</code> </td><td> <code>Accept: application/xml</code> </td><td> -                   </td><td> <code>200 OK</code><br><code>Content-Type: application/xml</code> </td><td> <code>six-oval:query_results</code> </td></tr>
<tr><td> Query            </td><td> GET                </td><td>  <code>/oval_definitions?{query}</code> </td><td> <code>Accept: application/xml</code> </td><td> -                   </td><td> <code>200 OK</code><br><code>Content-Type: application/xml</code> </td><td> <code>six-oval:query_results</code> </td></tr>
<tr><td> Create           </td><td> POST               </td><td> <code>/oval_definitions</code> </td><td> <code>Content-Type: application/xml</code> </td><td> <code>oval-def:oval_definitions</code> </td><td> <code>201 Created</code><br><code>Location: {URI}</code> </td><td> -                    </td></tr></tbody></table>


<h2><font color='#0044CC'>Oval System Characteristics Document Resources</font></h2>
T.B.D.<br>
<br>
<table><thead><th> <b>Operation</b> </th><th> <b>HTTP Method</b> </th><th> <b>URI Path</b> </th><th> <b>Request Headers</b> </th><th> <b>Request Body</b> </th><th> <b>Response Headers</b> </th><th> <b>Response Body</b> </th></thead><tbody>
<tr><td> Find by ID       </td><td> GET                </td><td> <code>/oval_scs/{id}</code> </td><td> <code>Accept: application/xml</code> </td><td> -                   </td><td> <code>200 OK</code><br><code>Content-Type: application/xml</code> </td><td> <code>oval-sc:oval_system_characteristics</code> </td></tr>
<tr><td> Find all         </td><td> GET                </td><td>  <code>/oval_scs</code> </td><td> <code>Accept: application/xml</code> </td><td> -                   </td><td> <code>200 OK</code><br><code>Content-Type: application/xml</code> </td><td> <code>six-oval:query_results</code> </td></tr>
<tr><td> Query            </td><td> GET                </td><td>  <code>/oval_scs?{query}</code> </td><td> <code>Accept: application/xml</code> </td><td> -                   </td><td> <code>200 OK</code><br><code>Content-Type: application/xml</code> </td><td> <code>six-oval:query_results</code> </td></tr>
<tr><td> Create           </td><td> POST               </td><td> <code>/oval_scs</code> </td><td> <code>Content-Type: application/xml</code> </td><td> <code>oval-sc:oval_system_characteristics</code> </td><td> <code>201 Created</code><br><code>Location: {URI}</code> </td><td> -                    </td></tr></tbody></table>


<h2><font color='#0044CC'>Oval Results Document Resources</font></h2>
T.B.D.<br>
<br>
<br>
<br>
<br>
<hr />
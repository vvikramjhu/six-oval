# <font color='#0044CC'>Introduction</font> #

T.B.D.

In this version, 1.0.0, the least query means are provided.

  * Parameter as a key-value pair.
  * Logical "AND" concatenation of parameters.
  * Comma ',' as a list delimiter. Logical "OR" concatenation of list values.



## <font color='#0044CC'>Queries in Java Applications</font> ##

## <font color='#0044CC'>Queries in Web Services</font> ##





---

# <font color='#0044CC'>Parameter Definitions</font> #

Here,
we show the query parameters for the OVAL object types.
In the tables, each column means that:
  * **Parameter Name**: name of the parameter.
  * **Java Type**: type of the parameter value.
  * **OVAL XPath**: relative xpath of the target node in OVAL XML documents.
  * **List?**: whether the value can be a list or not.
  * **Wildcard?**: whether the value can contain wildcard(s); `'*'`.
  * **Examples**: key-value examples, as string representations.
  * **Notes**: additional notes.



## <font color='#0044CC'>Common</font> ##

The common parameters can be used for any type of objects.

| **Parameter Name** | **Java Type** | **Examples** | **Notes** |
|:-------------------|:--------------|:-------------|:----------|
| searchTerms        | String        | `searchTerms=buffer` | -         |
| count              | int           | `count=10`   | -         |
| startIndex         | int           | `startIndex=50` | -         |
| order              | String        | `order=id,version` | -         |



## <font color='#0044CC'>Definition</font> ##

| **Parameter Name** | **Java Type** | **OVAL XPath** | **List?** | **Wildcard?** | **Examples** | **Notes** |
|:-------------------|:--------------|:---------------|:----------|:--------------|:-------------|:----------|
| id                 | String        | `./@id`        | Yes       | Yes           | `id=oval:org.foo:def:100`<br><code>id=oval:org.foo:def:*</code><br><code>id=oval:org.foo:def:100,oval:org.foo:def:101</code><br><code>id=oval:org.foo:def:*,oval:org.bar:def:*,oval:org.baz:def:*</code> <table><thead><th> -         </th></thead><tbody>
<tr><td> version            </td><td> int           </td><td> <code>./@version</code> </td><td> No        </td><td> No            </td><td> <code>version=2</code> </td><td> -         </td></tr>
<tr><td> definitionClass    </td><td> ClassEnumeration or String </td><td> <code>./@class</code> </td><td> Yes       </td><td> No            </td><td> <code>definitionsClass=vulnerability,patch</code> </td><td> The word "class" is a Java reserved word. </td></tr>
<tr><td> family             </td><td> Family or String </td><td> <code>./metadata/affected/@family</code> </td><td> Yes       </td><td> No            </td><td> <code>family=windows</code><br><code>family=windows,unix</code> </td><td> -         </td></tr>
<tr><td> platform           </td><td> String        </td><td> <code>./metadata/affected/platform</code> </td><td> Yes       </td><td> Yes           </td><td> <code>platform=Windows*</code><br><code>platform=Windows*,Solaris*</code> </td><td> -         </td></tr>
<tr><td> product            </td><td> String        </td><td> <code>./metadata/affected/product</code> </td><td> Yes       </td><td> Yes           </td><td> <code>product=Acrobat*</code><br><code>product=Internet Explorer*,Google Chrome*,Mozilla Firefox*</code> </td><td> -         </td></tr>
<tr><td> refSource          </td><td> String        </td><td> <code>./metadata/reference/@source</code> </td><td> Yes       </td><td> No            </td><td> <code>refSource=CVE</code><br><code>refSource=CVE,CPE</code> </td><td> -         </td></tr>
<tr><td> refId              </td><td> String        </td><td> <code>./metadata/reference/@ref_id</code> </td><td> Yes       </td><td> Yes           </td><td> <code>refId=CVE-2010-0176</code><br><code>refId=CVE-2012-*</code><br><code>refId=cpe:/a:adobe:acrobat:*,cpe:/a:adobe:flash:*</code> </td><td> -         </td></tr>
<tr><td> cve                </td><td> String        </td><td> <code>./metadata/reference/@ref_id</code> </td><td> Yes       </td><td> Yes           </td><td> <code>cve=CVE-2010-0176</code><br><code>cve=CVE-2012-*</code><br><code>cve=CVE-2010-0176,CVE-2010-0177</code> </td><td> a shortcut to refId </td></tr>
<tr><td> searchTerms        </td><td> String        </td><td> <code>./metadata/(title|description)</code> </td><td> Yes       </td><td> No            </td><td> <code>searchTerms=buffer</code> </td><td> -         </td></tr></tbody></table>



<h2><font color='#0044CC'>Test, Object, State, Variable</font></h2>

<table><thead><th> <b>Parameter Name</b> </th><th> <b>Java Type</b> </th><th> <b>OVAL XPath</b> </th><th> <b>List?</b> </th><th> <b>Wildcard?</b> </th><th> <b>Examples</b> </th><th> <b>Notes</b> </th></thead><tbody>
<tr><td> id                    </td><td> String           </td><td> <code>./@id</code> </td><td> Yes          </td><td> Yes              </td><td> <code>id=oval:org.foo:def:100</code><br><code>id=oval:org.foo:def:*</code><br><code>id=oval:org.foo:def:100,oval:org.foo:def:101</code><br><code>id=oval:org.foo:def:*,oval:org.bar:def:*,oval:org.baz:def:*</code> </td><td> -            </td></tr>
<tr><td> version               </td><td> int              </td><td> <code>./@version</code> </td><td> No           </td><td> No               </td><td> <code>version=2</code> </td><td> -            </td></tr>
<tr><td> type                  </td><td> ElementType or String </td><td> -                 </td><td> No           </td><td> No               </td><td> <code>type=test</code> </td><td> -            </td></tr>
<tr><td> family                </td><td> Family or String </td><td> -                 </td><td> Yes          </td><td> No               </td><td> <code>family=windows</code><br><code>family=windows,unix</code> </td><td> -            </td></tr>
<tr><td> component             </td><td> ComponentType or String </td><td> -                 </td><td> Yes          </td><td> No               </td><td> <code>component=file</code><br><code>component=file,registry</code> </td><td> -            </td></tr>
<tr><td> searchTerms           </td><td> String           </td><td> <code>./@comment</code> </td><td> Yes          </td><td> No               </td><td> <code>searchTerms=buffer</code> </td><td> -            </td></tr></tbody></table>



<h2><font color='#0044CC'>OVAL System Characteristics</font></h2>

<table><thead><th> <b>Parameter Name</b> </th><th> <b>Java Type</b> </th><th> <b>OVAL XPath</b> </th><th> <b>List?</b> </th><th> <b>Wildcard?</b> </th><th> <b>Examples</b> </th><th> <b>Notes</b> </th></thead><tbody>
<tr><td> host                  </td><td> String           </td><td> <code>./system_info/primary_host_name</code> </td><td> Yes          </td><td> Yes              </td><td> <code>host=mailserver</code><br><code>host=mailserver,webserver</code><br><code>host=*.foo.org</code><br><code>host=*.a.foo.org,*.b.foo.org</code> </td><td> -            </td></tr>
<tr><td> os                    </td><td> String           </td><td> <code>./system_info/os_name</code> </td><td> Yes          </td><td> No               </td><td> <code>os=Windows*</code><br><code>os=Windows*,Solaris*</code><br><code>os=*Linux*</code> </td><td> -            </td></tr>
<tr><td> osVersion             </td><td> String           </td><td> <code>./system_info/os_version</code> </td><td> Yes          </td><td> Yes              </td><td> <code>osVersion=6.1.7601</code><br><code>osVersion=&gt;5</code><br><code>osVersion=5.1.*,5.2.*</code> </td><td> '>' and '<' means 'greater than' and 'less than', respectively. </td></tr>
<tr><td> ip                    </td><td> String           </td><td> <code>./system_info/interfaces/interface/ip_address</code> </td><td> Yes          </td><td> Yes              </td><td> <code>ip=192.168.1.2</code><br><code>ip=192.168.1.*</code><br><code>ip=192.168.1.*,192.168.2.*</code> </td><td> -            </td></tr></tbody></table>



<h2><font color='#0044CC'>OVAL Results</font></h2>

The query parameters for OVAL Results include<br>
the ones for OVAL System Characteristics,<br>
where each XPath is shifted to under '<code>./results/system/oval_system_characteristics</code>'.<br>
<br>
<table><thead><th> <b>Parameter Name</b> </th><th> <b>Java Type</b> </th><th> <b>OVAL XPath</b> </th><th> <b>List?</b> </th><th> <b>Wildcard?</b> </th><th> <b>Examples</b> </th><th> <b>Notes</b> </th></thead><tbody>
<tr><td> definition            </td><td> String           </td><td> <code>./results/system/definitions/definition/@definition_id</code> </td><td> Yes          </td><td> No               </td><td> <code>definition=oval:org.foo:def:100</code><br><code>definition=oval:org.foo:def:100,oval:org.foo:def:101</code> </td><td> -            </td></tr>
<tr><td> definitionTrue        </td><td> String           </td><td> <code>./results/system/definitions/definition[@result='true']/@definition_id</code> </td><td> Yes          </td><td> No               </td><td> <code>definition=oval:org.foo:def:100</code><br><code>definition=oval:org.foo:def:100,oval:org.foo:def:101</code> </td><td> -            </td></tr>
<tr><td> host                  </td><td> String           </td><td> <code>./results/system/oval_system_characteristics/system_info/primary_host_name</code> </td><td> Yes          </td><td> Yes              </td><td> <code>host=mailserver</code><br><code>host=mailserver,webserver</code><br><code>host=*.foo.org</code><br><code>host=*.a.foo.org,*.b.foo.org</code> </td><td> -            </td></tr>
<tr><td> os                    </td><td> String           </td><td> <code>./results/system/oval_system_characteristics/system_info/os_name</code> </td><td> Yes          </td><td> No               </td><td> <code>os=Windows*</code><br><code>os=Windows*,Solaris*</code><br><code>os=*Linux*</code> </td><td> -            </td></tr>
<tr><td> osVersion             </td><td> String           </td><td> <code>./results/system/oval_system_characteristics/system_info/os_version</code> </td><td> Yes          </td><td> Yes              </td><td> <code>osVersion=6.1.7601</code><br><code>osVersion=&gt;5</code><br><code>osVersion=5.1.*,5.2.*</code> </td><td> '>' and '<' means 'greater than' and 'less than', respectively. </td></tr>
<tr><td> ip                    </td><td> String           </td><td> <code>./results/system/oval_system_characteristics/system_info/interfaces/interface/ip_address</code> </td><td> Yes          </td><td> Yes              </td><td> <code>ip=192.168.1.2</code><br><code>ip=192.168.1.*</code><br><code>ip=192.168.1.*,192.168.2.*</code> </td><td> -            </td></tr></tbody></table>


<hr />
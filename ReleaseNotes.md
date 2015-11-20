# <font color='#0044CC'>Summary</font> #

| **SIX OVAL version** | **OVAL Schema version** |
|:---------------------|:------------------------|
| 1.4.x, 1.3.x, 1.2.x, 1.1.x, 1.0.x | 5.10.1                  |




---

# <font color='#0044CC'>Version 1.4.0 (2013-07-05)</font> #

## <font color='#0044CC'>OVAL Support</font> ##
  * OVAL Schema Version: 5.10.1
  * Cisco IOS and PIXOS families supported.
| **Family** | **Components** |
|:-----------|:---------------|
| aix        | fileset, fix, interim\_fix, no, oslevel |
| independent       | environmentvariable, environmentvariable58, family, filehash, filehash58, ldap, ldap57, sql, sql57, textfilecontent, textfilecontent54, unknown, variable, xmlfilecontent |
| **_ios_**  | **_global, interface, line, snmp, tclsh, version, version55_** |
| linux      | dpkginfo, iflisteners, inetlisteningservers, partition, rpminfo, rpmverify, rpmverifyfile, rpmverifypackage, selinuxboolean, selinuxsecuritycontext, slackwarepkginfo |
| macos      | accountinfo, diskutil, inetlisteningservers, inetlisteningserver510, nvram, plist, plist510, pwpolicy, pwpolicy59 |
| **_pixos_** | **_line, version_** |
| solaris    | isainfo, ndd, package, packagecheck, patch, patch54, smf |
| unix       | dnscache, file, fileextendedattribute, gconf, inetd, interface, password, process, process58, routingtable, runlevel, sccs, shadow, sysctl, uname, xinetd |
| windows    | accesstoken, activedirectory, activedirectory57, auditeventpolicy, auditeventpolicysubcategories, cmdlet, dnscache, file, fileauditedpermissions,  fileauditedpermissions53, fileeffectiverights, fileeffectiverights53, group, group\_sid, interface, lockoutpolicy, metabase, passwordpolicy, peheader, port, printereffectiverights, process, process58, registry, regkeyauditedpermissions, regkeyauditedpermissions53, regkeyeffectiverights, regkeyeffectiverights53, service, serviceeffectiverights, sharedresource, sharedresourceauditedpermissions, sharedresourceeffectiverights, sid, sid\_sid, uac, user, user\_sid, user\_sid55, volume, wmi, wmi57, wuaupdatesearcher |

## <font color='#0044CC'>Environment</font> ##
  * Java: Java SE 7

## <font color='#0044CC'>Fixed</font> ##
### <font color='#0044CC'>core</font> ###
  * [Issue #8](https://code.google.com/p/six-oval/issues/detail?id=#8): Adopting Java SE 7




---

# <font color='#0044CC'>Version 1.3.1 (2013-06-18)</font> #
## <font color='#0044CC'>Fixed</font> ##
### <font color='#0044CC'>core</font> ###
  * [Issue #7](https://code.google.com/p/six-oval/issues/detail?id=#7): SixOvalContext fails in creating a properties bean if the properties file does not exist




---

# <font color='#0044CC'>Version 1.3.0 (2013-06-07)</font> #

## <font color='#0044CC'>OVAL Support</font> ##
  * OVAL Schema Version: 5.10.1
  * AIX family supported.
| **Family** | **Components** |
|:-----------|:---------------|
| **_aix_**  | **_fileset, fix, interim\_fix, no, oslevel_** |
| independent       | environmentvariable, environmentvariable58, family, filehash, filehash58, ldap, ldap57, sql, sql57, textfilecontent, textfilecontent54, unknown, variable, xmlfilecontent |
| linux      | dpkginfo, iflisteners, inetlisteningservers, partition, rpminfo, rpmverify, rpmverifyfile, rpmverifypackage, selinuxboolean, selinuxsecuritycontext, slackwarepkginfo |
| macos      | accountinfo, diskutil, inetlisteningservers, inetlisteningserver510, nvram, plist, plist510, pwpolicy, pwpolicy59 |
| solaris    | isainfo, ndd, package, packagecheck, patch, patch54, smf |
| unix       | dnscache, file, fileextendedattribute, gconf, inetd, interface, password, process, process58, routingtable, runlevel, sccs, shadow, sysctl, uname, xinetd |
| windows    | accesstoken, activedirectory, activedirectory57, auditeventpolicy, auditeventpolicysubcategories, cmdlet, dnscache, file, fileauditedpermissions,  fileauditedpermissions53, fileeffectiverights, fileeffectiverights53, group, group\_sid, interface, lockoutpolicy, metabase, passwordpolicy, peheader, port, printereffectiverights, process, process58, registry, regkeyauditedpermissions, regkeyauditedpermissions53, regkeyeffectiverights, regkeyeffectiverights53, service, serviceeffectiverights, sharedresource, sharedresourceauditedpermissions, sharedresourceeffectiverights, sid, sid\_sid, uac, user, user\_sid, user\_sid55, volume, wmi, wmi57, wuaupdatesearcher |



---

# <font color='#0044CC'>Version 1.2.0 (2012-09-24)</font> #

## <font color='#0044CC'>OVAL Support</font> ##
  * OVAL Schema Version: 5.10.1
  * MacOS family supported.
| **Family** | **Components** |
|:-----------|:---------------|
| independent       | environmentvariable, environmentvariable58, family, filehash, filehash58, ldap, ldap57, sql, sql57, textfilecontent, textfilecontent54, unknown, variable, xmlfilecontent |
| linux      | dpkginfo, iflisteners, inetlisteningservers, partition, rpminfo, rpmverify, rpmverifyfile, rpmverifypackage, selinuxboolean, selinuxsecuritycontext, slackwarepkginfo |
| **_macos_** | **_accountinfo, diskutil, inetlisteningservers, inetlisteningserver510, nvram, plist, plist510, pwpolicy, pwpolicy59_** |
| solaris    | isainfo, ndd, package, packagecheck, patch, patch54, smf |
| unix       | dnscache, file, fileextendedattribute, gconf, inetd, interface, password, process, process58, routingtable, runlevel, sccs, shadow, sysctl, uname, xinetd |
| windows    | accesstoken, activedirectory, activedirectory57, auditeventpolicy, auditeventpolicysubcategories, cmdlet, dnscache, file, fileauditedpermissions,  fileauditedpermissions53, fileeffectiverights, fileeffectiverights53, group, group\_sid, interface, lockoutpolicy, metabase, passwordpolicy, peheader, port, printereffectiverights, process, process58, registry, regkeyauditedpermissions, regkeyauditedpermissions53, regkeyeffectiverights, regkeyeffectiverights53, service, serviceeffectiverights, sharedresource, sharedresourceauditedpermissions, sharedresourceeffectiverights, sid, sid\_sid, uac, user, user\_sid, user\_sid55, volume, wmi, wmi57, wuaupdatesearcher |



---

# <font color='#0044CC'>Version 1.1.1 (2012-09-19)</font> #

## <font color='#0044CC'>OVAL Support</font> ##
  * OVAL Schema Version: 5.10.1
  * Independent, Linux, Unix, Windows family support completed. **_Bold italic_** components were added.
| **Family** | **Components** |
|:-----------|:---------------|
| independent       | environmentvariable, environmentvariable58, family, filehash, filehash58, ldap, **_ldap57_**, sql, sql57, textfilecontent, textfilecontent54, unknown, variable, xmlfilecontent |
| linux      | dpkginfo, **_iflisteners_**, inetlisteningservers, partition, rpminfo, rpmverify, **_rpmverifyfile_**, **_rpmverifypackage_**, selinuxboolean, selinuxsecuritycontext, slackwarepkginfo |
| solaris    | isainfo, ndd, package, packagecheck, patch, patch54, smf |
| unix       | **_dnscache_**, file, **_fileextendedattribute_**, **_gconf_**, inetd, interface, password, process, process58, **_routingtable_**, runlevel, **_sccs_**, shadow, **_sysctl_**, uname, xinetd |
| windows    | accesstoken, activedirectory, **_activedirectory57_**, auditeventpolicy, auditeventpolicysubcategories, **_cmdlet_**, **_dnscache_**, file, fileauditedpermissions,  fileauditedpermissions53, fileeffectiverights, fileeffectiverights53, group, group\_sid, interface, lockoutpolicy, metabase, passwordpolicy, **_peheader_**, port, printereffectiverights, process, process58, registry, regkeyauditedpermissions, regkeyauditedpermissions53, regkeyeffectiverights, regkeyeffectiverights53, **_service_**, serviceeffectiverights, sharedresource, **_sharedresourceauditedpermissions_**, **_sharedresourceeffectiverights_**, sid, sid\_sid, uac, user, user\_sid, user\_sid55, volume, wmi, wmi57, wuaupdatesearcher |


## <font color='#0044CC'>Fixed</font> ##
  * [Issue #3](https://code.google.com/p/six-oval/issues/detail?id=#3): Invalid class name EntityItemInterfaceType in the windows model



---

# <font color='#0044CC'>Version 1.1.0 (2012-09-05)</font> #

## <font color='#0044CC'>OVAL Support</font> ##
  * OVAL Schema Version: 5.10.1
  * Solaris family supported.
| **Family** | **Components** |
|:-----------|:---------------|
| independent       | environmentvariable, environmentvariable58, family, filehash, filehash58, ldap, sql, sql57, textfilecontent, textfilecontent54, unknown, variable, xmlfilecontent |
| linux      | dpkginfo, inetlisteningservers, partition, rpminfo, rpmverify, selinuxboolean, selinuxsecuritycontext, slackwarepkginfo |
| **_solaris_** | **_isainfo, ndd, package, packagecheck, patch, patch54, smf_** |
| unix       | file, inetd, interface, password, process, process58, runlevel, shadow, uname, xinetd |
| windows    | accesstoken, activedirectory, auditeventpolicy, auditeventpolicysubcategories, file, fileauditedpermissions,  fileauditedpermissions53, fileeffectiverights, fileeffectiverights53, group, group\_sid, interface, lockoutpolicy, metabase, passwordpolicy, port, printereffectiverights, process, process58, registry, regkeyauditedpermissions, regkeyauditedpermissions53, regkeyeffectiverights, regkeyeffectiverights53, serviceeffectiverights, sharedresource, sid, sid\_sid, uac, user,  user\_sid, user\_sid55, volume, wmi, wmi57, wuaupdatesearcher |




---

# <font color='#0044CC'>Version 1.0.1 (2012-09-04)</font> #

## <font color='#0044CC'>OVAL Support</font> ##
  * OVAL Schema Version: 5.10.1
  * Follwoing constructs are implemented:
    * `oval-def:UniqueFunctionType`
    * `oval-def:CountFunctionType`
    * `oval-def:EntityObjectIPAddressType`
    * `oval-def:EntityObjectAnySimpleType`
    * `oval-def:EntityObjectBinaryType`
    * `oval-def:EntityObjectBoolType`
    * `oval-def:EntityObjectFloatType`
    * `oval-def:EntityObjectVersionType`
    * `oval-def:EntityObjectRecordType`
    * `oval-def:EntityObjectFieldType`
    * `oval-def:EntityStateIPAddressType`
    * `oval-def:EntityStateBinaryType`
    * `oval-def:EntityStateFloatType`
    * `oval-def:EntityStateFileSetRevisionType`
    * `oval-def:EntityStateIOSVersionType`
    * `oval-sc: EntityItemIPAddressType`
    * `oval-sc: EntityItemBinaryType`
    * `oval-sc: EntityItemFloatType`
    * `oval-sc: EntityItemFilesetRevisionType`
    * `oval-sc: EntityItemIOSVersionType`
    * `oval: ElementMapType`
    * `oval: ElementMapItemType`
    * `oval: DeprecatedInfoType`




---

# <font color='#0044CC'>Version 1.0.0 (2012-08-29)</font> #

## <font color='#0044CC'>Changes</font> ##
  * Now we use [MongoDB](http://www.mongodb.org/) for the  repository implementation.


## <font color='#0044CC'>OVAL Support</font> ##
  * OVAL Schema Version: 5.10.1
  * Platforms and Components: see the following table.
| **Family** | **Components** |
|:-----------|:---------------|
| independent       | environmentvariable, environmentvariable58, family, filehash, filehash58, ldap, sql, sql57, textfilecontent, textfilecontent54, unknown, variable, xmlfilecontent |
| linux      | dpkginfo, inetlisteningservers, partition, rpminfo, rpmverify, selinuxboolean, selinuxsecuritycontext, slackwarepkginfo |
| unix       | file, inetd, interface, password, process, process58, runlevel, shadow, uname, xinetd |
| windows    | accesstoken, activedirectory, auditeventpolicy, auditeventpolicysubcategories, file, fileauditedpermissions,  fileauditedpermissions53, fileeffectiverights, fileeffectiverights53, group, group\_sid, interface, lockoutpolicy, metabase, passwordpolicy, port, printereffectiverights, process, process58, registry, regkeyauditedpermissions, regkeyauditedpermissions53, regkeyeffectiverights, regkeyeffectiverights53, serviceeffectiverights, sharedresource, sid, sid\_sid, uac, user, user\_sid, user\_sid55, volume, wmi, wmi57, wuaupdatesearcher |



## <font color='#0044CC'>Tested Environment</font> ##

  * **Java 2 SE**: Oracle JDK 6 update 34, windows x64
  * **Java components**: See the following table. Note that there may be indirect dependencies; e.g. Apache Commons Logging and Log4j.
  * **Database**: MongoDB 2.0.6, win32, x86\_64
  * **Servlet Container**: Tomcat 6.0.35
  * **OVAL Definition Interpreter**: ovaldi 5.10.1, build 2, x64

| **Product Name** | **Tested Version** | **Required JAR Files** | **License** |
|:-----------------|:-------------------|:-----------------------|:------------|
| [Apache Commons Lang](http://commons.apache.org/lang/) | 2.6  (Note 1)      | commons-lang-2.6.jar   | Apache v2.0 |
| [Castor](http://castor.codehaus.org/) | 1.3.2              | castor-1.3.2-core.jar, <br>castor-1.3.2-xml.jar <table><thead><th> Apache v2.0 </th></thead><tbody>
<tr><td> <a href='http://www.oracle.com/technetwork/java/index-jsp-135475.html'>Java Servlet API</a> </td><td> 2.5                </td><td> servlet-api.jar        </td><td> Apache v2.0 </td></tr>
<tr><td> <a href='http://www.mongodb.org/display/DOCS/Java+Language+Center'>MongoDB Java Driver</a> </td><td> 2.8.0              </td><td> mongo-2.8.0.jar        </td><td> Apache v2.0 </td></tr>
<tr><td> <a href='http://code.google.com/p/morphia/'>Morphia</a> </td><td> 0.99.1 SNAPSHOT    </td><td> morphia-0.99.1-SNAPSHOT.jar, <br>morphia-logging-slf4j-0.99.jar </td><td> Apache v2.0 </td></tr>
<tr><td> <a href='http://code.google.com/p/six-util/'>SIX UTIL</a> </td><td> 3.2.0              </td><td> six-util-3.2.0.jar     </td><td> Apache v2.0 </td></tr>
<tr><td> <a href='http://www.slf4j.org/'>SLF4J</a> </td><td> 1.6.6              </td><td> slf4j-api-1.6.6.jar    </td><td> MIT         </td></tr>
<tr><td> <a href='http://www.springsource.org/spring-framework'>Spring Framework</a> </td><td> 3.0.7              </td><td> org.springframework.asm-3.0.7.RELEASE.jar, <br>org.springframework.beans-3.0.7.RELEASE.jar, <br>org.springframework.context-3.0.7.RELEASE.jar, <br>org.springframework.core-3.0.7.RELEASE.jar, <br>org.springframework.expression-3.0.7.RELEASE.jar, <br>org.springframework.oxm-3.0.7.RELEASE.jar, <br>org.springframework.web.servlet-3.0.7.RELEASE.jar, <br>org.springframework.web-3.0.7.RELEASE.jar </td><td> Apache v2.0 </td></tr></tbody></table>

<ul><li>Note 1: Apache Lang 3.x does not work.</li></ul>

<hr />
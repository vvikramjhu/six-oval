# <font color='#0044CC'>Introduction</font> #

T.B.D.

This document describes the OVAL Domain Model
using UML class diagrams.
Most of classes are directly derived from
the OVAL schemas.
However, there are some exceptions to names,
because those ones in the OVAL schemas are
the Java reserved keywords.


> <b>Table</b>: Relations between the OVAL Schemas and the SIX OVAL Java Packages
| **OVAL Schema**  | **XML Namespace** | **Java Package** |
|:-----------------|:------------------|:-----------------|
|-                 |-                  |jp.go.aist.six.oval.model |
|Core Common       |-                  |jp.go.aist.six.oval.model.common |
|Core Definition   |-                  |jp.go.aist.six.oval.model.definitions |
|Core System Characteristics |-                  |jp.go.aist.six.oval.model.sc |
|Core Results      |-                  |jp.go.aist.six.oval.model.results |
|Core Directives   |-                  |jp.go.aist.six.oval.model.directives |
|Core Variable     |-                  |jp.go.aist.six.oval.model.variables |
|Independent Components |-                  |jp.go.aist.six.oval.model.independent |
|Linux Components  |-                  |jp.go.aist.six.oval.model.linux |
|Solaris Components |-                  |jp.go.aist.six.oval.model.solaris |
|Unix Components   |-                  |jp.go.aist.six.oval.model.unix |
|Windows Components |-                  |jp.go.aist.six.oval.model.windows |



---

# <font color='#0044CC'>Base Abstract Model</font> #

The classes in the root "model" package are
not inherent in the OVAL schemas,
but are abstracted from the main part of them.
Figure 1 shows the abstracted classes in our model.


> <b>Figure 1</b>: Base Abstract Classes
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model_abstract.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model_abstract.png)


In addition to the abstracted classes,
this package contains enumeration of
supported OS families and their components.
Figure 2 shows these enumeration classes.

> <b>Figure 2</b>: Supported Families and Components
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model_component.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model_component.png)




---

# <font color='#0044CC'>Core Common</font> #

The OVAL Common Core schema defines the common types
that are shared across the different schemas within OVAL.

> <b>Figure 3</b>: Core Common Model - OVAL ID and Enumerations
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.common.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.common.png)


> <b>Figure 4</b>: Core Common Model - Document Generator
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.common_document.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.common_document.png)




---

# <font color='#0044CC'>Core Definition</font> #

T.B.D.

Please note that
**ObjectType** in the OVAL schema is
renamed to **SystemObjectType** in Java,
because the word "Object" has special meaning in Java world.


> <b>Figure 5</b>: Core Definition Model - Elements
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.definitions_elements.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.definitions_elements.png)


> <b>Figure 6</b>: Core Definition Model - Definition
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.definitions_def.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.definitions_def.png)


> <b>Figure 7</b>: Core Definition Model - Criteria
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.definitions_criteria.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.definitions_criteria.png)

The CriteriaElement class is
not inherent in the OVAL schema,
but are abstracted from the criteria elements.
This structure forms a composite pattern.



> <b>Figure 8</b>: Core Definition Model - Definitions Document
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.definitions.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.definitions.png)




---

# <font color='#0044CC'>Core System Characteristics</font> #

T.B.D.

> <b>Figure 9</b>: Core System Characteristics Model
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.sc.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.sc.png)


> <b>Figure 10</b>: Core System Characteristics Model - Object
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.sc_object.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.sc_object.png)


> <b>Figure 11</b>: Core System Characteristics Model - Item
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.sc_item.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.sc_item.png)




---

# <font color='#0044CC'>Core Results</font> #

T.B.D.

> <b>Figure 12</b>: Core Results Model
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.results.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.results.png)


> <b>Figure 13</b>: Core Results Model - System
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.results_system.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.results_system.png)


> <b>Figure 14</b>: Core Results Model - Definition
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.results_def.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.results_def.png)


> <b>Figure 15</b>: Core Results Model - Test
![http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.results_test.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/six-oval-1_0/oval.model.results_test.png)




---

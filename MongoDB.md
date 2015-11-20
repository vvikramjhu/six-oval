# <font color='#0044CC'>Introduction</font> #

In this page,
we describe the step-by-step process to install MongoDB
on Windows platform.
Please read the official
[Installation Guides](http://www.mongodb.org/display/DOCS/Quickstart)
on various kinds of platforms.



# <font color='#0044CC'>MongoDB Installation and Configuration Process</font> #


## <font color='#0044CC'>1 Download the Distribution Archive and Extract</font> ##

Download the appropriate archive from the
[downloads page](http://www.mongodb.org/downloads).
The file looks like mongodb-win32-x86\_64-2.0.6.zip
for Windows 64-bit platforms.

Extract the archive file into the appropriate location.
Rename the directory if necessary.


## <font color='#0044CC'>2 Create a Data Directory</font> ##

MongoDB requires a directory to store
its database files.
The default is **C:\data\db**.
Create the directory if you want to change the location.


> Figure 1: Directories.

> ![http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-01.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-01.png)


## <font color='#0044CC'>3 Set up the Security</font> ##

Start the server, i.e. execute the **mongod** command.
The data directory is specified with **--dbpath** option.


> Figure 2: Starting the Server.

> ![http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-02.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-02.png)


Connect to the server using the MongoDB shell,
**mongo** command,
in another Windows command shell.
Then, create an administrator account.


> Figure 3: Creating the Administrator Account.

> ![http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-03.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-03.png)


Change the target database to **oval** and
create a user for it.
In the following example,
the user name and password are "six" and "six".


> Figure 4: Creating the SIX OVAL Account.

> ![http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-04.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-04.png)


With MongoDB, we don't need to create a database
explicitly.



## <font color='#0044CC'>4 Verify the Environment</font> ##

Restart the server with the secure mode,
with **--auth** option.


> Figure 5: Run the Server in Secure Mode.

> ![http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-05.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-05.png)


Then, reconnect to the server with authentication information;
user name and password.


> Figure 6: Connecting the Server with Authentication.

> ![http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-07.png](http://staff.aist.go.jp/nakamura-akihito/six/oval/mongodb/mongodb-step-07.png)
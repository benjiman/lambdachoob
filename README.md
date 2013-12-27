lambdachoob
===========

Experimental IRC Bot using Java 8

## Features
### Plugins
Simply Java Classes with Fields of a functional interface type. Command name is dictated by field name. e.g.
  CommandOneArg hello =  name -> "hello, name"; 
  
  <benji> !myplugin.hello benji
  <LambdaBot> hello, benji
  
  
### Filters
Match a regex to execute a plugin command
  Filter lookForHellos = match("hello (\\w+)").then(name -> "hello, " + name);

  <benji> hello bob
  <LambdaBot> hello, bob



### Pipes
Send output from one command to another e.g. 

  !cmd1 | !cmd2 | !cmd3. 
  
Implemented using Plugin and Filters

### Aliases

reate shorter command names for fully qualified plugin names. 
Implemented using Plugin and Filters.
  
## Limitations

No support for

* Persistence
* User level permissions
* Protection against malicious plugins

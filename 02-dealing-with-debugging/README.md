# Dealing with Debugging

## Goals
+ Review our understanding of the debugger
+ Discuss debugging techniques for common bugs you may run into
+ Practice using the debugger

## Debugging
### What is debugging?
+ When we write code, we sometimes run into errors called *bugs*.
+ To  *debug* is to remove those bugs - i.e., identify the errors in our code and fix them so the code functions as intended.

### What is a debugger?
+ A debugger is a program, usually included in your IDE, that helps you find those errors.

### Why learn how to debug?
+ You're probably used to adding many *println()* statements to your code to figure out what's wrong with it.
  + This can help you identify what values variables hold, where your code executes (or doesn't), etc.
+ A debugger helps you do this, but more efficiently and gives you greater insight into what your program is doing.
+ In CS2201 (Data Structures), effective debugging will be a huge time-saver.
+ Modern debuggers are comprehensive and provide huge amounts of info that can help you locate bugs in your code.

### Key parts of a debugger
+ Breakpoints
  + By setting breakpoints, you can run through your program and stop its execution at a specific point.
  + This can be helpful when you want everything before a breakpoint to run normally, but then observe behavior at a given point you think is causing trouble.
+ Stepping
  + Debuggers allow you to *step* through your program line-by-line to observe what's happening.
  + Step into
    + Executes code one statement at a time.
    + If the statement is a call to a procedure, the next statement displayed is the first statement in the procedure.
  + Step over
    + Similar to *step into*
    + When the current statement contains a procedure (i.e., a _method_), *step over* executes the procedure as a unit (without stepping into the procedure's own statements), and then steps to the next statement in the current procedure. 
  + Step out
    + Executes the remaining lines of a function in which the current execution point lies.
    + The next statement displayed is the statement following the procedure call.
+ State and call stack
    + Many debuggers allow you to view the state of variables and values of parameters at given points in your program.
    + You can also view the *call stack* - a structure showing what procedures have been called by other procedures and in   what order.
+ [Reference](https://msdn.microsoft.com/en-us/library/office/gg251651.aspx)

## Debugging Techniques
### The naïve approach
Naïvely, we can approach debugging by throwing a ton of ```System.out.println()``` calls in our code to see what's going on.
I don't fundamentally _disagree_ with this approach - it's something I do from time to time if I have something quick that needs to be diagnosed or I'm performing a quick check to validate my output. 

That being said, we can do a bit better.

### The debugger approach
#### Using debugger features
+ Placing breakpoints
  + Place breakpoints on lines of code you think are causing a problem.
  + Place breakpoints on lines of code at which you want to know the exact state of all your variables.
+ Stepping
  + Step into 
    + This and _step over_ are functionally equivalent if the statement being stepped into/over is _not_ a procedure (method) call.
    + If the statement you're viewing is a procedure (method) call
      + Only step _into_ the statement if you care about what happens in the method call (i.e., it's something you wrote)
      + Avoid stepping into statements that call standard Java library methods - you likely won't find anything of value
  + Step Over
    + Useful for stepping through your code one line at a time and _your code alone_ - i.e., not delving into method calls
  + Step out
    + Useful if you've stepped through the suspicious parts of a procedure (method) and the rest of its statements are benign (i.e., you're not concerned about them)
+ State and call stack
  + The *state* of your variables are displayed nicely by IntelliJ's debugger - use this to make sure values of variables are _exactly_ what you expect them to be.
    + If they're not, you have a great starting point - ask yourself where that variable's value was assigned, and look there to begin searching for the error.
  + The *call stack* allows you to see the order in which methods called other methods
    + Java programs begin in the _main()_ method, which calls other methods, which call other methods, etc.
    + This is all formatted in a _stack_ - the first method called lies at the bottom, and the subsequent methods called are placed on top of our stack

#### Writing driver methods
If you want to individually test methods, try calling _only_ that method from _main()_ and test only its functionality. The whole purpose of writing methods is to componentize your code; that is, each method should do _one_ task and do it extraordinarily well. If a given task fails, you'll know immediately that the single method assigned to that task is to blame.    

### Common errors to keep in mind
Oftentimes, our code is plagued by one of several _very_ common errors. Try keeping these in mind when you start debugging so you can either eliminate the obvious suspects or find something small that's straightforward to fix.

+ Locating the cause of a crash
  + IntelliJ will point out the line number at which a program terminated unexpectedly (i.e., _crashed_). Read the output to find this and located exactly where things went wrong.
  + Your program's call stack can help you find the root culprit of a crash or error if it happened after a series of method calls
    + Follow the stack back to the original location of the error
+ String indexing
  + Strings are indexed from [0, length)
  + Read the program output to figure out what index your program tried to access
    + Java won't let you access the incorrect memory - it's very safe in this regard
    + Oftentimes, you might be tried to access index -1 or the index right after the last character
      + Look at the variable you're using to access these indices and consider the values it holds 
+ Loops
  + Off-by-one errors in for/while loops
    + These errors can often lead to other issues, such as incorrect String indexing
    + Always check your counting variables _and_ where they're used
      + The wrong counting variables can lead to incorrect indexing or access of Strings, arrays, etc.
  + Nested loops
    + Be careful with nested loops
      + Especially if the inner loop relies on the outer loop's counting variable
    + Double-check your indexing and make sure you typed the correct variable names in the correct places
      + This is easy to mix up if your outer loop counter is, say, ```i``` and your inner loop counter is ```j```
## Debugging Practice
Please view the file ```00-example-project/src/dealingWithDebugging.java``` for examples of code that doesn't _quite_ work that you can use the debugger to help you fix.

## Closing thoughts
Debugging is a skill that goes a long way - learn it well now, and it'll save you tons of time in the future. Yes, it's a bit cumbersome to get started - by all means. In the long run, you'll be able to use the debugger many times to quickly diagnose errors that would take inordinate amounts of time to find without a tool like the debugger.

Debugging is all about playing detective. Debuggers set you up to have a _very_ clear view of all the things at play in your program: what procedures call what other procedures, what memory is being allocated, which variables are given certain values, etc. You've been set up to search for the bug given all this information and don't have to worry about finding that info. In other words, you've been set up to bat - all you've got to do is swing.

## References
[JetBrains' guide to debugging Java applications](https://www.jetbrains.com/help/idea/debugging-your-first-java-application.html)
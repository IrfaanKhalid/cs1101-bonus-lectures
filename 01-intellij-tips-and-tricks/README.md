# IntelliJ Tips and Tricks

## Goals
+ Understand the value IDEs like IntelliJ provide
+ Understand what good code style is and why it matters
+ Explore the basics of debugging with an IDE

## IDEs
### What _is_ an IDE?
+ An IDE - or an _Integrated Development Environment_, is a comprehensive software application that provides one place to write, build, test, and deploy code.
  + Specific features will vary, but most modern IDEs are relatively similar.
+ IntelliJ is an IDE made by JetBrains, a company that produces many other IDEs.
  + CLion for C/C++
  + PyCharm for Python
  + WebStorm for JavaScript/PHP/other web development

## Style
### Why is Code Style Important?
+ The style of your code matters because you're not always the only one looking at it.
  + If your code style is poor, you won't be able to go back and understand it later.
  + Neither will anyone else!
+ Software development isn't just writing code - it's maintaining it, too.
  + Adding new features
  + Fixing bugs
  + Revamping or overhauling old systems

### What Constitutes Good Code Style?
+ Indentation
  + Be consistent so it's easy to see how your code nests.
+ Whitespace
  + If your code is all cramped together, it'll be hard to read through it.
+ Inline spacing
  + Make sure you include spaces in your lines (near commas, parentheses, etc.) so it's easy to read each line, too.
+ Line length
  + Reasonable line lengths help navigate code without horizontal scrolling.
    + The roots of these regulations lie in how many characters could fit on a piece of paper when printing code.
  + Industry standards vary, but in this class we'll stick with **100** characters.
+ Comments
  + If you or someone else needs to maintain your code, comments explaining what's going on when it's not obvious help.
  + Over-commenting vs Under-commenting
    + Over-commenting is when your comments actually make reading/understanding your code more difficult.
      + Not every single line of code needs a comment - only the tricky parts.
    + Under-commenting is when your code is tricky to understand and your poor reader doesn't have comments to help.
  + Try to strike a balance with insightful, brief, and well-distributed comments.
    + This takes practice!
+ Clear, concise solutions
  + Convoluted solutions are hard to follow - even with comments. 
  + A good example of this is a long series of nested if-statements, like you saw in PA08.
    + They're hard to follow and inefficient from a compilation standpoint.
+ Modularity
  + Keep your methods short and specific - each method only needs to do one thing.
  + This way, organizing your code is easy.
  + If you run into an error in your code, you can pinpoint _exactly_ where it occurred.

### Further Reading
+ My favorite code style guide is NASA's, summarized [here](http://sdtimes.com/nasas-10-rules-developing-safety-critical-code/).
  + TL;DR - Keep things clear, simple, concise, and local
+ [Facebook](https://github.com/facebook/jcommon/wiki/Coding-Standards) also has a good Java style guide.
+ Forewarning - standards differ between companies for specific style components, such as line length, tab size, etc.
  + Wherever you are, follow the style guide to maintain consistency.
  + While some parts of your style can vary, general style guidelines do exist - NASA's guide does a great job of this.

### IntelliJ's Features and Styling Your Code
Make sure you've downloaded this GitHub repository (either ```git clone``` it or download it as a .zip file).
Open _example-project_ in IntelliJ to get started.

+ IDEs can be especially useful for the *editing* process.
+ Reformat Code (*Code → Reformat Code*)
  + This can fix your **inline spacing** and **indentation** issues.
+ Default line length (*File → Settings → Editor → Code Style → Java → Right margin*)
  + In CS1101, keep your lines at or under **100** characters.
  + IntelliJ's editor shows you a vertical line to keep you on track.
  + If you'd like, you can enable the *Wrap on Typing* feature so you never exceed your preset limit.
  + Alternatively, the *Ensure right margin is never exceeded* option is useful.
+ Comments
  + Java uses *Javadoc* comments, which are required on your assignments from PA08 onward.
  + Javadoc comments are useful because they're easily parsed into *Javadocs*, which is how
    Java's official online API references are formatted.
  + After you declare a method, IntelliJ can help you automatically generate Javadoc comments.
    1. Place the caret before the declaration.
    2. Type the opening block comment /**, and press Enter.
    3. Add meaningful description of parameters and return values.
  + Also write comments detailing tricky pieces of code.
    + Complicated loops, unconventional logic, and other non-obvious code.
+ Default Template
  + IntelliJ can automatically include your header comment block in every ```.java``` file you make!
  + Follow these steps:
    1. Navigate to *File → Settings → Editor → File and Code Templates → Class*
    2. Remove info above ```public class ${NAME}```
    3. Copy and paste the following header template:
       ```
       /* Name:
        * VUnetID:
        * Email:
        * Class: CS 1101 - Vanderbilt University
        * Honor statement: I agree to have neither given nor received
        *                  unauthorized aid on this assignment.
        * Date: ${DATE}
        *
        * Description: 
        */

       ``` 
    4. Make sure you got the blank line at the end. Try making a new file to test this out.
+ Checkstyle Plugin
  + CheckStyle-IDEA is a plugin for IntelliJ - i.e., an extra piece of software you can install - that checks your style.
  + You can find it [here](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea).


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
    + When the current statement contains a procedure, *step over* executes the procedure as a unit, and 
      then steps to the next statement in the current procedure. 
  + Step out
    + Executes the remaining lines of a function in which the current execution point lies.
    + The next statement displayed is the statement following the procedure call.
+ State and call stack
    + Many debuggers allow you to view the state of variables and values of parameters at given points in your program.
    + You can also view the *call stack* - a structure showing what procedures have been called by other procedures and in   what order.
+ [Reference](https://msdn.microsoft.com/en-us/library/office/gg251651.aspx)

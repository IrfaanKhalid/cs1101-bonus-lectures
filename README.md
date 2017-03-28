# CS 1101 - Style and Debugging

## Introduction
### High-Level Goals
+ Understand some fundamental concepts related to software development
+ Correct some common mistakes we've noticed grading
+ Explore how IntelliJ (and similar IDEs) can make your life easier
+ Learn how to effectively debug

### Reminders
+ Make sure you submit your ```debugExample.java``` file on Blackboard by 7:05p to receive extra credit!

## Advice for Computer Science
+ It's supposed to be hard! Frustration is okay, normal, and should be welcomed as a motivator.
  + The payoff when you actually work through a difficult bug is immensely rewarding.
+ As developers, it's critical to meet specifications to the dot.
  + If you were to be hired for a software development project by a client/customer, even if you don't think the specification is ideal, it's your job to meet it to the dot as a professional.
  + In CS1101, it can be hard to meet all specifications, but they're in place to guide you and show you what it's like to work with a set of explicit instructions.

## Style
### Why is Code Style Important?
+ The style of your code matters because you're not always the only one looking at it.
+ Software development isn't just writing code - it's maintaining it, too.
  + Adding new features
  + Fixing bugs
  + Revamping old systems to be better
+ If your code style is poor, you won't be able to go back and understand what you actually did.
  + Neither will anyone else!

### What Constitutes Good Code Style?
+ Indentation
  + Be consistent so it's easy to see how your code nests.
+ Whitespace
  + If your code is all cramped together, it'll be hard to read through it.
+ Inline spacing
  + Make sure you include spaces in your lines (near commas, parentheses, etc.) so it's easy to read each line, too.
+ Line length
  + This one is a bit archaic, but reasonable line lengths help navigate code without horizontal scrolling.
  + Industry standards vary, but in this class we'll stick with **100** characters.
+ Comments
  + If you or someone else needs to maintain your code, comments explaining what's going on when it's not obvious help.
+ Clear, concise solutions
  + Convoluted solutions are hard to follow - even with comments. 
  + A good example of this is a long series of nested if-statements, like you saw in PA08.
    + They're hard to follow and inefficient from a compilation standpoint.
+ Modularity
  + Keep your methods short and specific - each method only needs to do one thing.
  + This way, organizing your code is easy.
  + If you run into an error in your code, you can pinpoint _exactly_ where it occurred.

### Further Reading
+ My favorite code style guide is probably NASA's, summarized [here](http://sdtimes.com/nasas-10-rules-developing-safety-critical-code/).
+ [Facebook](https://github.com/facebook/jcommon/wiki/Coding-Standards) also has a good style guide.
+ Forewarning - standards differ between companies for specific style components, such as line length, tab size, etc.
  + Wherever you are, follow the style guide to maintain consistency.
  + While some parts of your style can vary, general style guidelines do exist - NASA's guide does a great job of this.

## Using IDEs
### What _is_ an IDE?
+ An IDE - or an _Integrated Development Environment_, is a comprehensive software application that provides one place to write, compile, test, and deploy code.
  + Specific featurse will vary, but most modern IDEs are pretty similar.
+ IntelliJ is an IDE made by JetBrains, a company that produces many other IDEs.
  + CLion for C/C++
  + PyCharm for Python
  + WebStorm for JavaScript/PHP/other web development

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
+ *Checkstyle Plugin*
  + CheckStyle-IDEA is a plugin for IntelliJ - i.e., an extra piece of software you can install - that checks your style.
    + No, not your clothes - your code style!
  + You can find it [here](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea).

## Debugging


# FileToKeyboard

FileToKeyboard is a quick and dirty script/program that users can use to quickly paste out input from a file line by line, with optional prefixes and affixes, into a desired active/selected textfield.

So the user must have words/phrases that are split by new lines in a text file, passing these in as arguments.

## Compilation

Clone the repository or download the sourcefile to the directory including the file you wish to pass to active textfield.

### To Compile on Windows:
Open command prompt and navigate to this director.
Type the command

<code>javac FileToKeyboard.java</code>


This should create a .class file with the name "FileToKeyboard".
### To Run on Windows:
Simply next run the command

<code>java ./FileToKeyboard "inputfilename.txt" "optionalPrefix" "optionalAffix"</code>

Run this code from this directory, note the optional prefix and affix arguments, these will be ignored if blank - if you wish to have no prefix but a custom affix, use an empty "" prefix string followed by your custom affix.
The program gives you 3 seconds to then navigate to the desired textfield you wish to have your data pasted to.
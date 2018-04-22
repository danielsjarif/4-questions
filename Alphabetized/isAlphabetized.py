#########################################################################################################################################################
#The comments directly below this is mostly identical or at least similar to the comments that I have put into the actual code. I just integrated
#the comments into the code to explain my thought process.

#Bugs/Errors:
#No where is the defined function, isAlphabetized, called. The desired output (isAlphabetized) is never shown
    #The isAlphabetized function doesn't actually check if input is alphabetized.
    #BufferedReader (originally a java class) reads input, and while input isn't empty,
    #the program, according to the given code, would only print out whatever was inputted
#Finally, isAlphabetized was incorrectly spelled as isAlphabitized

#########################################################################################################################################################

from com.parasoft.api import *
from java.io import *

#Defined function isAlphabetized is never called. Nothing is being outputted.
#Or at least, the desired output (isAlphabetized) is never being shown
#def isAlphabitized(x, context):

def isAlphabetized(x, context):
  reader = BufferedReader(x.getReader()) #BufferedReader (originally a java class) reads input, and while input isn't empty,
  line = reader.readLine() #The program, according to the given code, would only print out whatever was inputted
  while line != None:
    Application.showMessage(reader.readLine())

#Finally, isAlphabetized was incorrectly spelled as isAlphabitized

#############################################################################################################

#No where is the defined function called, nothing is being outputted.
    #The isAlphabetized function doesn't actually check if anything (string, list, etc) is alphabetized.
    #BufferedReader (originally a java class) reads input, and while input isn't empty,
    #The program, according to the given code, would only print out whatever was inputted
#Finally, isAlphabetized was incorrectly spelled as isAlphabitized

#############################################################################################################

from com.parasoft.api import *
from java.io import *

#Defined function isAlphabetized is never called. Nothing is being outputted.
#def isAlphabitized(x, context):

def isAlphabetized(x, context):
  reader = BufferedReader(x.getReader()) #BufferedReader (originally a java class) reads input, and while input isn't empty,
  line = reader.readLine() #The program, according to the given code, would only print out whatever was inputted
  while line != None:
    Application.showMessage(reader.readLine())

#Finally, isAlphabetized was incorrectly spelled as isAlphabitized

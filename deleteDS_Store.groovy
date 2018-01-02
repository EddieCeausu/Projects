#!/usr/bin/env groovy

if (args.length < 1)
{
   println "Please specify directory under which .class files should be removed"
   println "  (including .DS_Store files in sub-directories)."
   System.exit(-1)
}

def directoryName = args[0]
println "Remove .DS_Store files in ${directoryName} and its subdirectories..."
def directory = new File(directoryName)
def classPattern = ~/.*\.DS_Store/
directory.eachFileRecurse(groovy.io.FileType.FILES)
{ file ->
   if (file ==~ classPattern)
   {
      println "Deleting ${file}..."
      file.delete()
   }
}

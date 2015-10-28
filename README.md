# RSbots
why play runescape when you can just write bots?

Create a new run configuration in eclipse.
Download rsbot and the runescape client.
Find jagexappletviewer.jar in the runescape client folder.

Add jagexappletviewer as main class.
Add -Djava.search.path=C:/Users/Mark/workspace/rsscripts/bin
-Dsun.java2d.nodraw=true
-Dcom.jagex.config=http://oldschool.runescape.com/l=en/jav_config.ws
-Xmx512m
-Xss2m
-XX:CompileThreshold=1500
-Xincgc
-XX:+UseConcMarkSweepGC
-XX:+UseParNewGC
-javaagent:C:\Users\Mark\Dev\RSScript\RSBot-7011.jar [path to rsbot jar]
  as vm arguments
Add runescape as program args

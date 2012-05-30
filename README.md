# Nimrod-Java

The Nimrod-Java project provides an easy way to print Nimrod logs from JVM languages through the _nimrod.java.NimrodLogger_ class.

First, you have to select the metric you want to log through one of the following static methods:

* NimrodLogger#forAlert(String name)
* NimrodLogger#forCounter(String name)
* NimrodLogger#forGauge(String name)
* NimrodLogger#forTimer(String name)

The _name_ argument should uniquely identify the metric among its type, and will be part of the full metric name composed as follows: _type.name_.
For example, the following method call (in Java) will produce a metric named _alert.failure_:

    NimrodLogger.forAlert("failure");

Then, you have to actually log the metric value through one of the following instance methods representing well-known log levels:

* NimrodLogger#debug(String value)
* NimrodLogger#debug(String value, String... tags)
* NimrodLogger#info(String value)
* NimrodLogger#info(String value, String... tags)
* NimrodLogger#warn(String value)
* NimrodLogger#warn(String value, String... tags)
* NimrodLogger#error(String value)
* NimrodLogger#error(String value, String... tags)

You can either log the metric value only, or an array of tags too.
For example, the following method call (in Java):

    NimrodLogger.forGauge("requests").info("100", "service:acme");

Will actually produce the following Nimrod log:

    [nimrod][123456789][gauge][requests][100][service:acme]

Please note that the timestamp value is automatically added based on the current time of logging.

Finally, NimrodLogger provides a few static helper methods:

* NimrodLogger#prefixWith(String prefix, String name): will prefix the metric name with the given prefix value.
* NimrodLogger#suffixWith(String name), String suffix: will suffix the metric name with the given suffix value.
* NimrodLogger#prefixWithThreadId(String name): will prefix the metric name with the hash code of the current thread.
* NimrodLogger#suffixWithThreadId(String name): will suffix the metric name with the hash code of the current thread.
* NimrodLogger#start(): will log the "start" metric value for timers.
* NimrodLogger#stop(): will log the "stop" metric value for timers.

NimrodLogger is based on [SLF4J](http://www.slf4j.org/), which provides bridges toward the most well known logging libraries.

You can pick it up from the Clojars maven repository:

    <repository>
        <id>clojars.org</id>
        <url>http://clojars.org/repo</url>
    </repository>

With the following dependency declaration dependency:

    <dependency>
        <groupId>nimrod</groupId>
       <artifactId>nimrod-java</artifactId>
       <version>1.2</version>
    </dependency>

Please note you have to specify the desired SLF4J binding in your own project, as Nimrod-Java doesn't come with any in order not to cause any conflicts.

# Feedback

For everything Nimrod-related, join the nimrod-user group: http://groups.google.com/group/nimrod-user

# License

Copyright (C) 2011-2012 [Sergio Bossa](http://twitter.com/sbtourist)

Distributed under the [Apache Software License](http://www.apache.org/licenses/LICENSE-2.0.html).

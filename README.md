# Overview
`servicemock` is a simple Spring Boot application that generates logging data using [log4j2](https://logging.apache.org/log4j/) and [Java Faker](https://github.com/DiUS/java-faker).

## Getting Started
`servicemock` has the following dependencies:

* [Docker](https://www.docker.com/)
* [Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Maven](https://maven.apache.org/download.cgi)

1) Git-clone this repository.

```
git clone git://github.com/damianmcdonald/servicemock.git servicemock
```

2) Change directory into your clone:

```
cd servicemock
```

3) Use Maven to compile everything:

```
mvn clean install
```

4) Build the Docker image:

```
docker build -t servicemock .
```

4) Run the Docker image:

```
docker run --name servicemock -i -v $PWD/config/logs:/app/logs servicemock
```

5) Check the directory `$PWD/config/logs` for the generation of a log files with different error levels and stacktraces.

```bash
[INFO ] 2019-05-06 11:42:32.643 [main] ServicemockApplication - Starting ServicemockApplication v1.0.0 on adc6768e96bd with PID 1 (/app/servicemock-1.0.0.jar started by root in /)
[DEBUG] 2019-05-06 11:42:32.645 [main] ServicemockApplication - Running with Spring Boot v2.1.4.RELEASE, Spring v5.1.6.RELEASE
[INFO ] 2019-05-06 11:42:32.645 [main] ServicemockApplication - No active profile set, falling back to default profiles: default
[INFO ] 2019-05-06 11:42:33.842 [main] ThreadPoolTaskScheduler - Initializing ExecutorService 'taskScheduler'
[INFO ] 2019-05-06 11:42:33.861 [main] ServicemockApplication - Started ServicemockApplication in 1.441 seconds (JVM running for 2.293)
[INFO ] 2019-05-06 11:42:35.858 [scheduling-1] MockLogger - Request to retreive id: 580514-4523
[INFO ] 2019-05-06 11:42:35.858 [scheduling-1] MockLogger - Retrieved user: Brandon Emmerich
[INFO ] 2019-05-06 11:42:35.858 [scheduling-1] MockLogger - Updating address - old address: Apt. 751 12809 Galen Station, Lake Ellis, KY 31827
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Updating address - new address: Apt. 406 72598 Earnest Center, Heidiport, KS 73073-3687
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Request to retreive id: 080426-5866
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Retrieved user: Maribel Nader
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Updating phoneNumber - old phoneNumber: (939) 649-2307 x2475
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Updating phoneNumber - new phoneNumber: 930.251.1964
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Request to retreive id: 280111-4477
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Retrieved user: Rodney Bogan
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Transfer of: €65.01 to IBAN: DO27T7I405268441360922365118
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Request to retreive id: 850429-1389
[ERROR] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Retrieved user: Yolonda Barrows
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Updating address - old address: 043 Viki Port, Louisside, FL 14971
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Updating address - new address: Apt. 077 96195 Hills Inlet, Port Katriceland, VA 18535
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Request to retreive id: 401120-0625
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Retrieved user: Renaldo Schmitt
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Updating phoneNumber - old phoneNumber: 188-397-4740
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Updating phoneNumber - new phoneNumber: 1-221-606-0035 x37362
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Request to retreive id: 820714-0099
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Retrieved user: Alfredo Wiza
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Transfer of: €92.24 to IBAN: IT46R0295236879Feof6dT4Bh8E
[DEBUG] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Request to retreive id: 490303-6491
[INFO ] 2019-05-06 11:42:35.859 [scheduling-1] MockLogger - Retrieved user: Casie Wilderman
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Updating address - old address: Apt. 294 525 Weissnat Port, Lebsackshire, PA 01909
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Updating address - new address: 7333 Frami Ville, Yosttown, TN 21858-8346
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Request to retreive id: 570911-7302
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Retrieved user: Anna Mann
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Updating phoneNumber - old phoneNumber: 1-663-107-5933 x5582
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Updating phoneNumber - new phoneNumber: (561) 004-3893 x23303
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Request to retreive id: 701012+1999
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Retrieved user: Darrell Mueller
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Transfer of: €53.18 to IBAN: XK198515965376682039
[FATAL] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Request to retreive id: 540429+4273
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Retrieved user: Nick Effertz
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Updating address - old address: Apt. 381 06713 McClure Springs, Mitchellstad, KS 87459-9595
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Updating address - new address: Apt. 501 22373 Waelchi Spur, South Ryan, IN 43879-8118
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Request to retreive id: 770710+2955
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Retrieved user: Jacalyn Bernhard
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Updating phoneNumber - old phoneNumber: 955-883-0144
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Updating phoneNumber - new phoneNumber: 119-280-9513
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Request to retreive id: 710516+8269
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Retrieved user: Saran Rutherford
[INFO ] 2019-05-06 11:42:35.860 [scheduling-1] MockLogger - Transfer of: €29.98 to IBAN: BH28FNDF36pDn73aJ68hCH
[ERROR] 2019-05-06 11:42:35.867 [scheduling-1] MockLogger - Throwing
java.net.SocketTimeoutException: Request timeout to external payment system with transaction id: 080212+0766
	at com.github.damianmcdonald.servicemock.MockLogger.scheduleFixedDelayTask(MockLogger.java:53)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.springframework.scheduling.support.ScheduledMethodRunnable.run(ScheduledMethodRunnable.java:84)
	at org.springframework.scheduling.support.DelegatingErrorHandlingRunnable.run(DelegatingErrorHandlingRunnable.java:54)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.runAndReset(FutureTask.java:308)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$301(ScheduledThreadPoolExecutor.java:180)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:294)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
```

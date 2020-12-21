
# Process Automation with Flowable in the Broadcasting Industry
The broadcasting industry has evolved over the last ten years. It has passed from workflows that exchanged physical material, to being completely digital and based on content. These workflows are now known as content-centric workflows. But now, thanks to platforms such as Netflix or Amazon Prime Video, the industry needs to be even more agile and adopt itself to what the audience is demanding.

With the help of a workflow manager, television channels, video on-demand (VOD) service providers, and other broadcasting participants, can react quicker, and adjust themselves to what the audience is requesting.

In this example, the Saga design pattern was followed, and where **_Flowable_** orchestrates everything. It has the responsibility of telling each participant (micro service), what to do and when. At the center, **_Kafka_** is used as a message bus.

The following sample code, two workflow are created:
- _Material ingestion_: A CMMN case for ingesting new digital content into a Media Asset Management (MAM).
- _Publish content_: A BPM process for delivering digital content to lineal- and video on-demand- service providers.

The full article can be found under [mimacom](https://blog-es.mimacom.com)'s blog. Click [here](https://blog-es.mimacom.com/process-automation-with-flowable-in-broadcasting-industry-part-1/) to check the full series.

## What you’ll need

- [Docker](https://www.docker.com/get-started), as you will need to start [Kafka](http://kafka.apache.org/) and [Flowable-UI](https://flowable.com/open-source/docs/bpmn/ch14-Applications/)
- A favorite IDE. In this post, we use [Intellij Community](https://www.jetbrains.com/idea/download/index.html)
- [JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later. It can be made to work with JDK8, but it will need configuration tweaks. Please check the Spring Boot documentation

## How to run it
1. Clone the project and import it into your favorite IDE.
2. Make sure [Docker](https://www.docker.com/) is running.
3. Open a Terminal window and execute the following commands:  
   ```cmd
   $ cd docker  
   $ docker-compose up -d  
   ```  
   The above command will start a PostgreSQL database, a Mailhog for simulating a mail server, Kafka's Zookeeper and Broker, and finally, Flowable's UI.
4. Next, execute the following commands:  
   ```cmd
   $ cd ../demo-flowable-core  
   $ mvn spring-boot:run -Dspring-boot.run.profiles=postgresql  
   ```  
   The above command will start a custom Spring Boot application that implements Flowable. During the startup, all the required workflows will be automatically deployed.
5. Now, start the service that simulates the rest of the micro services, by executing the following commands:  
   ```cmd
   $ cd ../demo-kafka  
   $ mvn spring-boot:run  
   ```
6. That's it. Now you can start a new case from [Flowable-UI](http://localhost:8091/flowable-ui). Just go to [http://localhost:8091/flowable-ui](http://localhost:8091/flowable-ui) and use the following credentials:
   - User: admin
   - Password: test

## Contribute Code
If you would like to become an active contributor to this project please follow these simple steps:

1. Fork it
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create new Pull Request

## License
The MIT License (MIT)

Copyright (c) 2020, canchito-dev - mimacom

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
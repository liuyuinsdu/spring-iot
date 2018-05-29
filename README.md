# spring-iot
1. Distributed System
Building distributed systems doesn’t need to be complex and error-prone. Spring-iot  offers a platform to help in sharing different resources and capabilities to provide users with a single and integrated coherent network. A distributed system has the following key features:
---- Components in the system are concurrent; 
---- A global clock is not required in a distributed system; 
---- Fault tolerance in a distributed model is greater;
---- Price/performance ratio is much better.
2. Microservices
Microservices (also known as microservice architecture) is a particular way of building applications as suites of services. These services are built around business capabilities and independently deployable by fully automated deployment machinery. What’s more, each service also provides a firm module boundary, even allowing for different services to be written in different programming languages.   

3. Message Queue
A message queue provides an asynchronous communications protocol, a system that puts a message onto a message queue does not require an immediate response to continue processing. To put it simply, the message queue provides a temporary message storage when the destination program is busy or not connected. The use of message queue as the primary inter-process or inter-thread communication mechanism is encouraged in most real-time operating systems.
 
4. Service Registry
Service registry and service discovery are the core of the microservice software architecture. The service registry is a database populated with information on how to dispatch requests to microservice instances. Interactions between the registry and other components can be divided into two groups, each with two subgroups: 
---- Interactions between microservices and the registry (registration)
a. Self-registration
b. Third-party registration
---- Interactions between clients and the registry (discovery)
a. Client-side discovery
b. Server-side discovery

5. MQTT Protocol
MQTT is a publish/subscribe, extremely simple and lightweight messaging protocol, which is designed for constrained devices and low-bandwidth, high-latency or unreliable networks. It is useful for connections with remote locations where a small code footprint is required and/or network bandwidth is at a premium. Besides, it is also ideal for mobile applications because of its small size, low power usage, minimised data packets, and efficient distribution of information to one or many receivers.

6. Real-time Operating System
A real-time operating system (RTOS) is an operating system intended to serve real-time application process data as it comes in, typically without buffering delays. In general, messages acquired by sensing equipment of IoT scenarios are mostly real-time information, which is transmitted to the control ternination via network layer, thus completing the corresponding real-time monitoring and feedback control operation. A key characteristic of an RTOS is the level of its consistency concerning the amount of time it takes to accept and complete an application’s task.  

7. High Concurrency
High concurrency is one of the factors that must be considered in the architectual design of distributed systems. It is usually referred to as an architecture that guarantees the system can handle many requests simultaneously. On the whole, there are two ways to improve the concurrent capacity of a system, that is, scale up and scale out, with the latter being the ultimate solution to enhance the concurrency of the  Internet’s distributed system. 

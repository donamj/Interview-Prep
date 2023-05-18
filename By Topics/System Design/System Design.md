
## System Design
- [An approach to system design](https://www.teamblind.com/post/My-Approach-to-System-Design-V4SJARdx)
- [System Design Primer](https://github.com/donnemartin/system-design-primer)
- [System design template](https://leetcode.com/discuss/career/229177/My-System-Design-Template)
- https://www.educative.io/blog/how-to-prepare-system-design-interview
- https://www.educative.io/blog/distributed-system-design-patterns

# System Design

### Requirements and goals of the system

**Functional requirements:**

1. Upload/download?
2. Expiry
3. Custom alias or links

**Non-functional requirements:**

1. Realiable
2. Available

**Extended requirements:**

1. Analytics
2. Access trhough REST APIs

### Design considerations

1. Amount of data that user can upload
2. Size limit on custom items

### Capacity estimations

Is the service read heavy or write heavy?

### **Traffic Estimates**

1. Get total number or reads/writes in a day
2. Get read/writes per second from that


    | Reads in a day | 5M |
    | --- | --- |
    | Reads per sec | 5M / (24hrs*3600 seconds) ~= 58 reads/sec |
    
    | Writes in a day | 1M |
    | --- | --- |
    | Writes per sec | 1M / (24hrs*3600 seconds) ~= 12 reads/sec |

### **Storage Estimates**

1. Find average per upload
2. Find data written in a day and for 5 or 10 years


    | Data for a write | 10KB |
    | --- | --- |
    | Number of new data set in a day | 1M |
    | Number of data sets in 10 years | 1M * 10 * 365 = 3.6 billion |
    | Storage per day | 1M * 10 KB = 10GB/day |
    | Storing it for 10 years | 36TB |
3. If storing data, we need keys to indentify them in some cases.
    1. If we use base64 encoding and use 6 letters for keys, we get

       64^6 ~= 68.7 billion unique strings

    2. Take 1 byte per char
    3. Size for keys = 3.6 billion * 6 =22 GB,
4. Use 70% capacity model, meaning we should always have 30% extra space

   That makes the storage capacity 36TB + 30% of 36 TB => 51.4 TB


### **Bandwidth Estimates**

Ingress per second = Per second reads * size of a read

Egress per second = Per second writes * size of a write

### **Memory Estimates**

1. Follow 80-20 rule
2. Memory = 0.2 * reads in a day * size of a read

## High level design

In most cases, we need

1. Client
2. Application Server - talk to storage and retrieve data
3. Storage
    1. Main data storage
    2. Metadata storage

Videos can be stored in a distributed file storage system like [HDFS](https://en.wikipedia.org/wiki/Apache_Hadoop#HDFS) or [GlusterFS](https://en.wikipedia.org/wiki/GlusterFS).
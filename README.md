# social-Networking
 
Core domain logic for a social networking application (similar to Twitter) satisfying the features below.

##### How To test : 
1. Run application.
2. Post following tweets : 
```$xslt
localhost:8080/tweet 
a. body : {
       	"username": "Alice",
       	"tweetData": "I love the weather today."
       }
b. body : {
          	"username": "Bob",
          	"tweetData": "Darn! We lost!"
          }
c. body : {
          	"username": "Bob",
          	"tweetData": "Good game though."
          }
d. body: {
         	"username": "Charlie",
         	"tweetData": "I'm in New York today! Anyone wants to have a coffee?"
         }
```
3. Add followers : 
```aidl
localhost:8080/follower
a. body: {
         	"follower": "Charlie",
         	"follows": "Alice"
         }
b. body : {
          	"follower": "Charlie",
          	"follows": "Bob"
          }
```
4. Check Alice timeline : localhost:8080/timeLine/Alice
5. Check Bob timeline : localhost:8080/timeLine/Bob
6. Check Charlie wall : localhost:8080/wall/Charlie 

Models : 
Tweet 
username: string
tweetData: string
time: LocalDateTime

TimeLineMessage: 
tweetData: String,
timeElapsed: string

WallMessage:
userName: String,
tweetData: String,
timeElapsed: string

Follower : 
follower:String, 
follows: String 
1. What would happen if an ArrayList was used instead of a HashSet? Is there an advantage to using a HashSet here?
- An arraylist would have a set amount of space per person. With the HashSet, we can add an unlimited amount of movies watched and not have to worry about defining a set amout of space.

2. We chose: ```java HashMap<String, HashSet<Movie>>``` for the tracker, which made it very easy to answer questions such as "What movies has Alice watched" or "What is Alice's total viewing time". Explain how a different design, such as ```javaHashMap<Movie, HashSet<String>>``` would make certain other questions very easy to answer and others more difficult.
Some easy things that could be by doing name then the hashset of movies is looking up what movies a specific person has watched. Looking at two people and comparing them would also be easier.
Another thing that will be easy is reading the rating and seeing if a specific person has watched the genre of movie
Something that would be difficult this way is finding specifically who watched a movie. You would have to loop through all the names then keep a counter. Another thing that would be difficult is finding the most watched movie. You'd have to loop through a persons movie list and do that for everyone to find who has watched it just like finding who has watched a specific movie.

If it were movie then the set of names, it would be easier to get the set of who has watched it. It also makes getting the amount of people who watched the movie by simply doing map.get(movie).size(). Another thing that would make it easier would be getting if a specific person watched a movie by doing map.get(movie).contains("Alice").
It would make it harder to ask how many movies a specific person has watched. You would have to loop through all the movies to find out who has watched it. Going through to see what genres a specific person has watched will also become difficult.

[Markdown Guide](https://www.markdownguide.org/basic-syntax/)
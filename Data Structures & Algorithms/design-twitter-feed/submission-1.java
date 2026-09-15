class Twitter {
    private int time;
    private Map<Integer, List<int[]>> tweets; // userId -> list of [time, tweetId]
    private Map<Integer, Set<Integer>> followees; // userId -> set of followeeIds

    public Twitter() {
        this.time = 0;
        this.tweets = new HashMap<>();
        this.followees = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
              .add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // Max-Heap to automatically sort tweets so the highest 'time' is at the top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // We need tweets from the user AND everyone they follow
        Set<Integer> users = new HashSet<>(followees.getOrDefault(userId, new HashSet<>()));
        users.add(userId);

        // Gather up to 10 most recent tweets from each person
        for (int user : users) {
            List<int[]> userTweets = tweets.getOrDefault(user, new ArrayList<>());
            
            // Loop backwards through their tweets to get the newest ones first
            int count = 0;
            for (int i = userTweets.size() - 1; i >= 0 && count < 10; i--) {
                maxHeap.offer(userTweets.get(i));
                count++;
            }
        }

        // Pop the top 10 newest tweets overall to build the feed
        List<Integer> feed = new ArrayList<>();
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            feed.add(maxHeap.poll()[1]);
        }
        
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followees.containsKey(followerId)) {
            followees.get(followerId).remove(followeeId);
        }
    }
}
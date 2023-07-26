class VideoSharingPlatform {
    HashMap<Integer, String> videos;
    HashMap<Integer, int[]> metadata;
    PriorityQueue<Integer> availableIds;
    int maxId;
    public VideoSharingPlatform() {
        videos = new HashMap<>();
        metadata = new HashMap<>();
        availableIds = new PriorityQueue<>();
        maxId = -1;
    }
    
    public int upload(String video) {
        int videoId = -1;
        if (!availableIds.isEmpty()) {
            videoId = availableIds.poll();
        } else {
            videoId = maxId + 1;
            maxId++;
        }
        videos.put(videoId, video);
        metadata.put(videoId, new int[3]);
        return videoId;
    }
    
    public void remove(int videoId) {
        if (videos.containsKey(videoId)) {
            videos.remove(videoId);
            metadata.remove(videoId);
            availableIds.add(videoId);
        }
    }
    
    public String watch(int videoId, int startMinute, int endMinute) {
        if (videos.containsKey(videoId)) {
            metadata.get(videoId)[2]++;
            String video = videos.get(videoId);
            return video.substring(startMinute, Math.min(endMinute + 1, video.length()));
        }
        return "-1";
    }
    
    public void like(int videoId) {
        if (metadata.containsKey(videoId)) {
            metadata.get(videoId)[0]++;
        }
    }
    
    public void dislike(int videoId) {
        if (metadata.containsKey(videoId)) {
            metadata.get(videoId)[1]++;
        }
    }
    
    public int[] getLikesAndDislikes(int videoId) {
        if (metadata.containsKey(videoId)) {
            int[] data = metadata.get(videoId);
            return new int[] {data[0], data[1]};
        }
        return new int[]{-1};
    }
    
    public int getViews(int videoId) {
        if (metadata.containsKey(videoId)) {
            int[] data = metadata.get(videoId);
            return data[2];
        }
        return -1;
    }
}

/**
 * Your VideoSharingPlatform object will be instantiated and called as such:
 * VideoSharingPlatform obj = new VideoSharingPlatform();
 * int param_1 = obj.upload(video);
 * obj.remove(videoId);
 * String param_3 = obj.watch(videoId,startMinute,endMinute);
 * obj.like(videoId);
 * obj.dislike(videoId);
 * int[] param_6 = obj.getLikesAndDislikes(videoId);
 * int param_7 = obj.getViews(videoId);
 */
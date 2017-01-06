package com.rodbate.fastdfs;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;




public class TrackerServerGroup {


    private List<TrackerServer> trackerServers = new ArrayList<>();

    private AtomicInteger roundIndex = new AtomicInteger(0);

    private Selector selector;


    public TrackerServer get() {

        if (trackerServers.size() > 0) {

            if (selector == null) {
                selector = Selector.RANDOM;
            }

            switch (selector) {

                case RANDOM:
                    return trackerServers.get(random());
                case ROUND_ROBIN: {
                    int index = roundIndex.getAndIncrement();
                    index = Math.abs(index) % trackerServers.size();
                    return trackerServers.get(index);
                }
                case FIRST:
                    return trackerServers.get(0);
            }
        }

        return null;
    }


    private int random(){

        Random r = new Random();

        return Math.abs(r.nextInt(1000)) % trackerServers.size();
    }


    public List<TrackerServer> getTrackerServers() {
        return trackerServers;
    }

    public void setTrackerServers(List<TrackerServer> trackerServers) {
        this.trackerServers = trackerServers;
    }

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }


    public enum Selector {

        RANDOM,
        ROUND_ROBIN,
        FIRST
    }


}



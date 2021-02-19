package io.qyi.mail.queue.service;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @program: queue
 * @description:
 * @author: 落叶随风
 * @create: 2021-02-18 09:57
 **/
public class QueueService {
    private static final ConcurrentLinkedQueue queue;
    static {
        queue = new ConcurrentLinkedQueue();
    }

    public static ConcurrentLinkedQueue getQueue() {
        return queue;
    }
}

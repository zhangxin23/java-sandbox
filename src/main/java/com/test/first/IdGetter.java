package com.test.first;

/**
 * Created by zhangxin on 15-6-17.
 */
public class IdGetter {
    private long lasttimestamp = -1L;
    private long tmepoc = 1420041600000L;
    private long machineId = 0L;
    private long sequence = 0L;

    private int timestampShiftBits = 24;
    private int machineIdShiftBits = 12;
    private int sequenceShiftBits = 12;

    private long sequenceMask = -1L ^ (-1L << sequenceShiftBits);

    private long tilNextMillis(long lasttimestamp) {
        long timestamp = System.currentTimeMillis();
        while(timestamp <= lasttimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public synchronized long getId(int machineId) {
        long timestamp = System.currentTimeMillis();

        if(timestamp < lasttimestamp) {
            throw new RuntimeException("[Error] less than last timestamp");
        } else if(timestamp == lasttimestamp) {
            sequence = (sequence + 1) % sequenceMask;
            if(sequence == 0) {
                timestamp = tilNextMillis(lasttimestamp);
            }
        } else {
            sequence = 0;
        }

        lasttimestamp = timestamp;

        return (lasttimestamp - tmepoc) << timestampShiftBits |
                machineId << machineIdShiftBits |
                sequence;
    }

    public static void main(String[] args) {
//        IdGetter idGetter = new IdGetter();
//        long id = idGetter.getId(101);

        long id = 245918729911672832L;
        System.out.println(id);
        long timestamp = id >> 24;
        long machineId = id >> 12 & 0xFFF;
        long sequence = id & 0xFFF;
        System.out.println("timestamp: " + (timestamp + 1420041600000L));
        System.out.println("machineId: " + machineId);
        System.out.println("sequence: " + sequence);
    }
}

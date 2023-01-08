package mao.aggregate_pay_common.utils;

import org.junit.jupiter.api.Test;

class IdWorkerUtilsTest
{
    /**
     * Method under test: {@link IdWorkerUtils#getInstance()}
     */
    @Test
    void testGetInstance()
    {
        IdWorkerUtils.getInstance();
    }


    @Test
    void nextId()
    {
        System.out.println(IdWorkerUtils.getInstance().nextId());
        System.out.println(IdWorkerUtils.getInstance().nextId());
        System.out.println(IdWorkerUtils.getInstance().nextId());
        System.out.println(IdWorkerUtils.getInstance().nextId());
        System.out.println(IdWorkerUtils.getInstance().nextId());
        System.out.println(IdWorkerUtils.getInstance().nextId());
        System.out.println(IdWorkerUtils.getInstance().nextId());
        System.out.println(IdWorkerUtils.getInstance().nextId());
        System.out.println(IdWorkerUtils.getInstance().nextId());
        System.out.println(IdWorkerUtils.getInstance().nextId());
        System.out.println(IdWorkerUtils.getInstance().nextId());
    }
}


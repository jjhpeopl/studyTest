package com.jjh.sky.loadBalance.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jiajianhong on 16/9/14.
 */
public class RandomTest {

    public static RandomDomain randomBalance() {
        Random random = new Random();

        // 先生成一个待测试的list
        List<RandomDomain> randomDomainList = new ArrayList<RandomDomain>();
        randomDomainList.add(new RandomDomain("1", 3));
        randomDomainList.add(new RandomDomain("2", 3));
        randomDomainList.add(new RandomDomain("3", 1));

        boolean sameWeight = true;
        int totalWeight = 0;
        int[] weightAccumulate = new int[randomDomainList.size()];
        int i = 0;
        // 先计算总权重,并查看是否所有权重都相同
        for (RandomDomain randomDomain : randomDomainList) {
            // 获取当前权重
            double curWeight = randomDomain.getWeight();

            // 累计权重
            totalWeight += curWeight;
            weightAccumulate[i++] = totalWeight;

            // 判断权重跟上一个是否一样,先拿sameWeight判断,是因为若是已经不一样,就没必要改变了
            if (sameWeight && i > 0 && curWeight != weightAccumulate[(i-1)]) {
                sameWeight = false;
            }
        }

        // 若权重不相同,而且总权重大于0,则按总权重随机
        if (!sameWeight && totalWeight > 0) {
            random.setSeed(1L);
            double offset = random.nextDouble() * totalWeight;

            for (int j = 0; j < weightAccumulate.length; j ++) {
                if (offset < weightAccumulate[j]) {
                    return randomDomainList.get(j);
                }
            }
        }

        // 如果权重相同,或总权重为0,随机取一个
        return randomDomainList.get(random.nextInt(weightAccumulate.length));
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100 ; i ++) {
            Thread.sleep(10);
            System.out.println(RandomTest.randomBalance());
        }
    }

}

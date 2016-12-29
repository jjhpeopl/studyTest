package com.jjh.sky.daikuan;

import java.math.BigDecimal;

/**
 * Created by jiajianhong on 16/12/27.
 */
public class DengEBenXi {

    // 贷款总额
    private static final BigDecimal daiMoney = new BigDecimal(100000);

    // 贷款利率,年利率
    private static final BigDecimal nian_lilv = new BigDecimal(0.059);

    // 收益利率,年利率
    private static final BigDecimal zhuanqu_lilv = new BigDecimal(0.09);

    // 贷款总月份
    private static final int month_all = 24;

    public static void main(String[] args) {
        // 先计算一下月利率是多少
        BigDecimal yue_lilv = nian_lilv.divide(new BigDecimal(12), 7, BigDecimal.ROUND_HALF_UP);

        System.out.println("月利率:" + yue_lilv);

        // 计算每个月的还款额
        BigDecimal dividors = yue_lilv.add(new BigDecimal(1)).pow(month_all).subtract(new BigDecimal(1));
        BigDecimal beichushu =  daiMoney.multiply(yue_lilv).multiply(yue_lilv.add(new BigDecimal(1)).pow(month_all));
        BigDecimal yue_huan = beichushu.divide(dividors, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("每个月还款:" + yue_huan);

        // 计算总利息
        BigDecimal AllLiXi = yue_huan.multiply(new BigDecimal(month_all)).subtract(daiMoney);
        System.out.println("总利息:" + AllLiXi);

        // 计算获取的利息
        BigDecimal allZhuanLi = new BigDecimal(0);
        BigDecimal tmpAll = daiMoney;
        for (int i = 1; i <= month_all; i ++) {
            BigDecimal perMonthZhuan = null;
            if (i == 1) {
                perMonthZhuan = daiMoney.multiply(zhuanqu_lilv).divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_UP);
            } else {
                BigDecimal tmp1 =  daiMoney.multiply(yue_lilv).multiply(yue_lilv.add(new BigDecimal(1)).pow(i - 2));
                BigDecimal tmp2 = yue_lilv.add(new BigDecimal(1)).pow(month_all).subtract(new BigDecimal(1));
                BigDecimal perMonthMoney = tmp1.divide(tmp2, 2, BigDecimal.ROUND_HALF_UP);
                tmpAll = tmpAll.subtract(perMonthMoney);


                perMonthZhuan = tmpAll.multiply(zhuanqu_lilv).divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_UP);
            }

            allZhuanLi = allZhuanLi.add(perMonthZhuan);
            System.out.println("第" + i + "月赚取利息:" + perMonthZhuan);
        }

        System.out.println("赚取的总利息:" + allZhuanLi);
    }

}

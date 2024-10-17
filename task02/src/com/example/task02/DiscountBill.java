package com.example.task02;

import java.util.List;
import java.util.ArrayList;

public class DiscountBill extends Bill {
    private final double discountPercentage;

    public DiscountBill(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public long getPrice() {
        long originalPrice = super.getPrice();
        long discountAmount = (long) (originalPrice * (discountPercentage / 100));
        return originalPrice - discountAmount;
    }

    /**
     * Получает размер скидки в процентах
     *
     * @return размер скидки
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * Получает абсолютное значение скидки
     *
     * @return абсолютная сумма скидки
     */
    public long getAbsoluteDiscount() {
        long originalPrice = super.getPrice();
        long discountAmount = (long) (originalPrice * (discountPercentage / 100));
        return discountAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Скидка: ").append(discountPercentage).append("%\n");
        sb.append("Итоговая сумма к оплате: ").append(getPrice()).append("\n");
        sb.append("Сумма скидки: ").append(getAbsoluteDiscount()).append("\n");
        return sb.toString();
    }
}
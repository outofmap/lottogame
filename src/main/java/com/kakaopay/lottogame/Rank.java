package com.kakaopay.lottogame;

import java.util.Objects;

public class Rank {
    private Integer rank;

    public Rank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank1 = (Rank) o;
        return Objects.equals(rank, rank1.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank);
    }
}

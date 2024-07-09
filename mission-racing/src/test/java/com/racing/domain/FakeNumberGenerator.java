package com.racing.domain;

public class FakeNumberGenerator implements NumberGenerator{
    @Override
    public int generateRandom() {
        return 5;
    }
}

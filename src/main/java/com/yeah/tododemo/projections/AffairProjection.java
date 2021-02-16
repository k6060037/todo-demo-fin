package com.yeah.tododemo.projections;

import java.util.UUID;

public interface AffairProjection {
    UUID getId();
    String getAffairDescription();
    int getAffairPriority();
}

package com.yeah.tododemo.projections;

import java.util.UUID;

public interface DeletedAffairProjection {
    UUID getId();
    String getDeletedAffairDescription();
    int getDeletedAffairPriority();
}

package com.bookstore.app.dto;

import java.util.Set;
import java.util.UUID;

// 1:24 min
public record BookRecordDto(String title,
                            UUID publisherId,
                            Set<UUID> authorIds,
                            String reviewComment
) {

}

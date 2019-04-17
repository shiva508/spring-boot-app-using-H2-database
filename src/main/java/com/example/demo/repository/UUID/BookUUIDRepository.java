package com.example.demo.repository.UUID;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.UUID.BookUUID;

@Repository
public interface BookUUIDRepository extends JpaRepository<BookUUID, UUID> {

}

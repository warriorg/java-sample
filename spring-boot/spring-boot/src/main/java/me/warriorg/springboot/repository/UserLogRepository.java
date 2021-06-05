package me.warriorg.springboot.repository;

import me.warriorg.springboot.model.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRepository extends JpaRepository<UserLog, Long> {
}

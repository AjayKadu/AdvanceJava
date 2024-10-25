package com.sunbeam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingDao extends JpaRepository<Meeting, Integer> {

}

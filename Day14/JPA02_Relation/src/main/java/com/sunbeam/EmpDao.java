/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 25, 2024
 */

package com.sunbeam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpDao extends JpaRepository<Employee, Integer> {

}

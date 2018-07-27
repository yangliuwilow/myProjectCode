package com.willow.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee, Integer> {


    public List<Employee> findByLastnameLike(String lastName);

}

package com.example.case_study.repository.customer;

import com.example.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where delete_status=false ", nativeQuery = true)
    List<Customer> findAll();

    @Query(value = "select * from customer where customer_name like %:nameSearch% and customer_email like %:emailSearch%" +
            " and customer_type_id like %:customerTypeSearch% and delete_status=false", nativeQuery = true)
    Page<Customer> searchCustomer(@Param("nameSearch") String nameSearch,
                                  @Param("emailSearch") String emailSearch,
                                  @Param("customerTypeSearch") String customerTypeSearch, Pageable pageable);

    @Query(value = "update customer set delete_status=true where customer_id = :idDelete", nativeQuery = true)
    void deleteCustomer(@Param("idDelete")Integer id);

}

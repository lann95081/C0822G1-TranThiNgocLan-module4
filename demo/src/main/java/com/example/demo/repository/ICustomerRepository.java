package com.example.demo.repository;

import com.example.demo.dto.ICustomerDto;
import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
//    @Query(value = "select * from customer where customer_name like %:nameSearch% and " +
//            "customer_email like %:emailSearch% and delete_status = false",
//            nativeQuery = true)
//    Page<Customer> searchCustomer(@Param("nameSearch") String nameSearch, @Param("emailSearch") String emailSearch,
//                                  Pageable pageable);
//
    @Query(value = "select customer.customer_id as id, customer.customer_name as name, customer.customer_id_card as idCard, " +
            "customer.customer_phone as phone, customer.customer_email as email, customer.customer_address as address, " +
            "customer.customer_birthday as birthday, customer.customer_gender as gender, customer_type.customer_type_name as type " +
            "from customer " +
            "join customer_type on customer.customer_type_id = customer_type.customer_type_id " +
            "where customer.customer_name like %:nameSearch% " +
            "and customer.customer_email like %:emailSearch%" +
            " and customer_type.customer_type_name like %:typeSearch% and delete_status = false",
            countQuery = "select count(*) " +
                    "from customer " +
                    "join customer_type on customer.customer_type_id = customer_type.customer_type_id " +
                    "where customer.customer_name like %:nameSearch% " +
                    "and customer.customer_email like %:emailSearch%" +
                    " and customer_type.customer_type_name like %:typeSearch% and delete_status = false",
            nativeQuery = true)
    Page<ICustomerDto> searchCustomer(@Param("nameSearch") String nameSearch, @Param("emailSearch") String emailSearch,
                                      @Param("typeSearch") String typeSearch, Pageable pageable);

    @Modifying
    @Query(value = "update customer set delete_status = true where customer_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}

package com.example.basic.repository;

import java.util.List;

import com.example.basic.model.Sunbyul;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 생략가능
public interface SunbyulRepository 
    extends JpaRepository<Sunbyul, Integer> {
    List<Sunbyul> findByAddressContaining(String address);
    Page<Sunbyul> findByAddressContaining(String address, Pageable page);
}

// class Test implements JpaRepository<Sunbyul, Integer> {

//     @Override
//     public Page<Sunbyul> findAll(Pageable pageable) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Sunbyul> S save(S entity) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public Optional<Sunbyul> findById(Integer id) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public boolean existsById(Integer id) {
//         // TODO Auto-generated method stub
//         return false;
//     }

//     @Override
//     public long count() {
//         // TODO Auto-generated method stub
//         return 0;
//     }

//     @Override
//     public void deleteById(Integer id) {
//         // TODO Auto-generated method stub
        
//     }

//     @Override
//     public void delete(Sunbyul entity) {
//         // TODO Auto-generated method stub
        
//     }

//     @Override
//     public void deleteAllById(Iterable<? extends Integer> ids) {
//         // TODO Auto-generated method stub
        
//     }

//     @Override
//     public void deleteAll(Iterable<? extends Sunbyul> entities) {
//         // TODO Auto-generated method stub
        
//     }

//     @Override
//     public void deleteAll() {
//         // TODO Auto-generated method stub
        
//     }

//     @Override
//     public <S extends Sunbyul> Optional<S> findOne(Example<S> example) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Sunbyul> Page<S> findAll(Example<S> example, Pageable pageable) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Sunbyul> long count(Example<S> example) {
//         // TODO Auto-generated method stub
//         return 0;
//     }

//     @Override
//     public <S extends Sunbyul> boolean exists(Example<S> example) {
//         // TODO Auto-generated method stub
//         return false;
//     }

//     @Override
//     public <S extends Sunbyul, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public List<Sunbyul> findAll() {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public List<Sunbyul> findAll(Sort sort) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public List<Sunbyul> findAllById(Iterable<Integer> ids) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Sunbyul> List<S> saveAll(Iterable<S> entities) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public void flush() {
//         // TODO Auto-generated method stub
        
//     }

//     @Override
//     public <S extends Sunbyul> S saveAndFlush(S entity) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Sunbyul> List<S> saveAllAndFlush(Iterable<S> entities) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public void deleteAllInBatch(Iterable<Sunbyul> entities) {
//         // TODO Auto-generated method stub
        
//     }

//     @Override
//     public void deleteAllByIdInBatch(Iterable<Integer> ids) {
//         // TODO Auto-generated method stub
        
//     }

//     @Override
//     public void deleteAllInBatch() {
//         // TODO Auto-generated method stub
        
//     }

//     @Override
//     public Sunbyul getOne(Integer id) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public Sunbyul getById(Integer id) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Sunbyul> List<S> findAll(Example<S> example) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Sunbyul> List<S> findAll(Example<S> example, Sort sort) {
//         // TODO Auto-generated method stub
//         return null;
//     }

// }
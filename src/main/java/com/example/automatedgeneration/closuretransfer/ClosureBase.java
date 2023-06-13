package com.example.automatedgeneration.closuretransfer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

@Setter
@Getter
//@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class ClosureBase {

//    private Class<U> genericType;

//    public ClosureBase() {
//        Class<?> thisClass = getClass();
//        Type genericSuperclass = thisClass.getGenericSuperclass();
//        ParameterizedType parameterizedGenericSuperclass = (ParameterizedType) genericSuperclass;
//        Type[] typeArgs = parameterizedGenericSuperclass.getActualTypeArguments();
//        this.genericType = (Class<U>) typeArgs[0];
//    }
//
//    protected Class<?> getGenericType() {
//        return this.genericType;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ancestor;

    private Long descendant;

    private Integer depth;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

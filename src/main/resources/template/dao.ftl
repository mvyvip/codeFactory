package ${basePackage}.${typePackage};

import org.springframework.stereotype.Repository;

import ${basePackage}.${modelPackage}.${className};

@Repository
public interface I${className}Dao extends IBaseDao<${className}, ${keyType}> {

}

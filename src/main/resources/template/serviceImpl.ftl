package ${basePackage}.${servicePackage}.${typePackage};

import org.springframework.stereotype.Service;

import ${basePackage}.${modelPackage}.${className};
import ${basePackage}.${servicePackage}.I${className}Service;

@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className}, ${keyType}> implements I${className}Service {

}

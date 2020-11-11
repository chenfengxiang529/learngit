##导入宏定义
$!define

##设置表后缀（宏定义）
#setTableSuffix("Service")

##保存文件（宏定义）
#save("/api/service", "Service.java")

##包路径（宏定义）
#setPackageSuffix("api.service")

import com.baomidou.mybatisplus.extension.service.IService;
import $!{tableInfo.savePackageName}.entity.$!tableInfo.name;

##表注释（宏定义）
#tableComment("表服务接口")
public interface $!{tableName} extends IService<$!tableInfo.name> {

}